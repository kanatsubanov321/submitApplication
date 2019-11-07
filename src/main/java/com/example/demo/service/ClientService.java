package com.example.demo.service;

import com.example.demo.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAllClients();

    Client findClientById(Long id);

    Client saveClient(Client client);

    void updateClient(Client client);

    void deleteClientById(Long id);

    void deleteAllClients();

    boolean checkClientPhone(Long id, String phone);
}
