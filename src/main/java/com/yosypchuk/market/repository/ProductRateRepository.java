package com.yosypchuk.market.repository;

import com.yosypchuk.market.entity.ProductRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRateRepository extends JpaRepository<ProductRate, Long> {

    List<ProductRate> findAllByProductId(Long id);
}
