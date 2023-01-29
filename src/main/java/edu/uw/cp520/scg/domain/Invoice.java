package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.StateCode;
import org.apache.derby.iapi.jdbc.AutoloadedDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * Invoice encapsulates the attributes and behavior to create client
 * invoices for a given time period from time cards. The Invoice maintains
 * are collection of invoice line items; each containing date, hours and other
 * billing information, these constitute what is being billed for with this Invoice.
 * The invoice will limit the items billed on it to a single month and also has a separate
 * invoice date which reflects the date the invoice was generated. The invoicing business' name
 * and address are obtained from a properties file. The name of the property file is specified
 * by the PROP_FILE_NAME static member.
 */
public class Invoice {
    private static final String PROP_FILE_NAME = "/invoice.properties";
    private static final String BUSINESS_NAME_PROP = "business.neme";
    private static final String BUSINESS_STREET_PROP = "business.street";
    private static final String BUSINESS_CITY_PROP = "business.city";
    private static final String BUSINESS_STATE_PROP = "business.state";
    private static final String BUSINESS_ZIP_PROP = "business.zip";
    private static final String NA = "N/A";
    private static final int  ITEMS_PER_PAGE = 5;
    private static final Logger log = LoggerFactory.getLogger(Invoice.class);

    private static final String TO_STRING_FORMAT = "Invoice for: %s,Date: %2$tb %2$td,%2$tY%n";

    private static final String BIZ_NAME;

    private static final Address BIZ_ADDRESS;

    static {
        final Properties invoiceProps = new Properties();
        try (InputStream in = Invoice.class.getResourceAsStream(PROP_FILE_NAME)) {
            invoiceProps.load(in);
        } catch (final IOException e) {
            log.warn("Unable to read properties file.",e);
        }

        BIZ_NAME = invoiceProps.getProperty(BUSINESS_NAME_PROP,NA);
        final String bizStreet = invoiceProps.getProperty(BUSINESS_STREET_PROP,NA);
        final String bizCity = invoiceProps.getProperty(BUSINESS_CITY_PROP,NA);
        final String bizState = invoiceProps.getProperty(BUSINESS_STATE_PROP,NA);
        final String bizZip = invoiceProps.getProperty(BUSINESS_ZIP_PROP,NA);
        BIZ_ADDRESS = new Address(
                bizStreet,bizCity, StateCode.valueOf(bizState),bizZip
        );


    }

    private final ClientAccount client;
    private final LocalDate startDate;
    private final LocalDate invoiceDate;
    private int totalHours;
    private int totalCharges;
    private final List<InvoiceLineItem> lineItems;

    public Invoice(final ClientAccount client, final Month invoiceMonth,
                   final int invoiceYear) {
        this.client = client;
        this.lineItems = new ArrayList<>();

        this.invoiceDate = LocalDate.now();
        startDate = LocalDate.of(invoiceYear,invoiceMonth,1);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Month getInvoiceMonth(){
        return startDate.getMonth();
    }

    public ClientAccount getClientAccount(){
        return client;
    }

    public int getTotalHours(){
        return totalHours;
    }

    public int getTotalCharges() {
        return totalCharges;
    }

    public void addLineItem(final InvoiceLineItem lineItem) {
        lineItems.add(lineItem);
        totalHours += lineItem.getHours();
        totalCharges += lineItem.getCharge();

    }

    /**
     * Extract the billable hours for this Invoice's client from the input
     * TimeCard and add them to the collection of line items.
     * @param timeCard
     */
    public void extractLineItems(final TimeCard timeCard) {
        final List<ConsultantTime> billableHoursList = timeCard.getBillableHoursForClient(client.getName());
        for (final ConsultantTime consultantTime : billableHoursList) {
            final LocalDate timeCardDate = consultantTime.getDate();
            if(timeCardDate.getYear() == startDate.getYear()
                        &&
               timeCardDate.getMonth() == startDate.getMonth()) {
                final InvoiceLineItem currentItem = new InvoiceLineItem(
                        timeCardDate,
                        timeCard.getConsultant(),
                        consultantTime.getSkillType(),
                        consultantTime.getHours()
                );
                addLineItem(currentItem);
            }
        }
    }


    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT,client.getName(),startDate);
    }


    /**
     * Create a formatted string containing the printable invoice.
     * @return
     */
    public String toReportString(){
        final InvoiceHeader invoiceHeader = new InvoiceHeader(BIZ_NAME,BIZ_ADDRESS,client,invoiceDate,startDate);
        final InvoiceFooter invoiceFooter = new InvoiceFooter(BIZ_NAME);
        final StringBuilder sb = new StringBuilder();
        final Formatter formatter = new Formatter(sb,Locale.US);
        formatter.format("%s",invoiceHeader);

        for(int i = 0, itemsPrinted = 1; i < lineItems.size();i++,itemsPrinted++) {
            final InvoiceLineItem invoiceLineItem = lineItems.get(i);
            formatter.format("%s%n",invoiceLineItem);
            if(itemsPrinted % ITEMS_PER_PAGE == 0) {
                invoiceFooter.incrementPageNumber();
                formatter.format("%s%n%s",invoiceFooter,invoiceHeader);
            }
        }
        invoiceFooter.incrementPageNumber();
        formatter.format("%nTotal: %60d  %,10.2f", totalHours,(double)totalCharges)
                .format("%s",invoiceFooter);
        final String s = formatter.toString();
        formatter.close();
        return s;
    }
}
