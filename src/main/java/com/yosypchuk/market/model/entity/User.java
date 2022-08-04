package com.yosypchuk.market.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String password;

    @Column(unique = true)
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private boolean isBlocked;
    private boolean is2FA;
}
