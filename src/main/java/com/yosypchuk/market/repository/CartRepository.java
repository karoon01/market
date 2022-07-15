package com.yosypchuk.market.repository;

import com.yosypchuk.market.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    void addProductToUserCart(Long userId, Long productId);
}
