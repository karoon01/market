package com.yosypchuk.market.model.dto;

import com.yosypchuk.market.model.entity.ProductCategory;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class ProductDTO {
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private ProductCategory productCategory;

    @Min(value = 0L, message = "${price.positive}")
    private Double price;

    @Min(value = 0L)
    @Max(value = 5L)
    private Double avarageRate;

    @Min(value = 0L, message = "${amount.positive}")
    private Integer amount;
}
