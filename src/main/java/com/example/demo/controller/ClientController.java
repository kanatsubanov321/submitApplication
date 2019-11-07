package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClients() {
        return this.clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id,
                                @RequestHeader(name = "client-phone") String phone) {
        if (clientService.checkClientPhone(id, phone)) {
            return null;
        }
        return this.clientService.findClientById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client client) {
        return this.clientService.saveClient(client);
    }

    @PutMapping
    public void updateClient(@RequestBody Client client) {
        this.clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable Long id) {
        this.clientService.deleteClientById(id);
    }

    @DeleteMapping
    public void deleteAllClients() {
        this.clientService.deleteAllClients();
    }

}
