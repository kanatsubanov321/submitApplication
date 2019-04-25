package com.example.demo.controller;

import com.example.demo.model.Application;
import com.example.demo.model.Client;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.ClientService;
import com.example.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/app")
public class ApplicationController {
    @Autowired
    private ApplicationService appService;
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Application> getApplications() {
        return this.appService.findAllApplications();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return this.appService.findApplicationById(id);
    }

    @PostMapping("confirm")
    @ResponseStatus(HttpStatus.CREATED)
    public Response submitApplication(@RequestBody Application app) {
        this.appService.saveApplication(app);
        try {
            return new Response(true,
                    "Your application is accepted",
                    clientService.findClientById(app.getId()));
        } catch (Exception e) {
            return new Response(false, e.toString(), null);
        }
    }

    @PutMapping
    public void updateApplication(@RequestBody Application app) {
        this.appService.updateApplication(app);
    }

    @DeleteMapping("/{id}")
    public void deleteApplicationById(@PathVariable Long id) {
        this.appService.deleteApplicationById(id);
    }

    @DeleteMapping
    public void deleteAllApplications() {
        this.appService.deleteAllApplications();
    }

    @GetMapping("/{id}/client")
    private Client getClientByApp(@PathVariable Long id,
                                        @RequestHeader(name = "client-phone") String phone) {
        if (!clientService.checkClientPhone(id, phone)) {
            return null;
        }
        return clientService.findClientById(id);
    }
}
