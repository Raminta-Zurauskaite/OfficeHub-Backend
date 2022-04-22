package com.example.demo.building.controller;

import com.example.demo.building.entity.BuildingEntity;
import com.example.demo.building.service.BuildingService;
import com.example.demo.floor.entity.FloorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public ResponseEntity saveBuilding(@RequestBody BuildingEntity buildingEntity){
        return new ResponseEntity(buildingService.saveBuildingEntity(buildingEntity), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/{cityID}")
    public List<BuildingEntity> fetchCityBuildings(@PathVariable Integer cityID){
        return buildingService.getAllCityBuildings(cityID).stream().map(p -> new BuildingEntity(p.getBuildingID(), p.getCityID(), p.getAddress(), p.getBuildingName())).collect(Collectors.toList());
    }

    @GetMapping
    public List<BuildingEntity> fetchAllBuildings() {
        return buildingService.getAllBuildings().stream().map(p -> new BuildingEntity(p.getBuildingID(), p.getCityID(), p.getAddress(), p.getBuildingName())).collect(Collectors.toList());
    }

    @DeleteMapping("/{buildingID}")
    public ResponseEntity deleteBuilding(@PathVariable Integer buildingID){
        return new ResponseEntity(buildingService.deleteBuilding(buildingID), HttpStatus.OK);
    }
}
