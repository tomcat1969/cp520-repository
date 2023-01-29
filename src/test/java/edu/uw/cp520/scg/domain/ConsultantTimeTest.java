package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.PersonalName;
import edu.uw.cp520.scg.util.StateCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultantTimeTest {

    private LocalDate date;
    private Account account;
    private Skill skill;
    private int hours;
    private PersonalName personalName1;


    private ConsultantTime consultantTime1;

    private Address address;

    @BeforeEach
    void setUp() throws Exception {
       date = LocalDate.now();
        personalName1 = new PersonalName("Huang","Lin");
        address = new Address("31003","Federal Way", StateCode.WA,"98003");
        account = new ClientAccount("Huang Lin",personalName1,address);
        skill = Skill.SOFTWARE_ENGINEER;
        hours = 5;
        consultantTime1 = new ConsultantTime(date,account,skill,hours);

    }


    @Test
    void testIsBillable() {
        assertEquals(account.isBillable(),consultantTime1.isBillable());
    }

}
