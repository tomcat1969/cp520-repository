package edu.uw.cp520.scg.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillTest {

    @Test
    void test() {
        assertEquals(150,Skill.SOFTWARE_ENGINEER.getRate());
    }
}
