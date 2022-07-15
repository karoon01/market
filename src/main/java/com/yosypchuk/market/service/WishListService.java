package com.yosypchuk.market.service;

import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.WishList;

import java.util.List;

public interface WishListService {

    void addProductToWishList(WishList wishList, Product product);

    List<Product> getAllUserProductsFromWishList(Long userId);
}
