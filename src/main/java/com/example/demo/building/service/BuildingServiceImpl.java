package com.example.demo.building.service;

import com.example.demo.building.entity.BuildingEntity;
import com.example.demo.building.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService{

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public BuildingEntity saveBuildingEntity(BuildingEntity buildingEntity){
        return buildingRepository.save(buildingEntity);
    }

    @Override
    public List<BuildingEntity> getAllCityBuildings(Long city_id){
        return buildingRepository.findAllByCity_id(city_id);
    }

    @Override
    public List<BuildingEntity> getAllBuildings(){
        return buildingRepository.findAll();
    }

    @Override
    public String deleteBuilding(Long building_id){
        buildingRepository.deleteById(building_id);
        return "Deleted";
    }

}
