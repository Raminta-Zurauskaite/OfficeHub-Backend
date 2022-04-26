package com.example.demo.desk.repository;

import com.example.demo.desk.entity.FloorDesks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FloorDesksRepository  extends JpaRepository<FloorDesks, Integer> {
    @Query("select DISTINCT fd from FloorDesks fd, DeskEntity de where de.floorID = ?1 and fd.desk_id = de.deskID")
    List<FloorDesks> findAllFloorDesksByFloorID(Integer floorID);
}