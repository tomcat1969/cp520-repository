package edu.uw.cp520.scg.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateCodeTest {

    StateCode stateCode;
    @BeforeEach
    void setUp() throws Exception {
        stateCode = StateCode.CA;


    }

    @Test
    public void testToGetName() {

        assertEquals("California",  stateCode.getName());
    }


    @Test
    void test(){
        System.out.println(stateCode.forName("california"));


    }


}
