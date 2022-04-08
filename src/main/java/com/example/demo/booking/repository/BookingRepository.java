package com.example.demo.booking.repository;

import com.example.demo.booking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findAllByUser_id(Long user_id);
    List<BookingEntity> findAllByFloor_idAndBooking_date(Long floor_id, Date booking_date);
}
