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

    @CrossOrigin
    @GetMapping
    public List<CityEntity> fetchAllCities(){
        return cityService.getAllCities().stream().map(p -> new CityEntity(p.getCityID(), p.getCity_name(), p.getCountry())).collect(Collectors.toList());
    }

    @DeleteMapping("/{cityID}")
    public ResponseEntity deleteCity(@PathVariable Integer cityID){
        return new ResponseEntity(cityService.deleteCity(cityID), HttpStatus.OK);
    }
}
