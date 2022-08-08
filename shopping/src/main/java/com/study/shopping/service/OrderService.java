package com.study.shopping.service;

import com.study.shopping.domain.Order;
import com.study.shopping.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

//    public Long save(Order order) {
//    }
}
