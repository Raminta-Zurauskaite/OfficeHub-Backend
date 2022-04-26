package com.example.demo.desk.entity;

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
public class DeskCoordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer floorDeskID;

    @Column(name = "coordinates", length = 50, nullable = false)
    private String coordinates;
}