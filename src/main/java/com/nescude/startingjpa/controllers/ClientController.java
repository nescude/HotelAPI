package com.nescude.startingjpa.controllers;

import com.nescude.startingjpa.models.Client;
import com.nescude.startingjpa.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    ClientService service;

    @GetMapping("/{dni}")
    public Client getClientDetails(@PathVariable int dni){
        return service.getClientDetails(dni);
    }

    @PostMapping("/add")
    public boolean postClient(@RequestBody Client client){
        return service.postClient(client);
    }

    @DeleteMapping("/del/{dni}")
    public boolean deleteClient(@PathVariable int dni){
        return service.deleteClient(dni);
    }

    @GetMapping("/all")
    public Iterable<Client> getAllClients(){
        return service.getAllClients();
    }

}
