package com.projectBasic.JVBasicCourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectBasic.JVBasicCourse.entities.Order;
import com.projectBasic.JVBasicCourse.repositories.OrderRepository;

@Service //Poderia ser o @Component
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}