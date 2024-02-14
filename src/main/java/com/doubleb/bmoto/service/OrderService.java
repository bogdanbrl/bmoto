package com.doubleb.bmoto.service;

import com.doubleb.bmoto.entity.Order;
import com.doubleb.bmoto.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService() {
    }

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }
}
