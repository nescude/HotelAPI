package com.nescude.hotelfront.controllers;

import com.nescude.hotelfront.model.client.Client;
import com.nescude.hotelfront.model.client.ClientConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientConsumer CONSUMER;

    @GetMapping("/")
    public String clientPage(Model modelo){
        Iterable<Client> list = CONSUMER.getAllClients();
        modelo.addAttribute("clients", list);
        modelo.addAttribute("client", new Client());
        return "clients";
    }

    @PostMapping("/add")
    public String addUser(Model modelo, @ModelAttribute Client client){
        if (CONSUMER.addClient(client)){
            modelo.addAttribute("msg", "Cliente creado correctamente");
            return "complete";
        }
        else
            return "error";
    }
}
