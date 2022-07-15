package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.mapper.ProductMapper;
import com.yosypchuk.market.model.dto.ProductDTO;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.repository.ProductRepository;
import com.yosypchuk.market.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public ProductDTO getProductById(Long id) {
        log.info("Get product by id: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product is not found!"));

        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        log.info("Save product");
        Product product = ProductMapper.INSTANCE.mapProduct(productDTO);
        productRepository.save(product);

        return productDTO;
    }

    @Transactional
    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        log.info("Update product with id: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product is not found!"));

        Product updatedProduct = ProductMapper.INSTANCE.mapProduct(productDTO);
        productRepository.save(updatedProduct);

        return productDTO;
    }

    @Override
    public void removeProduct(Long id) {
        log.info("Delete product with id: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product is not found"));
        productRepository.delete(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        log.info("Get all products");
        return productRepository.findAll()
                .stream()
                .map(ProductMapper.INSTANCE::mapProductDto)
                .collect(Collectors.toList());
    }
}
