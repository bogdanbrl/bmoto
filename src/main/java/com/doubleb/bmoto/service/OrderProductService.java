package com.doubleb.bmoto.service;

import com.doubleb.bmoto.entity.OrderProduct;
import com.doubleb.bmoto.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    private OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public OrderProduct save(OrderProduct orderProduct){
        return orderProductRepository.save(orderProduct);
    }
}
