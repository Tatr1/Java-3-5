package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ProductRepositoryTest {
    private Product[] items = new Product[0];
    private ProductRepository repository = new ProductRepository();
    private Book yoyo = new Book();


    @BeforeEach
    public void setUp() {
        Product first = new Smartphone(145, "Hai", 541, "Q");
        Product second = new Smartphone(267, "iTime", 567, "Q");
        Product three = new Book(432, "Hoi", 747, "Hai");
        repository.save(first);
        repository.save(second);
        repository.save(three);
        items = repository.findAll();
    }

    @Test
    public void shouldSaveOneMoreItem() {
        repository.save(yoyo);
        items = repository.findAll();
        int actual = items.length;
        assertEquals(4, actual);
    }

    @Test
    public void findAll() {
        items = repository.findAll();
        int actual = items.length;
        assertEquals(3, actual);
    }

    @Test
    public void findById() {
        System.out.println(repository.findById(432));
        System.out.println(repository.findById(4));
    }

    @Test
    public void removeById() {
        repository.removeById(432);
        items = repository.findAll();
        int actual = items.length;
        assertEquals(2, actual);
    }


}
