package com.example.demo.desk.controller;

import com.example.demo.desk.entity.DeskEntity;
import com.example.demo.desk.entity.FloorDesks;
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

    @CrossOrigin
    @GetMapping("/{floorID}")
    public List<FloorDesks> fetchFloorDesks(@PathVariable Integer floorID){
        return deskService.getAllFloorDesksByFloorID(floorID).stream().map(p -> new FloorDesks(p.getDesk_id(), p.getDesk_number(), p.getDesk_coordinates())).collect(Collectors.toList());
    }

    @GetMapping
    public List<DeskEntity> fetchAllDesks(){
        return deskService.getAllDesks().stream().map(p -> new DeskEntity(p.getDeskID(), p.getFloorID(), p.getDesk_number())).collect(Collectors.toList());
    }

    @DeleteMapping("/{deskID}")
    public ResponseEntity deleteDesk(@PathVariable Integer deskID){
        return new ResponseEntity(deskService.deleteDesk(deskID), HttpStatus.OK);
    }
}