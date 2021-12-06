package com.nescude.startingjpa.services;

import java.sql.Date;
import java.util.ArrayList;

import com.nescude.startingjpa.forms.ReservationForm;
import com.nescude.startingjpa.models.Client;
import com.nescude.startingjpa.models.Reservation;
import com.nescude.startingjpa.models.Room;
import com.nescude.startingjpa.repositories.IClientRepo;
import com.nescude.startingjpa.repositories.IReservationRepo;
import com.nescude.startingjpa.repositories.IRoomRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {

    @Autowired
    IReservationRepo REPO;

    @Autowired
    IClientRepo CLIENTREPO;

    @Autowired
    IRoomRepo ROOMREPO;

    public boolean postReservation(ReservationForm reservation) {
        Date in = Date.valueOf(reservation.getInDate());
        Date out = Date.valueOf(reservation.getOutDate());
        Client c = CLIENTREPO.findByDni(reservation.getClientDNI());
        Room r = ROOMREPO.findByCode(reservation.getRoomCode());
        if (c == null || r == null || in == null || out == null) return false;
        
        if (!REPO.isOccupied(out,in,r.getIdRoom())){
            return REPO.save(
                new Reservation(0, r.getIdRoom(), c.getIdClient(), in, out)
                ) != null;
        }
        else    System.out.println("Periodo no disponible!");
        return false;
    }

    public Iterable<ReservationForm> getAllReservations() {
        Iterable<Reservation> a = REPO.findAll();
        ArrayList<ReservationForm> form = new ArrayList<ReservationForm>();
        for (Reservation r : a){
            ReservationForm thisForm = new ReservationForm();
            thisForm.setClientDNI(CLIENTREPO.findById(r.getIdClient()).getDni());
            thisForm.setRoomCode(ROOMREPO.findById(r.getIdRoom()).get().getCode());
            thisForm.setInDate(r.getInDate().toString());
            thisForm.setOutDate(r.getOutDate().toString());
            form.add(thisForm);
        }
        return form;
    }

    public Reservation getReservation(String id) {
        return REPO.findById(Integer.valueOf(id)).get();
    }

    public boolean delReservation(int id) {
        return REPO.deleteById(id);
    }
}
