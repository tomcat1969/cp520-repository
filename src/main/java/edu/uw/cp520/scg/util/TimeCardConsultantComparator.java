package edu.uw.cp520.scg.util;

import edu.uw.cp520.scg.domain.TimeCard;

import java.util.Comparator;


/**
 * implementation of Comparator interface, compare timecards based on the consultant,
 * the beginning date, total billable hours and lastly total non-billable hours
 */
public final class TimeCardConsultantComparator implements Comparator<TimeCard> {
    private static Comparator<TimeCard> theComparator = Comparator.comparing(TimeCard::getConsultant)
            .thenComparing(TimeCard::getWeekStartingDay)
            .thenComparing(TimeCard::getTotalBillableHours)
            .thenComparing(TimeCard::getTotalNonBillableHours);


    @Override
    public int compare(TimeCard o1, TimeCard o2) {
        return theComparator.compare(o1,o2);
    }
}
