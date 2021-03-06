package com.example.demo.desk.service;

import com.example.demo.desk.entity.DeskEntity;
import com.example.demo.desk.entity.FloorDesks;

import java.util.List;
import java.util.Optional;

public interface DeskService {

    DeskEntity saveDeskEntity(DeskEntity deskEntity);

    List<FloorDesks> getAllFloorDesksByFloorID(Integer floorID);

    List<DeskEntity> getAllDesks();

    Integer getDeskNumberById(Integer deskID);

    String deleteDesk(Integer deskID);
}