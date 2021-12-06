package com.nescude.startingjpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity
@AllArgsConstructor
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "idClient", nullable = false)
    private int idClient;
    String fullname, dateOfCreation;
    int dni;

    protected Client (){};

    public Client(String fullname,String dateOfCreation,int dni){
        this.fullname = fullname;
        this.dateOfCreation = dateOfCreation;
        this.dni = dni;
    }
}
