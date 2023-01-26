package edu.uw.cp520.scg.domain;


import java.time.LocalDate;
import java.util.*;

/**
 * Represents a time card capable of storing a collection of a consultant's
 * billable and non-billable hours for a week. The TimeCard maintains a
 * collection of ConsultantTime, and provides access to number of hours
 * and time billed to a particular client.
 * @author Lin Huang
 */
public final class TimeCard {

    private static final String HEADER_FORMAT ="Consultant: %-28s Week Starting: %2$tb %2$td, %2$tY%n";
    private static final String TO_STRING_FORMAT = "TimeCard for: %s, WeekStarting: %2$tb %2$td, %2$tY%n";
    private static final String LINE_HEADER_FORMAT = String.format("%-28s %-10s  %5s  %11s%n"
                 + "--------------------        ----------   --------     ------------------%n",
            "Account","Date","Hours","Skill");
    private static final String CARD_BORDER = "======================================================================%n";
    private static final String LINE_FORMAT = "%-28s %2$tm/%2$td/%2$tY %3$5d %4$s%n";
    private static final String SUMMARY_LINE_FORMAT = "%-39s   %5d%n";
    private static final String BILLABLE_TIME_HEADER_FORMAT = "%nBillable Time:%n";
    private static final String NON_BILLABLE_TIME_HEADER_FORMAT = "%nNon-billable Time:%n";
    private static final String SUMMARY_HEADER_FORMAT = "%nSummary:%n";




    private final Consultant consultant;
    private final LocalDate weekStartingDay;


    private final  List<ConsultantTime> consultingHours;

    private int totalBillableHours;

    private int totalNonBillableHours;



    /**
     * Creates a new instance of TimeCard
     * @param consultant
     * @param weekStartingDay
     */
    public TimeCard (final Consultant consultant, final LocalDate weekStartingDay) {
        this.consultant = consultant;
        this.weekStartingDay = weekStartingDay;
        this.totalBillableHours = 0;
        this.totalNonBillableHours = 0;
        this.consultingHours = new LinkedList<>();
    }

    /**
     * Add a ConsultantTime object to the collection maintained by this TimeCard.
     * @param consultantTime
     */
    public void addConsultantTime(final ConsultantTime consultantTime) {
        this.consultingHours.add(consultantTime);
        final int addedHours = consultantTime.getHours();
        if(consultantTime.isBillable()) {
            totalBillableHours += addedHours;
        } else {
            totalNonBillableHours += addedHours;
        }
    }

    /**
     * Getter for consultant property.
     * @return
     */
    public Consultant getConsultant() {
        return consultant;
    }

    /**
     * Getter for weekStartingDay property.
     * @return
     */
    public LocalDate getWeekStartingDay() {
        return weekStartingDay;
    }

    /**
     * Getter for consultingHours property.
     * @return
     */
    public List<ConsultantTime> getConsultingHours() {
        return consultingHours;
    }

    /**
     * Getter for billableHours property.
     * @return
     */
    public int getTotalBillableHours() {
        return totalBillableHours;
    }

    /**
     * Getter for totalHours property.
     * @return
     */
    public int getTotalHours() {
        return totalBillableHours + totalNonBillableHours;
    }

    /**
     * Getter for totalNonBillableHours property.
     * @return
     */
    public int getTotalNonBillableHours() {
        return totalNonBillableHours;
    }

    public List<ConsultantTime> getBillableHoursForClient(final String clientName) {
        final ArrayList<ConsultantTime> billableConsultingHours = new ArrayList<>();
        for (final ConsultantTime currentTime : consultingHours) {
            if (clientName.equals(currentTime.getAccount().getName())
                           &&
                currentTime.isBillable()) {
                billableConsultingHours.add(currentTime);
            }
        }
        return billableConsultingHours;
    }


    /**
     * Create a string representation of this object,
     * consisting of the consultant name and the time card week starting day.
     * @return
     */
    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT,consultant.getName(),weekStartingDay);
    }


    private void appendTime(final Formatter formatter, final List<ConsultantTime> hours,
                            final boolean billable) {
        for(final ConsultantTime currentTime : hours) {
            if(currentTime.isBillable() == billable) {
                formatter.format(LINE_FORMAT,currentTime.getAccount().getName(),
                        currentTime.getDate(),
                        currentTime.getHours(),
                        currentTime.getSkillType());
            }
        }
    }


    /**
     * Create a string representation of this object,
     * suitable for printing the entire time card.
     * @return
     */
    public String toReportString(){
        final StringBuilder sb = new StringBuilder();
        final Formatter formatter = new Formatter(sb,Locale.US);
        //Put on a header
        formatter.format(CARD_BORDER)
                .format(HEADER_FORMAT,consultant.getName(),weekStartingDay)
                .format(BILLABLE_TIME_HEADER_FORMAT)
                .format(LINE_HEADER_FORMAT);
        appendTime(formatter,consultingHours,true);

        formatter.format(NON_BILLABLE_TIME_HEADER_FORMAT)
                .format(LINE_HEADER_FORMAT);

        appendTime(formatter,consultingHours,false);

        formatter.format(SUMMARY_HEADER_FORMAT)
                .format(SUMMARY_LINE_FORMAT,"Total Billable:",totalBillableHours)
                .format(SUMMARY_LINE_FORMAT,"Total Non-Billable:",totalNonBillableHours)
                .format(SUMMARY_LINE_FORMAT,"Total Hours:",totalBillableHours + totalNonBillableHours)
                .format(CARD_BORDER);
        final String s = formatter.toString();
        formatter.close();
        return s;
    }
}
