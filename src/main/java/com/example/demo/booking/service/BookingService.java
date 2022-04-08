package com.example.demo.booking.service;

import com.example.demo.booking.entity.BookingEntity;

import java.util.Date;
import java.util.List;

public interface BookingService {

    BookingEntity saveBookingEntity(BookingEntity bookingEntity);

    List<BookingEntity> getAllFloorAndDateBookings(Long floor_id, Date booking_date);

    List<BookingEntity> getAllUserBookings(Long user_id);

    List<BookingEntity> getAllBookings();

    String deleteBooking(Long booking_id);
}
