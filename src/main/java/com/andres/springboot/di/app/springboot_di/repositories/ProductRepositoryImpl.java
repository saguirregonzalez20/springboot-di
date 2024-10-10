package com.andres.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.andres.springboot.di.app.springboot_di.models.Product;

//@Component
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 3000L),
            new Product(2L, "CPU INtel COre i9", 180L),
            new Product(3L, "MotherBoard Gigabyte", 240L),
            new Product(4L, "Teclado Ryser 9", 800L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
