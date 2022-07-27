package com.yosypchuk.market.utils.test;

import com.yosypchuk.market.model.dto.CategoryDTO;
import com.yosypchuk.market.model.entity.ProductCategory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestCategoryDataUtil {
    public static Long MOCK_ID = 1L;
    public static String MOCK_NAME = "Category name";

    public static ProductCategory createCategory() {
        return ProductCategory.builder()
                .id(MOCK_ID)
                .name(MOCK_NAME)
                .build();
    }

    public static CategoryDTO createCategoryDto() {
        return CategoryDTO.builder()
                .id(MOCK_ID)
                .name(MOCK_NAME)
                .build();
    }
}
