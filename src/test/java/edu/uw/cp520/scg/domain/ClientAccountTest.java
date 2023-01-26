package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.PersonalName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientAccountTest {

    PersonalName personalName1;
    ClientAccount clientAccount1;
    @BeforeEach
    void setUp() throws Exception {
        personalName1 = new PersonalName("Huang","Lin");
        clientAccount1 = new ClientAccount("Huang Lin",personalName1);
    }

    @Test
    void testIsBillable() {
        assertEquals(true,clientAccount1.isBillable());
    }


}
