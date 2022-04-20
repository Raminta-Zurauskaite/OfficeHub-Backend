package com.example.demo.city.service;

import com.example.demo.city.entity.CityEntity;
import com.example.demo.city.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public CityEntity saveCityEntity(CityEntity cityEntity){
        return cityRepository.save(cityEntity);
    }

    @Override
    public List<CityEntity> getAllCities(){
        return cityRepository.findAll();
    }

    @Override
    public String deleteCity(Integer cityID){
        cityRepository.deleteById(cityID);
        return "Deleted";
    }
}
