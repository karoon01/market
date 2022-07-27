package com.yosypchuk.market.model.dto;

import com.yosypchuk.market.model.entity.ProductCategory;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ProductDTO {
    private Long id;

    @NotBlank(message = "${product.name.not-blank}")
    private String name;
    @NotNull(message = "${product.category.not-blank}")
    private ProductCategory category;
    @NotBlank(message = "${product.description.not-blank}")
    private String description;

    @Min(value = 0, message = "${product.rate.min}")
    @Max(value = 5, message = "${product.rate.max}")
    private Double averageRate;

    @Min(value = 0, message = "${product.price.positive}")
    private Double price;

    @Min(value = 0L, message = "${product.amount.positive}")
    private Integer amount;
}
