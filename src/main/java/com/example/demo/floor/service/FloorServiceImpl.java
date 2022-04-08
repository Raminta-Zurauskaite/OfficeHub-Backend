package com.example.demo.floor.service;

import com.example.demo.floor.entity.FloorEntity;
import com.example.demo.floor.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService{

    @Autowired
    private FloorRepository floorRepository;

    @Override
    public FloorEntity saveFloorEntity(FloorEntity floorEntity){
        return floorRepository.save(floorEntity);
    }

    @Override
    public List<FloorEntity> getAllBuildingFloors(Long building_id){
        return floorRepository.findAllByBuilding_id(building_id);
    }

    @Override
    public List<FloorEntity> getAllFloors(){
        return floorRepository.findAll();
    }

    @Override
    public String deleteFloor(Long floor_id){
        floorRepository.deleteById(floor_id);
        return "Deleted";
    }
}