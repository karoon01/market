package com.yosypchuk.market.repository;

import com.yosypchuk.market.model.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
}
