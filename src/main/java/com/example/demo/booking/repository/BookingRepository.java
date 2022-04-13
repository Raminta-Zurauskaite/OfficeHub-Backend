package com.example.demo.booking.repository;

import com.example.demo.booking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
    List<BookingEntity> findAllByUserID(Integer userID);

    @Query("select DISTINCT be from BookingEntity be where be.floorID = ?1 and be.bookingDate = ?2")
    List<BookingEntity> findAllByFloorIDAndAndBookingDate(Integer floorID, Date bookingDate);
}
