package com.example.demo.city.service;

import com.example.demo.city.entity.CityEntity;
import com.example.demo.city.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Override
    public CityEntity saveCityEntity(CityEntity cityEntity){
        return cityRepository.save(cityEntity);
    }

    @Override
    public List<CityEntity> getAllCities(){
        return cityRepository.findAll();
    }

    @Override
    public String deleteCity(Long city_id){
        cityRepository.deleteById(city_id);
        return "Deleted";
    }
}
