package com.yosypchuk.market.service;

import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.User;

import java.util.List;

public interface CartService {
    Cart createCart(Cart cart);

    Cart getCartByUserId(Long userId);

    void addProductToCart(Long productId, Long userId);

    void removeProductFromCart(Long productId, Long userId);

}
