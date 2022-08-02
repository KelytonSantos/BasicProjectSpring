package com.projectBasic.JVBasicCourse.repositories;

import com.projectBasic.JVBasicCourse.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}