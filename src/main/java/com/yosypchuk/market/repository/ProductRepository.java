package com.yosypchuk.market.repository;

import com.yosypchuk.market.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
