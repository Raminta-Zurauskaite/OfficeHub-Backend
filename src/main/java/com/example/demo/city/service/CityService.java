package com.example.demo.city.service;

import com.example.demo.city.entity.CityEntity;

import java.util.List;

public interface CityService {

    CityEntity saveCityEntity(CityEntity cityEntity);

    List<CityEntity> getAllCities();

    String deleteCity(Long city_id);

}
