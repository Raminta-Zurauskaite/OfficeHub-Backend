package com.example.demo.floor.service;

import com.example.demo.floor.entity.FloorEntity;
import com.example.demo.floor.repository.FloorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService{

    private final FloorRepository floorRepository;

    public FloorServiceImpl(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    @Override
    public FloorEntity saveFloorEntity(FloorEntity floorEntity){
        return floorRepository.save(floorEntity);
    }

    @Override
    public List<FloorEntity> getAllBuildingFloors(Integer buildingID){
        return floorRepository.findAllByBuildingID(buildingID);
    }

    @Override
    public List<FloorEntity> getAllFloors(){
        return floorRepository.findAll();
    }

    @Override
    public String deleteFloor(Integer floorID){
        floorRepository.deleteById(floorID);
        return "Deleted";
    }
}