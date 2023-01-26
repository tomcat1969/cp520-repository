package edu.uw.cp520.scg.util;


import java.util.Objects;

/**
 * Encapsulates the first, middle and last name of a person.
 */
public class PersonalName {
    /**
     * String constant for "NMN" - no middle name
     */
    public static final String NMN = "NMN";

    private String lastName;
    private String firstName;
    private String middleNam;

    /**
     * Creates a new instance of Name
     * @param lastName
     * @param firstName
     * @param middleNam
     */
    public PersonalName(String lastName, String firstName, String middleNam) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleNam = middleNam;
    }

    /**
     * Creates a new instance of Name
     * @param lastName
     * @param firstName
     */
    public PersonalName(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleNam = NMN;
    }

    /**
     * Creates a new instance of Name
     */
    public PersonalName() {
    }

    /**
     * Getter for lastName property.
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter for lastname
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for firstName property.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter for firstname
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter for middlename
     * @return
     */
    public String getMiddleNam() {
        return middleNam;
    }

    /**
     * setter for middleName
     * @param middleNam
     */
    public void setMiddleNam(String middleNam) {
        this.middleNam = middleNam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalName that = (PersonalName) o;

        if (!lastName.equals(that.lastName)) return false;
        if (!firstName.equals(that.firstName)) return false;
        return middleNam.equals(that.middleNam);
    }

    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleNam.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getLastName() + ", " + getFirstName() + ", " + getMiddleNam();
    }
}
