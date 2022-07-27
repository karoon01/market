package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.mapper.ProductMapper;
import com.yosypchuk.market.model.dto.ProductDTO;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.User;
import com.yosypchuk.market.model.entity.WishList;
import com.yosypchuk.market.repository.ProductRepository;
import com.yosypchuk.market.repository.UserRepository;
import com.yosypchuk.market.repository.WishListRepository;
import com.yosypchuk.market.service.WishListService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class WishListServiceImpl implements WishListService {

    private WishListRepository wishListRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Override
    public void addProductToWishList(Long userId, Long productId) {
        log.info("Trying to get user with id: {}", userId);
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User doesn't exist!"));

        log.info("Trying to get product with id: {}", productId);
        productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product doesn't exist!"));

        log.info("Add product with id: {} to user's wishlist with id: {}", productId, userId);
        wishListRepository.addProductToWishList(userId, productId);
    }

    @Override
    public List<ProductDTO> getAllUserProductsFromWishList(Long userId) {
        log.info("Trying to get user with id: {}", userId);
        userRepository.findById(userId)
                        .orElseThrow(() -> new EntityNotFoundException("User doesn't exist!"));

        log.info("Get all user's products from wish list");
        return wishListRepository.findAllByUserId(userId)
                .stream()
                .map(ProductMapper.INSTANCE::mapProductDto)
                .collect(Collectors.toList());
    }
}
