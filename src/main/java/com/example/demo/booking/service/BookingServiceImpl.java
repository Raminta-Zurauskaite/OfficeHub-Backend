package com.example.demo.booking.service;

import com.example.demo.booking.entity.BookingEntity;
import com.example.demo.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingEntity saveBookingEntity(BookingEntity bookingEntity){
        return bookingRepository.save(bookingEntity);
    }

    @Override
    public List<BookingEntity> getAllFloorAndDateBookings(Integer floorID, String bookingDate){
        return bookingRepository.findAllByFloorIDAndAndBookingDate(floorID, bookingDate);
    }

    @Override
    public List<BookingEntity> getAllUserBookings(Integer userID){
        return bookingRepository.findAllByUserID(userID);
    }

    @Override
    public List<BookingEntity> getAllBookings(){
        return bookingRepository.findAll();
    }

    @Override
    public String deleteBooking(Integer bookingID){
        bookingRepository.deleteById(bookingID);
        return "Deleted";
    }
}
