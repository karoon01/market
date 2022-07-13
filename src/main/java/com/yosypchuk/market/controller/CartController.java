package com.yosypchuk.market.controller;

import com.yosypchuk.market.entity.Cart;
import com.yosypchuk.market.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    private CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable("id") Long id){

        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Cart cart = cartService.getCartByUserId(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
