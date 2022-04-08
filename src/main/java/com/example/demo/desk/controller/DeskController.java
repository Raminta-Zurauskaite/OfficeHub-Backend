package com.example.demo.desk.controller;

import com.example.demo.desk.entity.DeskEntity;
import com.example.demo.desk.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("desk")
public class DeskController {

    @Autowired
    private DeskService deskService;

    @PostMapping
    public ResponseEntity saveDesk(@RequestBody DeskEntity deskEntity){
        return new ResponseEntity(deskService.saveDeskEntity(deskEntity), HttpStatus.CREATED);
    }

    @GetMapping("/{floor_id}")
    public List<DeskEntity> fetchFloorDesks(@PathVariable Long floor_id){
        return deskService.getAllFloorDesks(floor_id).stream().map(p -> new DeskEntity(p.getDesk_id(), p.getFloor_id(), p.getDesk_number())).collect(Collectors.toList());
    }

    @GetMapping
    public List<DeskEntity> fetchAllDesks(){
        return deskService.getAllDesks().stream().map(p -> new DeskEntity(p.getDesk_id(), p.getFloor_id(), p.getDesk_number())).collect(Collectors.toList());
    }

    @DeleteMapping("{/floor_id}")
    public ResponseEntity deleteDesk(@PathVariable Long floor_id){
        return new ResponseEntity(deskService.deleteDesk(floor_id), HttpStatus.OK);
    }
}