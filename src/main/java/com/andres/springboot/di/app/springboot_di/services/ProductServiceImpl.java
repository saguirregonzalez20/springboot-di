package com.andres.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.andres.springboot.di.app.springboot_di.repositories.ProductRepository;
//import com.andres.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

//@Component
@Service
public class ProductServiceImpl implements ProductService {

    //private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    @Autowired
    //private ProductRepositoryImpl repository;
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {

            Double priceTax = p.getPrice() * 1.25d;
            //clone
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            //inmutabilidad 
            //Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            //p.setPrice(priceImp.longValue());
            return newProd;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
