package app;

import java.io.Console;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.Invoice;
import edu.uw.cp520.scg.domain.TimeCard;

import edu.uw.ext.util.ListFactory;

/**
 * Assignment 03 application.
 */
public final class Assignment03 {
    /** Character encoding to use. */
    private static final String ENCODING = "ISO-8859-1";

    /** This class' logger. */
    private static final Logger log = LoggerFactory.getLogger(Assignment03.class);

    /**
     * Prevent instantiation.
     */
    private Assignment03() {
    }

    /**
     * The application method.
     *
     * @param args Command line arguments.
     * @throws Exception if raised
     */
    public static void main(final String[] args)  throws Exception {
        // Create lists to be populated by factory
        final List<ClientAccount> accounts = new ArrayList<>();
        final List<Consultant> consultants = new ArrayList<>();
        final List<TimeCard> timeCards = new ArrayList<>();
        ListFactory.populateLists(accounts, consultants, timeCards);
        // Print them
        ListFactory.printTimeCards(timeCards);

        // Create the Invoices
        final List<Invoice> invoices = ListFactory.createInvoices(accounts, timeCards);

        // Print them
        Console console = System.console();
        try {
            @SuppressWarnings("resource")  // don't want to close console or System.out
            PrintWriter consoleWrtr = (console != null) ? console.writer()
                    : new PrintWriter(new OutputStreamWriter(System.out, ENCODING), true);
            consoleWrtr.printf("%n==================================================================================%n");
            consoleWrtr.printf("=============================== I N V O I C E S ==================================%n");
            consoleWrtr.printf("==================================================================================%n%n");
            Invoice invoice = invoices.get(0);
            consoleWrtr.printf("%s%n", invoice.toReportString());
            invoice = invoices.get(1);
            consoleWrtr.printf("%s%n", invoice.toReportString());
        } catch (UnsupportedEncodingException e) {
            log.error("Printing of invoices failed.", e);
        }
        // Now print it to a file
        try (PrintWriter out = new PrintWriter("invoices.txt", ENCODING)) {
            ListFactory.printInvoices(invoices, out);
        } catch (final IOException ex) {
            log.error("Unable to print invoices to file.", ex);
        }
    }
}
