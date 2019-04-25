package com.example.demo.utils;

public class Confirmation {
    int confirmationCode;

    public Confirmation(int confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public Confirmation() {
    }


    public int getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(int confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
