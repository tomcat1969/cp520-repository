package edu.uw.cp520.scg.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


/**
 * class for evaluating if a date falls within a range
 */
public final class DateRange {

    /**
     * Encapsulates a range of two dates, inclusive of the start date and end date.
     */
    private final LocalDate startDate;
    private final LocalDate endDate;

    public DateRange(final LocalDate startDate, final LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DateRange(final String start, final String end) {
        this.startDate = LocalDate.parse(start, DateTimeFormatter.ISO_LOCAL_DATE);
        this.endDate = LocalDate.parse(end,DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * Construct a DateRange for the given month, the date range shall span the entire month,
     * from the first day of the month through the last day of the month.
     * @param month
     * @param year
     */
    public DateRange(final Month month, final int year) {
        startDate = LocalDate.of(year,month,1);
        endDate = startDate.plusDays(startDate.lengthOfMonth()-1L);
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Returns true if the specified date is within the range start date <= date <= end date.
     * @param date
     * @return
     */
    public boolean isInRange(final LocalDate date) {
        return !((date.isBefore(startDate)) || (date.isAfter(endDate)));
    }
}
