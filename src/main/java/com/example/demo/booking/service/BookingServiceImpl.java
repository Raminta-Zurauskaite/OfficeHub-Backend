package com.example.demo.booking.service;

import com.example.demo.booking.entity.BookingEntity;
import com.example.demo.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingEntity saveBookingEntity(BookingEntity bookingEntity){
        return bookingRepository.save(bookingEntity);
    }

    @Override
    public List<BookingEntity> getAllFloorAndDateBookings(Long floor_id, Date booking_date){
        return bookingRepository.findAllByFloor_idAndBooking_date(floor_id, booking_date);
    }

    @Override
    public List<BookingEntity> getAllUserBookings(Long user_id){
        return bookingRepository.findAllByUser_id(user_id);
    }

    @Override
    public List<BookingEntity> getAllBookings(){
        return bookingRepository.findAll();
    }

    @Override
    public String deleteBooking(Long booking_id){
        bookingRepository.deleteById(booking_id);
        return "Deleted";
    }
}
