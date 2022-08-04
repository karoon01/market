package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.model.entity.ProductRate;
import com.yosypchuk.market.repository.ProductRateRepository;
import com.yosypchuk.market.repository.ProductRepository;
import com.yosypchuk.market.service.ProductRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@AllArgsConstructor
@Service
public class ProductRateServiceImpl implements ProductRateService {

    private final ProductRateRepository productRateRepository;
    private final ProductRepository productRepository;

    @Transactional
    @Override
    public List<ProductRate> getAllProductsRate(Long productId) {
        log.info("Trying to get product with id: {}", productId);
        productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product doesn't exist"));

        log.info("Get all rates for product with id: {}", productId);
        List<ProductRate> rates = productRateRepository.findAllByProductId(productId);

        return rates;
    }

    @Transactional
    @Override
    public Integer getNumberOfProductRate(Long productId) {
        log.info("Trying to get product with id: {}", productId);
        productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product doesn't exist"));

        log.info("Get amount of rates for product with id: {}", productId);
        Integer amount = productRateRepository.getNumberOfProductRates(productId);

        return amount;
    }
}
