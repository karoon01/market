package com.yosypchuk.market.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    Role role;
}
