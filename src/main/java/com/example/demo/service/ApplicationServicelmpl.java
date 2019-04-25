package com.example.demo.service;

import com.example.demo.model.Application;
import com.example.demo.model.Client;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class ApplicationServicelmpl implements ApplicationService {
    private static Random r = new Random();
    @Autowired
    private ApplicationRepository app;
    @Autowired
    private ClientRepository client;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ApplicationService applicationService;

    @Override
    public List<Application> findAllApplications() {
        return app.findAll();
    }

    @Override
    public Application findApplicationById(Long id) {
        return app.findById(id).get();
    }

    @Override
    public Application saveApplication(Application app) {
        Application application = this.app.save(app);
        application.setTime(LocalDateTime.now());
        this.app.save(application);
        Client client = new Client();
        this.client.save(client);
        client.setAddress(application.getAddress());
        client.setEmail(application.getEmail());
        client.setFio(application.getFio());
        client.setId(application.getId());
        client.setInActive(false);
        client.setPhone(application.getPhone());
        client.setPersonalAccount(r.nextInt(999999));
        this.client.save(client);
        return application;
    }

    @Override
    public void updateApplication(Application app) {
        this.app.save(app);
    }

    @Override
    public void deleteApplicationById(Long id) {
        this.app.deleteById(id);
    }

    @Override
    public void deleteAllApplications() {
        this.app.deleteAll();
    }

    @Override
    public Client getClientByApp(Long id) {
        Client c = clientService.findClientById(id);
        Application app = findApplicationById(id);
        if (c.getId().equals(app.getId())) {
            return c;
        }
        return null;
    }
}
