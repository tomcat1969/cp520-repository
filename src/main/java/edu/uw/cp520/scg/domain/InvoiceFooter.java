package edu.uw.cp520.scg.domain;

import java.util.Locale;

final class InvoiceFooter {
    private static final String PAGE_BREAK =
            "========================================================================================";
    private int pageNumber;

    private String businessName;

    public InvoiceFooter(final String businessName) {
        this.businessName = businessName;
    }

    public void incrementPageNumber() {
        pageNumber++;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"%n%n%n%-69s Page: %3d%n%s%n",
                businessName, pageNumber,PAGE_BREAK);
    }
}
