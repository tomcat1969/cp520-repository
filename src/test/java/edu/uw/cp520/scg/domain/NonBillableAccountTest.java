package edu.uw.cp520.scg.domain;

import edu.uw.cp520.scg.util.PersonalName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonBillableAccountTest {


    @Test
    void test() {
        assertEquals(false,NonBillableAccount.SICK_LEAVE.isBillable());
    }

}
