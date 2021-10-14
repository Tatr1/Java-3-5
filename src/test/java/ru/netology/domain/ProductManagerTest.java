package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product first = new Smartphone(145, "Hai", 541, "Q");
    Product second = new Smartphone(267, "iTime", 567, "Q");
    Product three = new Book(432, "Hoi", 747, "Hai");
    Product four = new Book(437, "Q", 747, "QQ");
    Product five = new Product(1, "card", 100);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(three);
        manager.add(four);
        manager.add(five);
    }

    @Test
    void searchBySomeItemTextHai() {
        Product[] actual = manager.searchBy("Hai");
        Product[] expected = {first, three};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено: " + actual.length + " товара(ов)");
    }

    @Test
    void searchBySomeItemTextQ() {
        Product[] actual = manager.searchBy("Q");
        Product[] expected = {first, second, four};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено: " + actual.length + " товара(ов)");
    }

    @Test
    void searchByNoOneItem() {
        Product[] actual = manager.searchBy("Ai");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено: " + actual.length + " товар(ов)");
    }

    @Test
    void searchByTwoFieldsBook() {
        Product[] actual = manager.searchByTwo("Hai" + "Hoi");
        Product[] expected = {three};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено: " + actual.length + " товар(ов)");
    }

    @Test
    void searchByTwoFieldsSmart() {
        Product[] actual = manager.searchByTwo("Hai" + "Q");
        Product[] expected = {first};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено: " + actual.length + " товар(ов)");
    }

    @Test
    void searchByTwoFieldsSmartNegative() {
        Product[] actual = manager.searchByTwo("Hai" + "QQ");
        assertEquals(0, actual.length);
        System.out.println("Найдено: " + actual.length + " товар(ов)");
    }

    @Test
    void searchByVar2Book() {
        Product[] actual = manager.searchByTwoFieldVar2("Hai", "Hoi");
        Product[] expected = {three};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено: " + actual.length + " товар(ов)");
    }

    @Test
    void searchByVar2Smart() {
        Product[] actual = manager.searchByTwoFieldVar2("Hai", "Q");
        Product[] expected = {first};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено: " + actual.length + " товар(ов)");
    }

    @Test
    void searchByVar2SmartNegative() {
        Product[] actual = manager.searchByTwoFieldVar2("Hai", "QQ");
        assertEquals(0, actual.length);
        System.out.println("Найдено: " + actual.length + " товар(ов)");
    }


}