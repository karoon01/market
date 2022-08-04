package com.yosypchuk.market.controller;

import com.yosypchuk.market.api.WishListApi;
import com.yosypchuk.market.model.dto.ProductDTO;
import com.yosypchuk.market.service.WishListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class WishListController implements WishListApi {

    private WishListService wishListService;

    @Override
    public List<ProductDTO> getAllProductsFromWishlist(@PathVariable Long userId) {
        return wishListService.getAllUserProductsFromWishList(userId);
    }

    @Override
    public ResponseEntity<Void> addProductToWishlist(@PathVariable Long userId, @PathVariable Long productId) {
        wishListService.addProductToWishList(userId, productId);
        return ResponseEntity.noContent().build();

    }

    @Override
    public ResponseEntity<Void> removeProductFromWishList(@PathVariable Long userId, @PathVariable Long productId) {
        wishListService.removeProductFromWishList(userId, productId);
        return ResponseEntity.noContent().build();
    }
}
