package com.study.shopping.repository;

import com.study.shopping.domain.Order;
import com.study.shopping.domain.OrderSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select o from Order o join o.member m where o.status = :#{orderSearch.orderStatus} and m.name like :#{orderSearch.memberName}")
    List<Order> findAll(OrderSearch orderSearch);

}
