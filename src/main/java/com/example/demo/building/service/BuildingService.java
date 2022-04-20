package com.example.demo.building.service;

import com.example.demo.building.entity.BuildingEntity;

import java.util.List;

public interface BuildingService {

    BuildingEntity saveBuildingEntity(BuildingEntity buildingEntity);

    List<BuildingEntity> getAllCityBuildings(Integer cityID);

    List<BuildingEntity> getAllBuildings();

    String deleteBuilding(Integer buildingID);
}
