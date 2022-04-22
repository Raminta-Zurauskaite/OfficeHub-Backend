package com.example.demo.desk.service;

import com.example.demo.desk.entity.DeskEntity;
import com.example.demo.desk.repository.DeskRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class DeskServiceImpl implements DeskService{

    private final DeskRepository deskRepository;

    public DeskServiceImpl(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

    @Override
    public DeskEntity saveDeskEntity(DeskEntity deskEntity){
        return deskRepository.save(deskEntity);
    }

    @Override
    public List<DeskEntity> getAllFloorDesks(Integer floorID){
        return deskRepository.findAllByFloorID(floorID);
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