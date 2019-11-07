package com.example.demo.model;

import com.example.demo.enums.Router;
import com.example.demo.enums.WhereDidYouInformAboutUs;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data

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

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Application() {
    }

    public Application(String fio, String address, String phone, String email,
                       WhereDidYouInformAboutUs whereDidYouInformAboutUs,
                       Router router, LocalDateTime time, Client client) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

