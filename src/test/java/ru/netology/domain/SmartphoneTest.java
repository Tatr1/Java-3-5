package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(267, "iTime", 567, "Q");

    @Test
    public void shouldMatchesTrueIT() {
        assertTrue(smartphone.matches("iT"));
    }

    @Test
    public void shouldMatchesTrueQ() {
        assertTrue(smartphone.matches("Q"));
    }

    @Test
    public void shouldMatchesFalse() {
        assertFalse(smartphone.matches("A"));
    }
}
