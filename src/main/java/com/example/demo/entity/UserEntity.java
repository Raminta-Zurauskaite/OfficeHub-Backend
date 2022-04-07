package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @Column(name = "surname", length = 10, nullable = false)
    private String surname;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "password", length = 20, nullable = false)
    private String password;
}
