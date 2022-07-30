package com.projectBasic.JVBasicCourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectBasic.JVBasicCourse.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}