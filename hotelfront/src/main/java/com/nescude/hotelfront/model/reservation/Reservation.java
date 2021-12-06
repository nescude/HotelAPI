package com.nescude.hotelfront.model.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private int idReservation;
    private int idRoom;
    private int idClient;

    private String inDate;
    private String outDate;
    
}
