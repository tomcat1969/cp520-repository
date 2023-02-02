package edu.uw.cp520.scg.domain;


/**
 * Defines an account as having a name and being either billable or no-billable,
 * all accounts must implement.
 */
public interface Account {
    /**
     * Getter for the name of this account.
     *
     * @return
     * the name of this account.

     */
    String getName();

    /**
     * Determines if this account is billable.
     * Returns:
     *             true if the account is billable otherwise false.
     */


    boolean isBillable();
}
