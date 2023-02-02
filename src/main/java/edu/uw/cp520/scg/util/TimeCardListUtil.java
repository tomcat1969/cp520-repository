package edu.uw.cp520.scg.util;

import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.TimeCard;

import java.sql.Time;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 Utility class for processing TimeCard lists.
 */
public class TimeCardListUtil {
    private static final int DAYS_PER_WEEK = 6;

    private static final TimeCardConsultantComparator consultantComparator =
            new TimeCardConsultantComparator();

    private TimeCardListUtil() {
    }

    /**
     * Sorts this list into ascending order, by the start date.
     * @param timeCards
     */
    public static void sortByStartDate(final List<TimeCard> timeCards) {
        Collections.sort(timeCards);
    }

    /**
     * Sorts this list into ascending order by consultant name..
     * @param timeCards
     */
    public static void sortByConsultantName(final List<TimeCard> timeCards) {
        Collections.sort(timeCards,consultantComparator);
    }

    /**
     * Get a list of TimeCards that cover dates that fall within a date range.
     * @param timeCards
     * @param dateRange
     * @return
     */
    public static List<TimeCard> getTimeCardsForDateRange(final List<TimeCard> timeCards,final DateRange dateRange) {
        return timeCards.stream().filter(tc->dateRange.isInRange(tc.getWeekStartingDay())
                    ||
                dateRange.isInRange(tc.getWeekStartingDay().plusDays(DAYS_PER_WEEK)))
                .collect(Collectors.toList());
    }

    /**
     * Get a list of TimeCards for the specified consultant.
     * @param timeCards
     * @param consultant
     * @return
     */
    public static List<TimeCard> getTimeCardsForConsultant(final List<TimeCard> timeCards,
                                                           final Consultant consultant) {
        return timeCards.stream().filter(tc->tc.getConsultant().equals(consultant))
                .collect(Collectors.toList());
    }
}
