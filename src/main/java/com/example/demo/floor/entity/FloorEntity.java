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
    private Long floor_id;

    @Column(name = "building_id", length = 5, nullable = false)
    private Long building_id;

    @Column(name = "floor_number", length = 5, nullable = false)
    private Long floor_number;
}
