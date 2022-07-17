package com.yosypchuk.market.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
//@Entity
//@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private String city;
    private String postNumber;
    private Double totalPrice;
}
