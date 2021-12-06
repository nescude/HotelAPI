package com.nescude.startingjpa.services;

import com.nescude.startingjpa.models.Client;
import com.nescude.startingjpa.repositories.IClientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    IClientRepo REPO;

    public boolean postClient(Client c){
        return REPO.save(c)!=null;
    }

    public Client getClientDetails(int dni){
        return REPO.findByDni(dni);
    }

    public boolean deleteClient(int dni){
        return REPO.deleteByDni(dni) != null;
    }

    public Iterable<Client> getAllClients(){
        return REPO.findAll();
    }
    
}
