package edu.uw.cp520.scg.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {
    Address address;
    @BeforeEach
    void setUp() throws Exception {
        address = new Address("31003","Federal Way",StateCode.WA,"98003");

    }

    @Test
    void testGetCity() {

        assertEquals("Federal Way", address.getCity());
    }
}
