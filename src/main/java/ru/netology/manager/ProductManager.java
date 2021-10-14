package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().contains(search)) {
                return true;
            }
            if (smartphone.getMaker().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public Product[] searchByTwo(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matchesTwoField(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matchesTwoField(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if ((book.getAuthor() + book.getName()).contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if ((smartphone.getName() + smartphone.getMaker()).contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public Product[] searchByTwoFieldVar2(String field1, String field2) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matchesTwoFieldVar2(product, field1, field2)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matchesTwoFieldVar2(Product product, String search1, String search2) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search1)) {
                if (book.getName().contains(search2)) {
                    return true;
                }
                return false;
            }
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().contains(search1)) {
                if (smartphone.getMaker().contains(search2)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}