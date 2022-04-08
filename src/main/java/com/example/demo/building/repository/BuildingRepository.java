package com.example.demo.building.repository;

import com.example.demo.building.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
    List<BuildingEntity> findAllByCity_id(Long city_id);
}
