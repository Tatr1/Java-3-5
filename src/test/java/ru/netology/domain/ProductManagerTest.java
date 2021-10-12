package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product nul = new Product(1,"card",100);
    Product first = new Smartphone(145, "Hai", 541, "Q");
    Product second = new Smartphone(267, "iTime", 567, "Q");
    Product three = new Book(432, "Hoi", 747, "Hai");
    Product four = new Book(437, "Q", 747, "QQ");

    @Test
    void searchBySomeItem1() {
        manager.add(null);
        manager.add(first);
        manager.add(second);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Hai");
        Product[] expected = {first, three};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено " + actual.length + " товара(ов)");
    }
    @Test
    void searchBySomeItem2() {
        manager.add(first);
        manager.add(second);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Q");
        Product[] expected = {first, second, four};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено " + actual.length + " товара(ов)");
    }

    @Test
    void searchByNoOneItem() {
        manager.add(null);
        manager.add(first);
        manager.add(second);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Ai");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
        System.out.println("Найдено " + actual.length + " товаров");
    }

}