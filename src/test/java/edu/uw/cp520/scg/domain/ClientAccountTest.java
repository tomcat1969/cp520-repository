package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.PersonalName;
import edu.uw.cp520.scg.util.StateCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientAccountTest {

    PersonalName personalName1;
    ClientAccount clientAccount1;

    Address address1;
    @BeforeEach
    void setUp() throws Exception {
        personalName1 = new PersonalName("Huang","Lin");
        address1 = new Address("31003","Federal Way", StateCode.WA,"98003");
        clientAccount1 = new ClientAccount("Huang Lin",personalName1,address1);
    }

    @Test
    void testIsBillable() {
        assertEquals(true,clientAccount1.isBillable());
    }


}
