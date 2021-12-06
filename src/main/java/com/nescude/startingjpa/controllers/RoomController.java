package com.nescude.startingjpa.controllers;

import com.nescude.startingjpa.models.Room;
import com.nescude.startingjpa.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    
    @Autowired
    RoomService service;

    // @PostMapping("/add")
    // public boolean postRoom(@RequestBody Room room){
    //     return service.postRoom(room);
    // }

    @GetMapping("/{code}")
    public Room getRoomDetails(@PathVariable String code){
        return service.getRoomDetails(code);
    }

    // @DeleteMapping("/del/{code}")
    // public boolean deleteRoom(@PathVariable String code){
    //     return service.deleteRoom(code);
    // }

    @GetMapping("/all")
    public Iterable<Room> getAllRooms(){
        return service.getAllRooms();
    }

    @GetMapping("/available")
    public Iterable<Room> getAvailableRooms(){
        return service.getAvailableRooms();
    }

}
