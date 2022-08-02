package com.projectBasic.JVBasicCourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectBasic.JVBasicCourse.entities.Category;
import com.projectBasic.JVBasicCourse.repositories.CategoryRepository;

@Service //Poderia ser o @Component
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj1 = repository.findById(id);
        return obj1.get();
    }

}