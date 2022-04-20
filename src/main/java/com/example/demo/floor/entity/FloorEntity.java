package com.example.demo.floor.entity;

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
public class FloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer floorID;

    @Column(name = "buildingID", length = 10, nullable = false)
    private Integer buildingID;

    @Column(name = "floorName", length = 100, nullable = false)
    private String floorName;
}
