package com.yosypchuk.market.api;

import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.model.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Cart management API")
@RequestMapping("/api/v1/cart")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface CartApi {

    @ApiOperation("Get user cart")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    Cart getUserCart(@PathVariable Long id);

//    @ApiOperation("Get user cart products")
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/{id}")
//    List<Product> getUserCartProducts(@PathVariable Long id);

    @ApiOperation("Add product to user cart")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{userId}/{productId}")
    Cart addProductToCart(@PathVariable Long userId, @PathVariable Long productId);

    @ApiOperation("Remove product to user cart")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{userId}/{productId}")
    Cart removeProductFromCart(@PathVariable Long userId, @PathVariable Long productId);
}
