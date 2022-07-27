package com.yosypchuk.market.utils.test;

import com.yosypchuk.market.model.dto.ProductDTO;
import com.yosypchuk.market.model.entity.Product;
import com.yosypchuk.market.model.entity.ProductCategory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestProductDataUtil {
    public static Long MOCK_ID = 1L;
    public static String MOCK_NAME = "Product name";
    public static String MOCK_DESCRIPTION = "Product description";
    public static ProductCategory MOCK_CATEGORY = TestCategoryDataUtil.createCategory();
    public static Double MOCK_AVERAGE_RATE = 0.0;
    public static Double MOCK_PRICE = 0.0;
    public static Integer MOCK_AMOUNT = 0;

    public static Long MOCK_ID_SECOND = 2L;
    public static String MOCK_NAME_SECOND = "Second product name";
    public static String MOCK_DESCRIPTION_SECOND = "Second product description";
    public static Integer MOCK_AMOUNT_UPDATED = 5;

    public static Product createProduct() {
        return Product.builder()
                .id(MOCK_ID)
                .name(MOCK_NAME)
                .description(MOCK_DESCRIPTION)
                .category(MOCK_CATEGORY)
                .averageRate(MOCK_AVERAGE_RATE)
                .price(MOCK_PRICE)
                .amount(MOCK_AMOUNT)
                .build();
    }

    public static ProductDTO createProductDto() {
        return ProductDTO.builder()
                .id(MOCK_ID)
                .name(MOCK_NAME)
                .description(MOCK_DESCRIPTION)
                .category(MOCK_CATEGORY)
                .averageRate(MOCK_AVERAGE_RATE)
                .price(MOCK_PRICE)
                .amount(MOCK_AMOUNT)
                .build();
    }

    public static Product createUpdateProduct() {
        return Product.builder()
                .id(MOCK_ID)
                .name(MOCK_NAME_SECOND)
                .description(MOCK_DESCRIPTION_SECOND)
                .category(MOCK_CATEGORY)
                .averageRate(MOCK_AVERAGE_RATE)
                .price(MOCK_PRICE)
                .amount(MOCK_AMOUNT_UPDATED)
                .build();
    }

    public static ProductDTO createUpdateProductDto() {
        return ProductDTO.builder()
                .id(MOCK_ID)
                .name(MOCK_NAME_SECOND)
                .description(MOCK_DESCRIPTION_SECOND)
                .category(MOCK_CATEGORY)
                .averageRate(MOCK_AVERAGE_RATE)
                .price(MOCK_PRICE)
                .amount(MOCK_AMOUNT_UPDATED)
                .build();
    }

    public static Product createSecondProduct() {
        return Product.builder()
                .id(MOCK_ID_SECOND)
                .name(MOCK_NAME_SECOND)
                .description(MOCK_DESCRIPTION_SECOND)
                .category(MOCK_CATEGORY)
                .averageRate(MOCK_AVERAGE_RATE)
                .price(MOCK_PRICE)
                .amount(MOCK_AMOUNT)
                .build();
    }

    public static ProductDTO createSecondProductDto() {
        return ProductDTO.builder()
                .id(MOCK_ID_SECOND)
                .name(MOCK_NAME_SECOND)
                .description(MOCK_DESCRIPTION_SECOND)
                .category(MOCK_CATEGORY)
                .averageRate(MOCK_AVERAGE_RATE)
                .price(MOCK_PRICE)
                .amount(MOCK_AMOUNT)
                .build();
    }
}
