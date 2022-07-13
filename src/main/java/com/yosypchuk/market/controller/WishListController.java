package com.yosypchuk.market.controller;

import com.yosypchuk.market.entity.Product;
import com.yosypchuk.market.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishListController {

    private WishListService wishListService;

    @Autowired
    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping("/wishlist/{id}")
    public ResponseEntity<List<Product>> getWishListByUserId(@PathVariable("id") Long id){

        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Product> products = wishListService.getAllUserProductsFromWishList(id);

        if(products.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
