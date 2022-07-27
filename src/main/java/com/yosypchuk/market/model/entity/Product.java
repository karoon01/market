package com.yosypchuk.market.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory category;

    private String description;
    private Double averageRate;
    private Double price;
    private Integer amount;
}
