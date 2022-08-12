package com.study.shopping.service;

import com.study.shopping.domain.*;
import com.study.shopping.domain.item.Item;
import com.study.shopping.repository.ItemRepository;
import com.study.shopping.repository.MemberRepository;
import com.study.shopping.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemService itemService;
    private final MemberService memberService;

    public Long order(Long memberId, Long itemId, int count) throws Exception {
        Member findMember = memberService.findOne(memberId);
        Item findItem = itemService.findItem(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(findMember.getAddress());

        OrderItem oderItem = OrderItem.createOderItem(findItem, findItem.getPrice(), count);

        Order order = Order.createOrder(findMember, delivery, oderItem);

        orderRepository.save(order);

        return order.getId();

    }
//    public Long order(Long memberId, Cart cart) throws Exception {
//        Member findMember = memberService.findOne(memberId);
//        List<OrderItem> orderItems = new ArrayList<>();
//        Delivery delivery = new Delivery();
//        delivery.setAddress(findMember.getAddress());
//        cart.getItems().stream().forEach(c -> {
//            OrderItem orderItem = OrderItem.createOderItem(c, c.getPrice(), c.getCount());
//            orderItems.add(orderItem);
//        });
//
//        Order order = Order.createOrder(findMember, delivery, (OrderItem) orderItems);
//
//        orderRepository.save(order);
//
//        return order.getId();
//
//    }

    public void cancelOrder(Long orderId) throws Exception {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new Exception("no order"));
        order.cancel();
    }

//    public List<Order> findAll(){
//
//    }

}
