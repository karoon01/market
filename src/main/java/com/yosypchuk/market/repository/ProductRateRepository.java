package com.yosypchuk.market.repository;

import com.yosypchuk.market.model.entity.ProductRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRateRepository extends JpaRepository<ProductRate, Long> {

    @Query(value = "COUNT * FROM product_rate WHERE product_id=:id",
            nativeQuery = true)
    Integer getNumberOfProductRates(@Param("id") Long productId);

    List<ProductRate> findAllByProductId(Long productId);
}
