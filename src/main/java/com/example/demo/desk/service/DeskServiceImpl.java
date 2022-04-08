package com.example.demo.desk.service;

import com.example.demo.desk.entity.DeskEntity;
import com.example.demo.desk.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeskServiceImpl implements DeskService{

    @Autowired
    private DeskRepository deskRepository;

    @Override
    public DeskEntity saveDeskEntity(DeskEntity deskEntity){
        return deskRepository.save(deskEntity);
    }

    @Override
    public List<DeskEntity> getAllFloorDesks(Long floor_id){
        return deskRepository.findAllByFloor_id(floor_id);
    }

    @Override
    public List<DeskEntity> getAllDesks(){
        return deskRepository.findAll();
    }

    @Override
    public Integer getDeskNumberById(Long desk_id){
        return deskRepository.getDeskNumberById(desk_id);
    }

    @Override
    public String deleteDesk(Long floor_id){
        deskRepository.deleteById(floor_id);
        return "Deleted";
    }
}