package com.yosypchuk.market.repository;

import com.yosypchuk.market.model.entity.Order;
import com.yosypchuk.market.model.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.cart.user.id=?1")
    List<Order> getAllOrdersByUserId(@Param("id") Long userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Order o SET o.status=?2 WHERE o.id=?1")
    void updateOrderStatus(Long orderId, OrderStatus status);
}
