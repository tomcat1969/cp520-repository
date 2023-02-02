package edu.uw.cp520.scg.util;

import java.util.Comparator;
import java.util.Locale;

/**
 *
 * A simple mailing address.
 */
public final class Address implements Comparable<Address>{

    private static Comparator<Address> naturalOrderComparator = Comparator.comparing(Address::getState)
            .thenComparing(Address::getPostalCode)
            .thenComparing(Address::getCity)
            .thenComparing(Address::getStreetNumber);
    private final String streetNumber;
    private final String city;
    private final StateCode state;
    private final String postalCode;

    public Address(final String streetNumber,final String city,final StateCode state,final String postalCode) {
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }


    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public StateCode getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Compares two Address object for value equality.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!streetNumber.equals(address.streetNumber)) return false;
        if (!city.equals(address.city)) return false;
        if (state != address.state) return false;
        return postalCode.equals(address.postalCode);
    }

    @Override
    public int hashCode() {
        int result = streetNumber.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + postalCode.hashCode();
        return result;
    }

    /**
     * Prints this address in the form:
     *
     * street number
     * city, state postal code
     * @return
     */
    @Override
    public String toString() {
        return String.format(Locale.US,"%s%n%s, %s %s",streetNumber,city,state,postalCode);
    }

    @Override
    public int compareTo(Address o) {
        if(this == o) return 0;
        return naturalOrderComparator.compare(this,o);
    }
}
