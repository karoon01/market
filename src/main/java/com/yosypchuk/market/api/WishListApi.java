package com.yosypchuk.market.api;

import com.yosypchuk.market.model.dto.ProductDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Wishlist management API")
@RequestMapping("/api/v1/wishlist")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface WishListApi {
    @ApiOperation("Get all products from wishlist")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}")
    List<ProductDTO> getAllProductsFromWishlist(@PathVariable Long userId);

    @ApiOperation("Add product to wishlist")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{userId}/{productId}")
    ResponseEntity<Void> addProductToWishlist(@PathVariable Long userId, @PathVariable Long productId);
}
