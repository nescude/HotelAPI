package com.nescude.hotelfront.model.room;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RoomConsumer {
    
    @Value("${backend.host}")
    private String host;

    @Autowired
    RestTemplate rt;

    @PostConstruct
    private void pc(){host+="/room";}

    public List<Room> getAllRooms() {
        String url = this.host + "/all";
        List<Room> list = rt.getForObject(url, List.class);
        return list;
    }

    public Room getRoom(String code) {
        String url = this.host + "/" + code;
        Room r = rt.getForObject(url, Room.class);
        return r;
    }

    public Boolean delRoom(int id) {
        String url = this.host + "/del/" + id;
        Boolean result = rt.getForObject(url, Boolean.class);
        return result;
    }

    public Boolean addRoom(Room room) {
        String url = this.host + "/add";
        Boolean result = rt.postForObject(url, room, Boolean.class);
        return result;
    }

    public List<Room> getAvailableRooms() {
        String url = this.host + "/available";
        List<Room> list = rt.getForObject(url, List.class);
        return list;
    }
}
