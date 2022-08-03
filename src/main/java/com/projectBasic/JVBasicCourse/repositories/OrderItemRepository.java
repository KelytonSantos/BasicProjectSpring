package com.projectBasic.JVBasicCourse.repositories;

import com.projectBasic.JVBasicCourse.entities.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}