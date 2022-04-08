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

    @Column(name = "user_id", length = 5, nullable = false)
    private Long user_id;

    @Column(name = "city_id", length = 5, nullable = false)
    private Long city_id;

    @Column(name = "building_id", length = 5, nullable = false)
    private Long building_id;

    @Column(name = "floor_id", length = 5, nullable = false)
    private Long floor_id;

    @Column(name = "desk_id", length = 5, nullable = false)
    private Long desk_id;

    @Column(name = "date", length = 15, nullable = false)
    private Date booking_date;
}
