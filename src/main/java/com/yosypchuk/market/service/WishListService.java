package com.yosypchuk.market.service;

import com.yosypchuk.market.model.dto.ProductDTO;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.WishList;

import java.util.List;

public interface WishListService {

    void addProductToWishList(Long userId, Long productId);

    List<ProductDTO> getAllUserProductsFromWishList(Long userId);
}
