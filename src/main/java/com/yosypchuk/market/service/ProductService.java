package com.yosypchuk.market.service;

import com.yosypchuk.market.model.dto.ProductDTO;
import com.yosypchuk.market.model.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long id);

    ProductDTO getProductByName(String name);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    ProductDTO updateProductAmount(Long id, Integer amount);

    void removeProduct(Long id);

    List<ProductDTO> getAll();
}
