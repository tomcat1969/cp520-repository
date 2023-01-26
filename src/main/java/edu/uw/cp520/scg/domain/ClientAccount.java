package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.PersonalName;

/**
 * A billable Account that additionally has client contact information.
 * @Author
 * Lin Huang
 */
public final class ClientAccount implements Account {
    private final  String name;
    private PersonalName contact;


    public ClientAccount(String name, PersonalName contact) {

        this.name = name;
        this.contact = contact;

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
}
