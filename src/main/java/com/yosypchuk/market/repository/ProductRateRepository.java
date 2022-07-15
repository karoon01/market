package com.yosypchuk.market.repository;

import com.yosypchuk.market.model.entity.ProductRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRateRepository extends JpaRepository<ProductRate, Long> {

    List<ProductRate> findAllByProductId(Long id);
}
