package com.nescude.startingjpa.repositories;

import com.nescude.startingjpa.models.Room;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IRoomRepo extends CrudRepository<Room,Integer>{
    
    public Room findByCode(String roomCode);

    @Query(value = "SELECT r.id_room FROM room r WHERE r.id_room NOT IN "+
    "(SELECT DISTINCT(re.id_room) FROM reservation re "+
    " WHERE CURDATE() > IN_DATE AND CURDATE() < OUT_DATE )",nativeQuery = true)
    public Iterable<Integer> findAvailableRooms();

}
