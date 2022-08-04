package com.yosypchuk.market.model.dto;

import com.yosypchuk.market.model.entity.Cart;
import com.yosypchuk.market.model.entity.OrderStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class OrderDTO {
    private Long id;

    @NotBlank(message = "${order.cart.not-blank}")
    private Cart cart;

    private OrderStatus status;

    @NotBlank(message = "${order.city.not-blank}")
    private String city;
    @NotBlank(message = "${order.post.not-blank}")
    private String postNumber;

    @NotBlank(message = "${order.price.not-blank}")
    @Min(value = 0, message = "${order.price.min}")
    private Double totalPrice;
}
