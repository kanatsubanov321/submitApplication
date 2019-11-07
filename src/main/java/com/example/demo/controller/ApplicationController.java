package com.example.demo.controller;

import com.example.demo.model.Application;
import com.example.demo.model.Client;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.ClientService;
import com.example.demo.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/app")
public class ApplicationController {
    private final ApplicationService appService;

    private final ClientService clientService;

    public ApplicationController(ApplicationService appService,
                                 ClientService clientService) {
        this.appService = appService;
        this.clientService = clientService;
    }

    @GetMapping
    public List<Application> getApplications() {
        return this.appService.findAllApplications();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return this.appService.findApplicationById(id);
    }

    @PostMapping("/submit")
    @ResponseStatus(HttpStatus.CREATED)
    public Response submitApplication(@RequestBody Application app) {
        Application application = this.appService.saveApplication(app);
        try {
            if (checkClient(application)) {
                return new Response(true,
                        "Your application is accepted",
                        clientService.findClientById(app.getId()));
            } else {
                return new Response(false, "You have already submit application", null);
            }
        } catch (Exception e) {
            return new Response(false, e.toString(), null);
        }
    }

    private boolean checkClient(Application application) {
        List<Client> clients = clientService.findAllClients();
        for (Client client : clients) {
            if (!client.getFio().equals(application.getClient().getFio())) {
                return true;
            }
        }
        return false;
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

}
