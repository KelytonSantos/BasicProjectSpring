package com.projectBasic.JVBasicCourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectBasic.JVBasicCourse.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}