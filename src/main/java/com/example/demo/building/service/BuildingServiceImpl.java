package com.example.demo.building.service;

import com.example.demo.building.entity.BuildingEntity;
import com.example.demo.building.repository.BuildingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService{

    private final BuildingRepository buildingRepository;

    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public BuildingEntity saveBuildingEntity(BuildingEntity buildingEntity){
        return buildingRepository.save(buildingEntity);
    }

    @Override
    public List<BuildingEntity> getAllCityBuildings(Integer cityID){
        return buildingRepository.findAllByCityID(cityID);
    }

    @Override
    public List<BuildingEntity> getAllBuildings(){
        return buildingRepository.findAll();
    }

    @Override
    public String deleteBuilding(Integer buildingID){
        buildingRepository.deleteById(buildingID);
        return "Deleted";
    }

}
