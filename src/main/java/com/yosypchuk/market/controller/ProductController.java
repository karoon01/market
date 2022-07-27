package com.yosypchuk.market.controller;

import com.yosypchuk.market.api.ProductApi;
import com.yosypchuk.market.model.dto.ProductDTO;
import com.yosypchuk.market.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class ProductController implements ProductApi {

    private ProductService productService;

    @Override
    public List<ProductDTO> getAllProducts(){
        return productService.getAll();
    }

    @Override
    public ProductDTO getProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @Override
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.removeProduct(id);
        return ResponseEntity.noContent().build();
    }
}