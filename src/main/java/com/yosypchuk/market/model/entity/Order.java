package com.yosypchuk.market.model.entity;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    Cart cart;

    @NotNull
    private String city;
    @NotNull
    private String postNumber;
    @Transient
    private double totalPrice;
}
