package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.entity.Cart;
import com.yosypchuk.market.entity.Product;
import com.yosypchuk.market.entity.User;
import com.yosypchuk.market.exception.UserNotFoundException;
import com.yosypchuk.market.repository.CartRepository;
import com.yosypchuk.market.repository.WishListRepository;
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
                .orElseThrow(() -> new UserNotFoundException("Cannot get user with id: " + userId));
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
