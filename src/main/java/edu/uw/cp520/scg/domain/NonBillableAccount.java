package edu.uw.cp520.scg.domain;


/**
 * A consultant for the SCG, just has a PersonalName.
 * @author
 * Lin Huang
 */
public enum NonBillableAccount implements Account{




    SICK_LEAVE("Sick Leave"),
    VACATION("Vacation"),
    BUSINESS_DEVELOPMENT("Business Development");

    private final String friendlyName;

    private NonBillableAccount(final String name) {
        this.friendlyName = name;
    }

    /**
     * getter for the name of this account
     * @return
     */
    public String getName() {
        return friendlyName;
    }

    @Override
    public boolean isBillable() {
        return false;
    }

    /**
     * return the friendly name for this emum value
     * @return
     */
    @Override
    public String toString() {
        return  friendlyName;
    }
}
