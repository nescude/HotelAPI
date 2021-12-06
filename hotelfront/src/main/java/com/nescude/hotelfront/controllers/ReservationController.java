package com.nescude.hotelfront.controllers;

import com.nescude.hotelfront.model.inputs.ReservationForm;
import com.nescude.hotelfront.model.reservation.Reservation;
import com.nescude.hotelfront.model.reservation.ReservationConsumer;
import com.nescude.hotelfront.model.room.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    
    @Autowired
    ReservationConsumer CONSUMER;

    @GetMapping("/")
    public String clientPage(Model modelo){
        Iterable<ReservationForm> list = CONSUMER.getAllReservations();
        modelo.addAttribute("reservations", list);
        modelo.addAttribute("reservation", new ReservationForm());
        return "reservations";
    }

    @PostMapping("/add")
    public String addUser(Model modelo, @ModelAttribute ReservationForm reservation){
        if (CONSUMER.addReservation(reservation)){
            modelo.addAttribute("msg", "Reserva Creada Correctamente");
            return "complete";
        }
        else
            return "error";            
    }

    @PostMapping("/del/{id}")
    public String addUser(Model modelo, @PathVariable int id){
        if (CONSUMER.delReservation(id)){
            modelo.addAttribute("msg", "Reserva Borrada Correctamente");
            return "complete";
        }
        else
            return "error";
    }
}
