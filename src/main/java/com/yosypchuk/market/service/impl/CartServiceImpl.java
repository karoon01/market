package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.repository.CartRepository;
import com.yosypchuk.market.repository.ProductRepository;
import com.yosypchuk.market.repository.UserRepository;
import com.yosypchuk.market.service.CartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public Cart createCart(Cart cart) {

        return null;
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        log.info("Get cart by user with id: {}", userId);
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User doesn't exist!"));

        log.info("Get cart by user id: {}", userId);
        Cart cart = cartRepository.findCartByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Cart doesn;t exist!"));

        return cart;
    }

    @Override
    public void addProductToCart(Long productId, Long userId) {
        log.info("Trying to get user with id: {}", userId);
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User doesn't exist!"));

        log.info("Trying to get product with id: {}", productId);
        productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product doesn't exist!"));

        log.info("Add product with id: {} to user cart with id: {}", productId, userId);
        cartRepository.addProductToCart(userId, productId);
    }

    @Override
    public void removeProductFromCart(Long productId, Long userId) {
        log.info("Trying to get user with id: {}", userId);
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User doesn't exist!"));

        log.info("Trying to get product with id: {}", productId);
        productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product doesn't exist!"));

        log.info("Remove product with id: {} to user cart with id: {}", productId, userId);
        cartRepository.removeProductFromCart(userId, productId);
    }
}
