package com.example.demo.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
