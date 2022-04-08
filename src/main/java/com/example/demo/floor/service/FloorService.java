package com.example.demo.floor.service;

import com.example.demo.floor.entity.FloorEntity;

import java.util.List;

public interface FloorService {

    FloorEntity saveFloorEntity(FloorEntity floorEntity);

    List<FloorEntity> getAllBuildingFloors(Long building_id);

    List<FloorEntity> getAllFloors();

    String deleteFloor(Long floor_id);
}