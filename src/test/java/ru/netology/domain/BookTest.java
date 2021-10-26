package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(267, "OZ", 567, "Toto");

    @Test
    public void shouldMatchesTrue() {
        assertTrue(book.matches("O"));
    }

    @Test
    public void shouldMatchesFalse() {
        assertFalse(book.matches("A"));
    }
}
