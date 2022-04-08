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

    @GetMapping("/{city_id}")
    public List<BuildingEntity> fetchCityBuildings(@PathVariable Long city_id){
        return buildingService.getAllCityBuildings(city_id).stream().map(p -> new BuildingEntity(p.getBuilding_id(), city_id, p.getAddress())).collect(Collectors.toList());
    }

    @GetMapping
    public List<BuildingEntity> fetchAllBuildings() {
        return buildingService.getAllBuildings().stream().map(p -> new BuildingEntity(p.getBuilding_id(), p.getCity_id(), p.getAddress())).collect(Collectors.toList());
    }

    @DeleteMapping("/{building_id}")
    public ResponseEntity deleteBuilding(@PathVariable Long building_id){
        return new ResponseEntity(buildingService.deleteBuilding(building_id), HttpStatus.OK);
    }
}
