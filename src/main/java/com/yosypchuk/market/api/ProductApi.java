package com.yosypchuk.market.api;

import com.yosypchuk.market.model.dto.ProductDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("Product management API")
@RequestMapping("/api/v1/product")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface ProductApi {
    @ApiOperation("Get all products")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    List<ProductDTO> getAllProducts();

    @ApiOperation("Get product by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    ProductDTO getProduct(@PathVariable Long id);

    @ApiOperation("Create product")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ProductDTO createProduct(@RequestBody @Valid ProductDTO productDTO);

    @ApiOperation("Update product")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{id}")
    ProductDTO updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDTO productDTO);

    @ApiOperation("Delete product")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}
