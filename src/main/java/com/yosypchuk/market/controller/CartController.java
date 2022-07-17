package com.yosypchuk.market.controller;

import com.yosypchuk.market.api.CartApi;
import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CartController implements CartApi {

    private final CartService cartService;

    @Override
    public Cart getUserCart(Long id) {
        return cartService.getCartByUserId(id);
    }

//    @Override
//    public List<Product> getUserCartProducts(Long id) {
//        return cartService.getCartItems(id);
//    }

    @Override
    public Cart addProductToCart(Long userId, Long productId) {
        return cartService.addProductToCart(productId, userId);
    }

    @Override
    public Cart removeProductFromCart(Long userId, Long productId) {
        return cartService.removeProductFromCart(productId, userId);
    }
}
