package com.example.demo.booking.service;

import com.example.demo.booking.entity.BookingEntity;
import com.example.demo.booking.entity.UserBookings;

import java.util.Date;
import java.util.List;

public interface BookingService {

    BookingEntity saveBookingEntity(BookingEntity bookingEntity);

    List<BookingEntity> getAllFloorAndDateBookings(Integer floorID, String bookingDate);

    List<UserBookings> findAllByUserID(Integer userID);

    List<BookingEntity> getAllBookings();

    String deleteBooking(Integer bookingID);


}
