package com.example.demo.desk.service;

import com.example.demo.desk.entity.DeskEntity;

import java.util.List;
import java.util.Optional;

public interface DeskService {

    DeskEntity saveDeskEntity(DeskEntity deskEntity);

    List<DeskEntity> getAllFloorDesks(Long floor_id);

    List<DeskEntity> getAllDesks();

    Integer getDeskNumberById(Long desk_id);

    String deleteDesk(Long desk_id);
}