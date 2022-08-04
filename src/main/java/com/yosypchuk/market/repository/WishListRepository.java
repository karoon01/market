package com.yosypchuk.market.repository;

import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
    @Query("SELECT wl.product FROM WishList wl WHERE wl.user.id=?1")
    List<Product> findAllByUserId(Long userId);

    @Modifying
    @Query(value = "INSERT INTO wish_list (user_id, product_id) VALUES (:userId, :productId)",
            nativeQuery = true)
    @Transactional
    void addProductToWishList(@Param("userId") Long userId,
                              @Param("productId") Long productId);

    @Modifying
    @Query("DELETE FROM WishList w WHERE w.user.id=?1 AND w.product.id=?2")
    @Transactional
    void deleteProductFromWishList(Long userId, Long productId);
}
