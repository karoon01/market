package com.yosypchuk.market.service;

import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.User;

import java.util.List;

public interface CartService {

    Cart getCartByUserId(Long userId);

    List<Product> showCartItems(Long userId);

    void addProductToCart(Product product, User user);

    void removeProductFromList(Product product, User user);

}
