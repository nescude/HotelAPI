package com.nescude.hotelfront.model.inputs;

import lombok.Data;

@Data
public class ReservationForm {

    private String roomCode;
    private int clientDNI;
    private String inDate;
    private String outDate;
    
}
