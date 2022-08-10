package com.projectBasic.JVBasicCourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projectBasic.JVBasicCourse.entities.User;
import com.projectBasic.JVBasicCourse.repositories.UserRepository;
import com.projectBasic.JVBasicCourse.service.exceptions.DatabaseException;
import com.projectBasic.JVBasicCourse.service.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service //Poderia ser o @Component
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj1 = repository.findById(id);
        return obj1.orElseThrow(() -> new ResourceNotFoundException(id)) ;
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){

        try{
            repository.deleteById(id);
        } catch(EmptyResultDataAccessException e) {
            //e.printStackTrace();//Com isso eu consigo ver qual foi a exceção que deu
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try{
            User entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}