package com.example.demo.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "'bookings'")
@Subselect("select b.* from bookings b")
public class UserBookings implements Serializable {

    @Id
    @Column(name = "booking_id")
    private Integer booking_id;

    @Column(name = "userid")
    private Integer userid;

    @Column(name = "desk_number")
    private Integer desk_number;

    @Column(name = "floor_name")
    private String floor_name;

    @Column(name = "building_name")
    private String building_name;

    @Column(name = "city_name")
    private String city_name;

    @Column(name = "booking_date")
    private String booking_date;

}