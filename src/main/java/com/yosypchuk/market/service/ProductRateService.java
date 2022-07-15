package com.yosypchuk.market.service;

import com.yosypchuk.market.model.entity.ProductRate;

import java.util.List;

public interface ProductRateService {
   List<ProductRate> getAllProductsRate(Long id);
}
