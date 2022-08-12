package com.study.shopping.service;

import com.study.shopping.domain.*;
import com.study.shopping.domain.item.Book;
import com.study.shopping.dto.MemberDTO;
import com.study.shopping.exception.NotEnoughStockException;
import com.study.shopping.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired MemberService memberService;
    @Autowired ItemService itemService;

    @Test
    public void 상품주문() throws Exception {
        Member member = createMember("member1", "천안시", "중앙로", "2244", "danu1234", "01093472172");
        Long memberId = memberService.join(member);
        Book book = createBook("김정민책", 50000, 100);
        Long bookId = itemService.saveItem(book);

        Long orderId = orderService.order(memberId, bookId, 5);

        Order orders = orderRepository.findById(orderId).orElseThrow(() -> new Exception("no order"));

        Assertions.assertThat(OrderStatus.READY).isEqualTo(orders.getStatus());
        Assertions.assertThat(1).isEqualTo(orders.getOrderItems().size());
        Assertions.assertThat(250000).isEqualTo(orders.getTotalPrice());
        Assertions.assertThat(95).isEqualTo(book.getStockQuantity());
    }

    private Book createBook(String name, int price, int stock) {
        Book book = new Book(name, price, stock);
        return book;
    }

    private Member createMember(String name, String city, String street, String zipcode, String password, String phoneNum) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);
        memberDTO.setAddress(new Address(city, street, zipcode));
        memberDTO.setPassword(password);
        memberDTO.setPhoneNum(phoneNum);
        memberDTO.setRole(Role.VIP);
        return new Member(memberDTO);
    }

    @Test
    public void 주문취소() throws Exception {
        Member member = createMember("member1", "천안시", "중앙로", "2244", "danu1234", "01093472172");
        Long memberId = memberService.join(member);
        Book book = createBook("김정민책", 50000, 100);
        Long bookId = itemService.saveItem(book);
        int orderCount = 30;
        Long orderId = orderService.order(memberId, bookId, orderCount);

        orderService.cancelOrder(orderId);
        Order findOrder = orderRepository.findById(orderId).orElseThrow(() -> new Exception("no order"));

        Assertions.assertThat(findOrder.getStatus()).isEqualTo(OrderStatus.CANCEL);
        Assertions.assertThat(100).isEqualTo(book.getStockQuantity());
    }

    @Test
    public void 수량초과() throws Exception {
        Member member = createMember("member1", "천안시", "중앙로", "2244", "danu1234", "01093472172");
        Long memberId = memberService.join(member);
        Book book = createBook("김정민책", 50000, 100);
        Long bookId = itemService.saveItem(book);

        int orderCount = 101;

        assertThrows(NotEnoughStockException.class, () -> {
            orderService.order(memberId, bookId, orderCount);
        });
    }
}