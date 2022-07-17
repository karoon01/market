package com.yosypchuk.market.repository;

import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findCartByUserId(Long userId);

    @Query("SELECT c.product FROM Cart c WHERE c.user.id=?1")
    List<Product> getAllProductsFromCartByUserId(Long userId);

//    void addProductToCart(Long userId, Long productId);
//
//    void removeProductFromCart(Long userId, Long productId);
}
