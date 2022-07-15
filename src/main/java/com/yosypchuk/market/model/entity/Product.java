package com.yosypchuk.market.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory category;

    private String description;
    private Double price;
    private Integer amount;
}
