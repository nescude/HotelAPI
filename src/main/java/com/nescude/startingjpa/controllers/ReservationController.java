package com.nescude.startingjpa.controllers;

import com.nescude.startingjpa.forms.ReservationForm;
import com.nescude.startingjpa.models.Reservation;
import com.nescude.startingjpa.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService service;

    @PostMapping("/add")
    public boolean reservateRoom(@RequestBody ReservationForm reservation){
        return service.postReservation(reservation);
    }

    @GetMapping("/all")
    public Iterable<ReservationForm> reservateRoom(){
        return service.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable String id){
        return service.getReservation(id);
    }

    @DeleteMapping("/del/{id}")
    public boolean delReservation(@PathVariable int id){
        return service.delReservation(id);
    }
}
