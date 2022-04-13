package com.example.demo.city.entity;

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
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityID;

    @Column(name = "city_name", length = 20, nullable = false)
    private String city_name;

    @Column(name = "country", length = 20, nullable = false)
    private String country;
}
