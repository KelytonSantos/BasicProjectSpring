package com.projectBasic.JVBasicCourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectBasic.JVBasicCourse.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}