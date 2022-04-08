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
public class DeskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long desk_id;

    @Column(name = "floor_id", length = 5, nullable = false)
    private Long floor_id;

    @Column(name = "desk_number", length = 5, nullable = false)
    private Integer desk_number;
}
