package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.model.entity.ProductRate;
import com.yosypchuk.market.repository.ProductRateRepository;
import com.yosypchuk.market.service.ProductRateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRateServiceImpl implements ProductRateService {

    private ProductRateRepository productRateRepository;

    public ProductRateServiceImpl(ProductRateRepository productRateRepository) {
        this.productRateRepository = productRateRepository;
    }


    @Override
    public List<ProductRate> getAllProductsRate(Long id) {
        return productRateRepository.findAllByProductId(id);
    }
}
