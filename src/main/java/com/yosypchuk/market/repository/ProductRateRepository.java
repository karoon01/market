package com.yosypchuk.market.repository;

import com.yosypchuk.market.model.entity.ProductRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRateRepository extends JpaRepository<ProductRate, Long> {
    List<ProductRate> findAllByProductId(Long productId);
}
