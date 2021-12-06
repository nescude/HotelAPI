package com.nescude.hotelfront.model.reservation;

import javax.annotation.PostConstruct;

import com.nescude.hotelfront.model.inputs.ReservationForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservationConsumer {
    
    @Value("${backend.host}")
    private String host;

    @Autowired
    RestTemplate rt;

    @PostConstruct
    private void pc(){host+="/reservation";}

    public Iterable<ReservationForm> getAllReservations() {
        String url = this.host + "/all";
        Iterable<ReservationForm> result = rt.getForObject(url, Iterable.class);
        return result;
    }

    public Reservation getReservation(int id) {
        String url = this.host + "/" + id;
        Reservation r = rt.getForObject(url, Reservation.class);
        return r;
    }

    public Boolean delReservation(int id) {
        String url = this.host + "/del/" + id;
        Boolean result = rt.getForObject(url, Boolean.class);
        return result;
    }

    public Boolean addReservation(ReservationForm reservation) {
        String url = this.host + "/add";
        Boolean result = rt.postForObject(url, reservation, Boolean.class);
        return result;
    }

    // public Iterable<Client> getAllAvailableRooms() {
    //     String url = host + "/client/all";
    //     Iterable<Client> Iterable = rt.getForObject(url, Iterable.class);
    //     return Iterable;
    // }
}
