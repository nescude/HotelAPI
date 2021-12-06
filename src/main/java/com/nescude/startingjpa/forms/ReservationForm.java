package com.nescude.startingjpa.forms;

import lombok.Data;

@Data
public class ReservationForm {

    private String roomCode;
    private int clientDNI;
    private String inDate;
    private String outDate;
    
}
