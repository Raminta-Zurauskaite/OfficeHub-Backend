package com.example.demo.desk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "'floor_desks'")
@Subselect("select fd.* from floor_desks fd")
public class FloorDesks {
    @Id
    @Column(name = "desk_id")
    private Integer desk_id;

    @Column(name = "desk_number")
    private Integer desk_number;

    @Column(name = "desk_coordinates")
    private String desk_coordinates;
}