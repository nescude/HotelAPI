package com.nescude.startingjpa.repositories;

import com.nescude.startingjpa.models.Client;

import org.springframework.data.repository.CrudRepository;



public interface IClientRepo extends CrudRepository<Client, Integer>{
    

    public Client findById(int id);

    public Client findByDni(int dni);

    public Client deleteByDni(int dni);

    public Client findByFullname(String name);

}
