package edu.uw.cp520.scg.domain;

public enum Skill {

    PROJECT_MANAGER("Project Manager",250),
    SYSTEM_ARCHITECT("System Architect",200),
    SOFTWARE_ENGINEER("Software Enginner",150),
    SOFTWARE_TESTER("Software Tester",100),
    UNKNOWN_SKILL("Unknown Skill",0);

    private String friendlyName;

    private int rate;

    private Skill(final String friendlyName, final int rate) {
        this.friendlyName = friendlyName;
        this.rate = rate;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return  friendlyName ;
    }
}
