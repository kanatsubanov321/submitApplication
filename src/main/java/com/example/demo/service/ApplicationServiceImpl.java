package com.example.demo.service;

import com.example.demo.model.Application;
import com.example.demo.model.Client;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private static Random r = new Random();
    private final ApplicationRepository app;
    private final ClientRepository client;
    private final ClientService clientService;
    private final ApplicationService applicationService;

    public ApplicationServiceImpl(ApplicationRepository app,
                                  ClientRepository client,
                                  ClientService clientService,
                                  ApplicationService applicationService) {
        this.app = app;
        this.client = client;
        this.clientService = clientService;
        this.applicationService = applicationService;
    }

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
        getApplication(application);
        return application;
    }

    private void getApplication(Application application) {
        Application app = applicationService.findApplicationById(application.getId());
        app.setTime(LocalDateTime.now());
        app.setClient(getClient(app));
        this.app.save(app);
    }

    private Client getClient(Application app) {
        Client client = new Client();
        this.client.save(client);
        client.setAddress(app.getAddress());
        client.setEmail(app.getEmail());
        client.setFio(app.getFio());
        client.setId(app.getId());
        client.setInActive(false);
        client.setPhone(app.getPhone());
        client.setPersonalAccount(r.nextInt(999999));
        this.client.save(client);
        return client;
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
}
