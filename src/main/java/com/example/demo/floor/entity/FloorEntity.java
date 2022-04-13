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

    @Column(name = "buildingID", length = 5, nullable = false)
    private Integer buildingID;

    @Column(name = "floor_number", length = 5, nullable = false)
    private Integer floor_number;
}
