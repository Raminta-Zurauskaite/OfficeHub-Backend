package com.example.demo.floor.repository;

import com.example.demo.floor.entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FloorRepository extends JpaRepository<FloorEntity, Integer> {
    List<FloorEntity> findAllByBuildingID(Integer building_id);
}