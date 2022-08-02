package com.projectBasic.JVBasicCourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectBasic.JVBasicCourse.entities.Product;
import com.projectBasic.JVBasicCourse.repositories.ProductRepository;

@Service //Poderia ser o @Component
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj1 = repository.findById(id);
        return obj1.get();
    }

}