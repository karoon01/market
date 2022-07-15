package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.User;
import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.repository.CartRepository;
import com.yosypchuk.market.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findAll()
                .stream()
                .filter(e -> e.getUser().getId() == userId)
                .findAny()
                .orElseThrow(() -> new EntityNotFoundException("Cannot get user with id: " + userId));
    }

    @Override
    public List<Product> showCartItems(Long userId) {
        return cartRepository.findAll()
                .stream()
                .filter(e -> e.getUser().getId() == userId)
                .map(e -> e.getProduct())
                .collect(Collectors.toList());
    }

    @Override
    public void addProductToCart(Product product, User user) {
        cartRepository.addProductToUserCart(user.getId(), product.getId());
    }

    @Override
    public void removeProductFromList(Product product, User user) {

    }
}
