package com.yosypchuk.market.service;

import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.User;

import java.util.List;

public interface CartService {
    Cart save(Cart cart);

    Cart getCartByUserId(Long userId);

    List<Product> getCartItems(Long userId);

    Cart addProductToCart(Long productId, Long userId);

    Cart removeProductFromCart(Long productId, Long userId);

}
