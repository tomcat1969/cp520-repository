package edu.uw.cp520.scg.domain;

import java.time.LocalDate;

public final class ConsultantTime {


    private LocalDate date;
    private Account account;
    private Skill skill;
    private int hours;
    /**
     *
     * @param date - The date this instance occurred.
     * @param account-The account to charge the hours to; either a Client or NonBillableAccount.
     * @param skill -The skill type.
     * @param hours -The number of hours, which must be positive.
     */
    public ConsultantTime(LocalDate date,
                          Account account,
                          Skill skill,
                          int hours) {

        this.date = date;
        setHours(hours);
        this.account = account;
        this.skill = skill;
    }

    /**
     * Getter for date property.
     * @return - value of date property
     */

    public LocalDate getDate() {
        return date;
    }

    /**
     *  Setter for date property.
     * @param  - new value of date property
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter for account property.
     * @return
     * value of account property
     */
    public Account getAccount() {
        return account;
    }


    /**
     * Setter for account property.
     * @param
     * account - new value of account property
     */
    public void setAccount(Account account) {
        this.account = account;
    }


    /**
     *
     * @return true if the time is billable otherwise false.
     */
    public boolean isBillable(){
        return account.isBillable();
    }

    /**
     * getter for skill property
     * @return value of skill property
     */
    public Skill getSkillType() {
        return skill;
    }


    /**
     * Getter for hours property.
     * @return value of hours property
     */

    public int getHours() {
        return hours;
    }

    /**
     * Setter for hours property.
     * @param hours - New value of hours property must be > 0
     */
    public void setHours(int hours) {
        if(hours <= 0) throw  new IllegalArgumentException("hours property must be > 0");
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsultantTime that = (ConsultantTime) o;

        if (hours != that.hours) return false;
        if (!date.equals(that.date)) return false;
        if (!account.equals(that.account)) return false;
        return skill == that.skill;
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + account.hashCode();
        result = 31 * result + skill.hashCode();
        result = 31 * result + hours;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%-28s %2$tm/%2$td/%2%tY %3$5d %4$s%n", account.getName(),date,hours,skill);
    }
}
