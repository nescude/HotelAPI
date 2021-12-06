package com.nescude.startingjpa.repositories;

import java.sql.Date;

import com.nescude.startingjpa.models.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface IReservationRepo extends CrudRepository<Reservation,Integer>{


    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 'TRUE' ELSE 'FALSE' END FROM RESERVATION "+
        "WHERE ((:inDate BETWEEN in_date AND out_date)OR(:outDate BETWEEN in_date AND out_date)) AND id_room = :idRoom", nativeQuery = true)
    public boolean isOccupied (
        @Param("inDate") Date inDate, 
        @Param("outDate") Date outDate,
        @Param("idRoom") int idRoom);

    public boolean deleteById(int id);
}
