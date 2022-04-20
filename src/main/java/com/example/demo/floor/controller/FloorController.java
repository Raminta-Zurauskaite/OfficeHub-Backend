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

    @CrossOrigin
    @GetMapping("/{buildingID}")
    public List<FloorEntity> fetchBuildingFloors(@PathVariable Integer buildingID){
        return floorService.getAllBuildingFloors(buildingID).stream().map(p -> new FloorEntity(p.getFloorID(), buildingID, p.getFloorName())).collect(Collectors.toList());
    }

    @GetMapping
    public List<FloorEntity> fetchAllFloors() {
        return floorService.getAllFloors().stream().map(p -> new FloorEntity(p.getFloorID(), p.getBuildingID(), p.getFloorName())).collect(Collectors.toList());
    }

    @DeleteMapping("/{floorID}")
    public ResponseEntity deleteFloor(@PathVariable Integer floorID){
        return new ResponseEntity(floorService.deleteFloor(floorID), HttpStatus.OK);
    }
}