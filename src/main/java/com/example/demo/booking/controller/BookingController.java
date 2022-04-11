package com.example.demo.booking.controller;

import com.example.demo.booking.entity.BookingEntity;
import com.example.demo.booking.service.BookingService;
import com.example.demo.desk.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private DeskService deskService;

    @PostMapping
    public ResponseEntity saveFloor(@RequestBody BookingEntity bookingEntity){
        return new ResponseEntity(bookingService.saveBookingEntity(bookingEntity), HttpStatus.CREATED);
    }

    @GetMapping("/{floor_id}/date/{booking_date}")
    public List<Integer> fetchAllFloorAndDateBookings(@PathVariable Long floor_id, @PathVariable Date booking_date) {
        return bookingService.getAllFloorAndDateBookings(floor_id, booking_date).stream().map(p -> deskService.getDeskNumberById(p.getDesk_id())).collect(Collectors.toList());
    }

    @GetMapping("/{user_id}")
    public List<BookingEntity> fetchAllUserBookings(@PathVariable Long user_id){
        return bookingService.getAllUserBookings(user_id).stream().map(p -> new BookingEntity(p.getBooking_id(), user_id, p.getCity_id(), p.getBuilding_id(), p.getFloor_id(), p.getDesk_id(), p.getBooking_date())).collect(Collectors.toList());
    }

    @GetMapping
    public List<BookingEntity> fetchAllBookings() {
        return bookingService.getAllBookings().stream().map(p -> new BookingEntity(p.getBooking_id(), p.getUser_id(), p.getCity_id(), p.getBuilding_id(), p.getFloor_id(), p.getDesk_id(), p.getBooking_date())).collect(Collectors.toList());
    }

    @DeleteMapping("/{booking_id}")
    public ResponseEntity deleteBooking(@PathVariable Long booking_id){
        return new ResponseEntity(bookingService.deleteBooking(booking_id), HttpStatus.OK);
    }
}
