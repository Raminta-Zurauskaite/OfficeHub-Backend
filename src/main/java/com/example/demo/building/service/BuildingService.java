package com.example.demo.building.service;

import com.example.demo.building.entity.BuildingEntity;

import java.util.List;

public interface BuildingService {

    BuildingEntity saveBuildingEntity(BuildingEntity buildingEntity);

    List<BuildingEntity> getAllCityBuildings(Long city_id);

    List<BuildingEntity> getAllBuildings();

    String deleteBuilding(Long building_id);
}
