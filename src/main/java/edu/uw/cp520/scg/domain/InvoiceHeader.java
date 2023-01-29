package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.Address;

import java.time.LocalDate;
import java.util.Formatter;
import java.util.Locale;

public class InvoiceHeader {
    private static final String HEADER_FORMAT =
            "%s%n%s%n%nInvoice for:%n%s%nInvoice For Month of: %4$tB %4$tY%nInvoice Date: %5$tB %5$td%n";
    private static final String LINE_HEADER_FORMAT =
            "Date    Consultant                  Skill                    Hours   Charge%n"
            +"------  --------------------------  ---------------------  ------   -------%n";

    private final ClientAccount client;

    private final LocalDate invoiceDate;

    private final LocalDate invoiceForMonth;

    private final String businessName;

    private final Address businessAddress;


    public InvoiceHeader(final String businessName,final Address businessAddress,
                         final ClientAccount client, final LocalDate invoiceDate,
                         final LocalDate invoiceForMonth) {
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.client = client;
        this.invoiceDate = invoiceDate;
        this.invoiceForMonth = invoiceForMonth;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final Formatter formatter = new Formatter(sb, Locale.US);
        formatter.format(HEADER_FORMAT,businessName,businessAddress,
                client,invoiceForMonth,invoiceDate)
                .format(LINE_HEADER_FORMAT);
        final String s = formatter.toString();
        formatter.close();
        return s;
    }
}
