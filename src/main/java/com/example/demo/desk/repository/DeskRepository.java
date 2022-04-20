package com.example.demo.desk.repository;

import com.example.demo.desk.entity.DeskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeskRepository extends JpaRepository<DeskEntity, Integer> {
    List<DeskEntity> findAllByFloorID(Integer floorID);

    @Query("select d.desk_number from DeskEntity d where d.deskID = ?1")
    Integer getDeskNumberById(Integer deskID);
}