package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.PersonalName;

import java.util.Comparator;

/**
 * A billable Account that additionally has client contact information.
 * @Author
 * Lin Huang
 */
public final class ClientAccount implements Account,Comparable<ClientAccount> {
    /**
     *  The Consultant natural ordering is in ascending ordered by the consultant's name.
     *  The natural ordering of ClientAccount is ascending order by name, contact and finally address.
     */
    private static Comparator<ClientAccount> naturalOrderComparator = Comparator.comparing(ClientAccount::getName)
            .thenComparing(ClientAccount::getContact)
            .thenComparing(ClientAccount::getAddress);
    private final  String name;
    private PersonalName contact;

    private Address address;


    public ClientAccount(String name, PersonalName contact, final Address address) {

        this.name = name;
        this.contact = contact;
        this.address = address;

    }

    /**
     * gets the address for this account
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     * setter for address
     * @param address
     */
    public void setAddress(final Address address) {
        this.address = address;
    }

    /**
     * Gets the contact for this account.
     * @return
     * value of contact property.
     */
    public PersonalName getContact(){
        return contact;
    }


    /**
     * Gets the account name.
     * Specified by:
     * getName in interface Account
     * @return
     * value of name property.
     */

    @Override
    public String getName() {
        return name;
    }

    /**
     * Determines if this account is billable.
     *
     * @return
     * always true
     */
    @Override
    public boolean isBillable() {
        return true;
    }

    /**
     * Setter for contact property.
     * contact  - new value for contact property
     * @param contact
     */
    public void setContact(final PersonalName contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n",name,address.toString(),contact.toString());
    }

    @Override
    public int compareTo(ClientAccount o) {
        if(this == o) return 0;
        return naturalOrderComparator.compare(this,o);
    }
}
