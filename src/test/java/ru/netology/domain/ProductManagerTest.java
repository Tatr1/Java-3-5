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
    Product six = new Book(431, "My precious", 750, "QQ");
    Product seven = new Smartphone(266, "iTome", 567, "N");
    Product eight = new Product(3,"Queen", 517);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
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
        Product[] expected = {first, second, four, six, eight};
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
    void searchByBookAutorQQ(){
        Product[] actual = manager.searchBy("QQ");
        Product[] expected = {four, six};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено: " + actual.length + " товар(ов)");
    }
    @Test
    void searchBySmartMakerN(){
        Product[] actual = manager.searchBy("N");
        Product[] expected = {seven};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено: " + actual.length + " товар(ов)");
    }
}