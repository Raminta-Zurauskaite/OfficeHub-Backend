package com.example.demo.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_id;

    @Column(name = "userID", length = 5, nullable = false)
    private Integer userID;

    @Column(name = "cityID", length = 5, nullable = false)
    private Integer cityID;

    @Column(name = "buildingID", length = 5, nullable = false)
    private Integer buildingID;

    @Column(name = "floorID", length = 5, nullable = false)
    private Integer floorID;

    @Column(name = "deskID", length = 5, nullable = false)
    private Integer deskID;

    @Column(name = "bookingDate", length = 15, nullable = false)
    private String bookingDate;

}
