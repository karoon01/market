package com.yosypchuk.market.dto;

import com.yosypchuk.market.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Size;

public class ProductDTO {

    @Size(min=3, message = "Name of product should have at least 3 characters")
    @Size(max=20, message = "Name of product should have not more than 20 characters")
    private String name;

    @Size(min=20, message = "Description should have at least 20 characters")
    @Size(max=100, message = "Description should have not more than 100 characters")
    private String description;

    private ProductCategory productCategory;
    private Double price;
    private double avarageRate;
    private Integer amount;
}
