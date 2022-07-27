package com.yosypchuk.market.utils.test;

import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.User;
import com.yosypchuk.market.model.entity.WishList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestWishListDataUtil {
    public static Long MOCK_ID = 1L;
    public static User MOCK_USER = TestUserDataUtil.createUser();
    public static Product MOCK_PRODUCT = TestProductDataUtil.createProduct();

    public static Long MOCK_ID_SECOND = 2L;
    public static Product MOCK_PRODUCT_SECOND = TestProductDataUtil.createSecondProduct();

    public static WishList createWishList() {
        return WishList.builder()
                .id(MOCK_ID)
                .user(MOCK_USER)
                .product(MOCK_PRODUCT)
                .build();
    }

    public static WishList createSecondWishList() {
        return WishList.builder()
                .id(MOCK_ID_SECOND)
                .user(MOCK_USER)
                .product(MOCK_PRODUCT_SECOND)
                .build();
    }

}
