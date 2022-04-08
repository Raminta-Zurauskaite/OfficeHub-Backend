package com.example.demo.city.controller;

import com.example.demo.city.entity.CityEntity;
import com.example.demo.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity saveCity(@RequestBody CityEntity cityEntity){
        return new ResponseEntity(cityService.saveCityEntity(cityEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CityEntity> fetchAllCities(){
        return cityService.getAllCities().stream().map(p -> new CityEntity(p.getCity_id(), p.getCity_name())).collect(Collectors.toList());
    }

    @DeleteMapping("/{city_id}")
    public ResponseEntity deleteCity(@PathVariable Long city_id){
        return new ResponseEntity(cityService.deleteCity(city_id), HttpStatus.OK);
    }
}
