package com.yosypchuk.market.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CategoryDTO {
    private Long id;

    @NotBlank(message = "${product.name.not-blank}")
    private String name;
}
