package com.example.demo.booking.repository;

import com.example.demo.booking.entity.UserBookings;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserBookingRepository extends JpaRepository<UserBookings, Integer> {
    @Query("select DISTINCT ub from UserBookings ub where ub.userid = ?1")
    List<UserBookings> findAllByUserID(Integer userID);
}
