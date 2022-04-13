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
    private Integer buildingID;

    @Column(name = "cityID", length = 5, nullable = false)
    private Integer cityID;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "buildingName", length = 100, nullable = false)
    private String buildingName;

}
