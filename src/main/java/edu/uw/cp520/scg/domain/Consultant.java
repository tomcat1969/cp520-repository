package edu.uw.cp520.scg.domain;


import edu.uw.cp520.scg.util.PersonalName;

/**
 * A consultant for the SCG, just has a PersonalName.
 * @author
 * Lin Huang
 */
public class Consultant implements Comparable<Consultant> {

    private final PersonalName name;

    public Consultant(PersonalName name) {

        this.name = name;
    }


    /**
     * Getter for name property.
     * @return
     */
    public final PersonalName getName() {
        return name;
    }


    /**
     *
     * @return
     * the string representation of the consultant's name.
     */
    @Override
    public final String toString() {
        return name.toString();
    }

    @Override
    public int compareTo(Consultant o) {
        if (this == o) return 0;
        return name.compareTo(o.name);
    }
}
