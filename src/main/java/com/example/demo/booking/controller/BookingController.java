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

    @GetMapping("/{floorID}/date/{bookingDate}")
    public List<Integer> fetchAllFloorAndDateBookings(@PathVariable Integer floorID, @PathVariable Date bookingDate) {
        return bookingService.getAllFloorAndDateBookings(floorID, bookingDate).stream().map(p -> deskService.getDeskNumberById(p.getDeskID())).collect(Collectors.toList());
    }

    @GetMapping("/{userID}")
    public List<BookingEntity> fetchAllUserBookings(@PathVariable Integer userID){
        return bookingService.getAllUserBookings(userID).stream().map(p -> new BookingEntity(p.getBooking_id(), userID, p.getCityID(), p.getBuildingID(), p.getFloorID(), p.getDeskID(), p.getBookingDate())).collect(Collectors.toList());
    }

    @GetMapping
    public List<BookingEntity> fetchAllBookings() {
        return bookingService.getAllBookings().stream().map(p -> new BookingEntity(p.getBooking_id(), p.getUserID(), p.getCityID(), p.getBuildingID(), p.getFloorID(), p.getDeskID(), p.getBookingDate())).collect(Collectors.toList());
    }

    @DeleteMapping("/{bookingID}")
    public ResponseEntity deleteBooking(@PathVariable Integer bookingID){
        return new ResponseEntity(bookingService.deleteBooking(bookingID), HttpStatus.OK);
    }
}
