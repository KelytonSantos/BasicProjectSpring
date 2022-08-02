package com.projectBasic.JVBasicCourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectBasic.JVBasicCourse.entities.User;
import com.projectBasic.JVBasicCourse.repositories.UserRepository;
import java.util.List;
import java.util.Optional;

@Service //Poderia ser o @Component
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj1 = repository.findById(id);
        return obj1.get();
    }

}