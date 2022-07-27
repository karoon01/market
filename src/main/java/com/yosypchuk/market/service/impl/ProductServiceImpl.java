package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityAlreadyExistException;
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
import java.util.Optional;
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
    public ProductDTO getProductByName(String name) {
        log.info("Get product by name: {}", name);
        Product product = productRepository.findProductByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Product is not found!"));
        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        String name = productDTO.getName();
        Optional<Product> possibleProduct = productRepository.findProductByName(name);

        if(possibleProduct.isPresent()) {
            log.warn("Product with name: {} is already exist!", name);
            throw new EntityAlreadyExistException("Product with this name is already exist");
        }

        Product product = ProductMapper.INSTANCE.mapProduct(productDTO);
        product.setCategory(productDTO.getCategory());
        product.setAverageRate(0.0);
        product.setAmount(0);

        log.info("Save product");
        productRepository.save(product);

        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Transactional
    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        log.info("Trying to get product with id: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product is not found!"));

        log.info("Update product with id: {}", id);
        Product updatedProduct = Product.builder()
                .id(product.getId())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .averageRate(product.getAverageRate())
                .price(productDTO.getPrice())
                .amount(product.getAmount())
                .build();

        productRepository.save(updatedProduct);

        return ProductMapper.INSTANCE.mapProductDto(updatedProduct);
    }

    @Override
    public ProductDTO updateProductAmount(Long id, Integer amount) {
        log.info("Trying to get product with id: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product is not found!"));
        product.setAmount(amount);

        log.info("Update amount for product with id: {}", id);
        productRepository.save(product);

        return ProductMapper.INSTANCE.mapProductDto(product);
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
