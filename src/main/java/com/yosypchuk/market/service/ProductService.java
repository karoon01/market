package com.yosypchuk.market.service;

import com.yosypchuk.market.model.dto.ProductDTO;
import com.yosypchuk.market.model.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDTO getProductById(Long id);

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(Long id, ProductDTO productDTO);

    void removeProduct(Long id);

    List<ProductDTO> getAll();
}
