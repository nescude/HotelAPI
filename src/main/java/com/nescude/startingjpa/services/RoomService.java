package com.nescude.startingjpa.services;

import java.util.ArrayList;

import com.nescude.startingjpa.models.Room;
import com.nescude.startingjpa.repositories.IRoomRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    IRoomRepo REPO;

    public Room getRoomDetails(String code){
        return REPO.findByCode(code);
    }
    
    public Iterable<Room> getAllRooms(){
        return REPO.findAll();
    }

    public Iterable<Room> getAvailableRooms() {
        Iterable<Integer> roomsIds = REPO.findAvailableRooms();
        ArrayList<Room> rooms = new ArrayList<>();
        for (Integer room : roomsIds){
            rooms.add(REPO.findById(room).get());
        }
        return rooms;
    }
}
