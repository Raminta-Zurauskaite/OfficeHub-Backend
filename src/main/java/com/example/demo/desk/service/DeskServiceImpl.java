package com.example.demo.desk.service;

import com.example.demo.desk.entity.DeskEntity;
import com.example.demo.desk.entity.FloorDesks;
import com.example.demo.desk.repository.DeskRepository;
import com.example.demo.desk.repository.FloorDesksRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class DeskServiceImpl implements DeskService{

    private final DeskRepository deskRepository;
    private final FloorDesksRepository floorDesksRepository;

    public DeskServiceImpl(DeskRepository deskRepository, FloorDesksRepository floorDesksRepository) {
        this.deskRepository = deskRepository;
        this.floorDesksRepository = floorDesksRepository;
    }

    @Override
    public DeskEntity saveDeskEntity(DeskEntity deskEntity){
        return deskRepository.save(deskEntity);
    }

    @Override
    public List<FloorDesks> getAllFloorDesksByFloorID(Integer floorID){
        return floorDesksRepository.findAllFloorDesksByFloorID(floorID);
    }

    @Override
    public List<DeskEntity> getAllDesks(){
        return deskRepository.findAll();
    }

    @Override
    public Integer getDeskNumberById(Integer deskID){
        return deskRepository.getDeskNumberById(deskID);
    }

    @Override
    public String deleteDesk(Integer floorID){
        deskRepository.deleteById(floorID);
        return "Deleted";
    }
}