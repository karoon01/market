package com.yosypchuk.market.service;

import com.yosypchuk.market.model.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    void save(Product product);

    void update(Product product);

    void removeProduct(Long id);

    List<Product> getAll();
}
