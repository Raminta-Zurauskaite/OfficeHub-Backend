package com.example.demo.building.entity;

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
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long building_id;

    @Column(name = "city_id", length = 5, nullable = false)
    private Long city_id;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

}
