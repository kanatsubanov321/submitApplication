package com.example.demo.bootstrap;

import com.example.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsrapApplication implements CommandLineRunner {
    @Autowired
    private ApplicationService app;

    @Override
    public void run(String... args) throws Exception {
//        Application application = new Application("fio","address","222","email",
//                WhereDidYouInformAboutUs.FriendsTold, Router.IHaveOwnRouter,LocalDateTime.now());
//        app.saveApp(application);

    }
}
