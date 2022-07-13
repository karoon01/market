package com.yosypchuk.market.repository;

import com.yosypchuk.market.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Long> {

    void addProductToUserCart(Long userId, Long productId);
}
