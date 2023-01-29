package edu.uw.cp520.scg.domain;


import edu.uw.cp520.scg.util.PersonalName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit test for the Consultant class
 */
public class ConsultantTest {

    Consultant consultant1;
    PersonalName personalName1;
    @BeforeEach
    void setUp() throws Exception {
        personalName1 = new PersonalName("Huang","Lin");
        consultant1 = new Consultant(personalName1);
    }


    @Test
    void testGetName() {
        String expected = personalName1.getFirstName();
        Consultant actual = consultant1;
        assertEquals(expected,actual.getName().getFirstName());
    }

    @Test
    void testToString() {
        String expected = "Huang, Lin, NMN";
        Consultant actual = consultant1;
       // System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+actual.toString());
        assertEquals(expected,actual.toString());
    }


}
