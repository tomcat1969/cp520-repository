package edu.uw.cp520.scg.util;

import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.Skill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalNameTest {

    PersonalName personalName1;
    @BeforeEach
    void setUp() throws Exception {
        personalName1 = new PersonalName("Huang","Lin");

    }


    @Test
    void testGetFirstName() {
        assertEquals("Lin", personalName1.getFirstName());
    }
}
