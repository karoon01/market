package com.yosypchuk.market.controller;

import com.yosypchuk.market.entity.Product;
import com.yosypchuk.market.entity.ProductRate;
import com.yosypchuk.market.service.ProductRateService;
import com.yosypchuk.market.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private ProductRateService productRateService;

    public ProductController(ProductService productService, ProductRateService productRateService) {
        this.productService = productService;
        this.productRateService = productRateService;
    }

    @GetMapping("/products/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAll();

        if(products.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ArrayList<>(productService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product product = productService.getProductById(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product/{id}/rate")
    public ResponseEntity<List<ProductRate>> getProductsRate(@PathVariable("id") Long id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<ProductRate> rates = productRateService.getAllProductsRate(id);
        if(rates == null || rates.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(rates, HttpStatus.OK);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable("id") Long id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productService.removeProduct(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
