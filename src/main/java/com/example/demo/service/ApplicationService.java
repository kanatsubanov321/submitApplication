package com.example.demo.service;

import com.example.demo.model.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> findAllApplications();

    Application findApplicationById(Long id);

    Application saveApplication(Application app);

    void updateApplication(Application app);

    void deleteApplicationById(Long id);

    void deleteAllApplications();
}
