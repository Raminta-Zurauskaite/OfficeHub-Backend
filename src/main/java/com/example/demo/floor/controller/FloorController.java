package com.example.demo.floor.controller;

import com.example.demo.floor.entity.FloorEntity;
import com.example.demo.floor.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("floor")
public class FloorController {

    @Autowired
    private FloorService floorService;

    @PostMapping
    public ResponseEntity saveFloor(@RequestBody FloorEntity floorEntity){
        return new ResponseEntity(floorService.saveFloorEntity(floorEntity), HttpStatus.CREATED);
    }

    @GetMapping("/{building_id}")
    public List<FloorEntity> fetchBuildingFloors(@PathVariable Long building_id){
        return floorService.getAllBuildingFloors(building_id).stream().map(p -> new FloorEntity(p.getFloor_id(), building_id, p.getFloor_number())).collect(Collectors.toList());
    }

    @GetMapping
    public List<FloorEntity> fetchAllFloors() {
        return floorService.getAllFloors().stream().map(p -> new FloorEntity(p.getFloor_id(), p.getBuilding_id(), p.getFloor_number())).collect(Collectors.toList());
    }

    @DeleteMapping("/{floor_id}")
    public ResponseEntity deleteFloor(@PathVariable Long floor_id){
        return new ResponseEntity(floorService.deleteFloor(floor_id), HttpStatus.OK);
    }
}