package com.example.demo.model;

import com.example.demo.enums.Router;
import com.example.demo.enums.WhereDidYouInformAboutUs;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private String address;
    private String phone;
    private String email;
    private WhereDidYouInformAboutUs whereDidYouInformAboutUs;
    private Router router;
    private LocalDateTime time;

    public Application() {
    }

    public Application(String fio, String address, String phone,
                       String email, WhereDidYouInformAboutUs whereDidYouInformAboutUs, Router router, LocalDateTime time) {
        this.fio = fio;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.whereDidYouInformAboutUs = whereDidYouInformAboutUs;
        this.router = router;
        this.time = time;
    }

    public Application(Long id, String fio, String address, String phone, String email,
                       WhereDidYouInformAboutUs whereDidYouInformAboutUs, Router router, LocalDateTime time) {
        this.id = id;
        this.fio = fio;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.whereDidYouInformAboutUs = whereDidYouInformAboutUs;
        this.router = router;
        this.time = time;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public WhereDidYouInformAboutUs getWhereDidYouInformAboutUs() {
        return whereDidYouInformAboutUs;
    }

    public void setWhereDidYouInformAboutUs(WhereDidYouInformAboutUs whereDidYouInformAboutUs) {
        this.whereDidYouInformAboutUs = whereDidYouInformAboutUs;
    }
}

