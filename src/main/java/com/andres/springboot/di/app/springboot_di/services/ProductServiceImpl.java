package com.andres.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.andres.springboot.di.app.springboot_di.models.Product;
import com.andres.springboot.di.app.springboot_di.repositories.ProductRepository;
//import com.andres.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

//@Component
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Environment environment;

    //private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    //@Autowired
    //@Qualifier("productList")
    //private ProductRepositoryImpl repository;
    private ProductRepository repository;

    //public ProductServiceImpl(@Qualifier("productRepositoryImpl") ProductRepository repository) {
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {

            //Double priceTax = p.getPrice() * 1.25d;
            Double increment = Double.parseDouble(environment.getProperty("config.price.tax"));
            Double priceTax = p.getPrice() * increment;

            //System.out.println(environment.getProperty("config.increment"));
            //clone
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;

            //inmutabilidad 
            //Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());

            //mutante
            // p.setPrice(priceTax.longValue());
            // return p;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
