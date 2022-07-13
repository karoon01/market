package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.entity.Product;
import com.yosypchuk.market.entity.WishList;
import com.yosypchuk.market.repository.WishListRepository;
import com.yosypchuk.market.service.WishListService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishListServiceImpl implements WishListService {

    private WishListRepository wishListRepository;

    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public void addProductToWishList(WishList wishList, Product product) {

    }

    @Override
    public List<Product> getAllUserProductsFromWishList(Long userId){
        return wishListRepository.findAll()
                .stream()
                .filter(e -> e.getUser().getId() == userId)
                .map(e -> e.getProduct())
                .collect(Collectors.toList());
    }
}
