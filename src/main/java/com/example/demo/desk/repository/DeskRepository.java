package com.example.demo.desk.repository;

import com.example.demo.desk.entity.DeskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeskRepository extends JpaRepository<DeskEntity, Long> {
    List<DeskEntity> findAllByFloor_id(Long floor_id);

    @Query("select d.desk_number from DeskEntity d where d.desk_id = ?1")
    Integer getDeskNumberById(Long desk_id);
}