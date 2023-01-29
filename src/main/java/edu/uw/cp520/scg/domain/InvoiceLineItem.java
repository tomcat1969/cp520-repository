package edu.uw.cp520.scg.domain;

import java.time.LocalDate;
import java.util.Locale;


/**
 * Encapsulates a single billable item to be included in an invoice. The InvoiceLineItem includes:
 * date the service was provided,
 * name of consultant providing the service
 * the sevice/skill provided
 * number of hours
 * Author:
 * Lin Huang
 */
public final class InvoiceLineItem {
    private static final String LINE_FORMAT = "%1$tm/%1$td/%1$tY  %2$-28s %3$-20s %4$5d    %5$,8.2f";
    private final LocalDate date;

    private final Consultant consultant;

    private final Skill skill;
    private final int hours;

    private final int charge;

    public InvoiceLineItem(final LocalDate date, final Consultant consultant,
                           final Skill skill,final int hours) {
        if(hours <= 0) {
            throw new IllegalArgumentException("InvoiceLineItem requires hours > 0");
        }
        this.date = date;
        this.consultant = consultant;
        this.skill = skill;
        this.hours = hours;
        this.charge = skill.getRate() * hours;
    }


    public LocalDate getDate() {
        return date;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public Skill getSkill() {
        return skill;
    }

    public int getHours() {
        return hours;
    }

    public int getCharge() {
        return charge;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,LINE_FORMAT,date,consultant.getName(),skill,hours,(double)charge);
    }
}
