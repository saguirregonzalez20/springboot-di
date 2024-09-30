package com.andres.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.andres.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 3000L),
            new Product(2L, "CPU INtel COre i9", 180L),
            new Product(3L, "MotherBoard Gigabyte", 240L),
            new Product(4L, "Teclado Ryser 9", 800L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
