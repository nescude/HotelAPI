package com.nescude.hotelfront.model.client;

public class Client {
    private int id;
    String fullname, dateOfCreation;
    int dni;

    public Client(){};

    public String getDateOfCreation() {
        return dateOfCreation;
    }
    
    public int getDni() {
        return dni;
    }

    public String getFullname() {
        return fullname;
    }

    public int getId() {
        return id;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setId(int id) {
        this.id = id;
    }
}
