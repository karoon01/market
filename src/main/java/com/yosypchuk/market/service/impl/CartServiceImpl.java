package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.repository.CartRepository;
import com.yosypchuk.market.service.CartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public Cart save(Cart cart) {
        log.info("Save cart");
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        log.info("Get cart by user id: {}", userId);
        Cart cart = cartRepository.findCartByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Invalid user id!"));
        return cart;
    }

    @Override
    public List<Product> getCartItems(Long userId) {
        log.info("Get cart products by user id: {}", userId);
        return cartRepository.getAllProductsFromCartByUserId(userId);
    }

    @Override
    public Cart addProductToCart(Long productId, Long userId) {
        cartRepository.addProductToCart(userId, productId);
        Cart cart = cartRepository.findCartByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Invalid user id!"));
        return cart;
    }

    @Override
    public Cart removeProductFromCart(Long productId, Long userId) {
        cartRepository.removeProductFromCart(userId, productId);
        Cart cart = cartRepository.findCartByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Invalid user id!"));
        return cart;
    }
}
