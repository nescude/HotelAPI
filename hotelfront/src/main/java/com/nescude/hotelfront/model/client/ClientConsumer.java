package com.nescude.hotelfront.model.client;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientConsumer {
    
    @Value("${backend.host}")
    private String host;

    @Autowired
    RestTemplate rt;

    @PostConstruct
    private void pc(){host+="/client";}

    public List<Client> getAllClients() {
        String url = host + "/all";
        List<Client> list = rt.getForObject(url, List.class);
        return list;
    }

    public Client getClient(String dni) {
        String url = host + "/" +dni;
        Client c = rt.getForObject(url, Client.class);
        return c;
    }

    public Boolean addClient(Client client) {
        String url = host + "/add";
        Boolean result = rt.postForObject(url, client, Boolean.class);
        return result;
    }

    public Boolean delClient(String dni) {
        String url = host + "/del/"+dni;
        Boolean result = rt.getForObject(url, Boolean.class);
        return result;
    }
    
}
