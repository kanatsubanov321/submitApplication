package com.example.demo.Singleton;

public class President {

    private President() {
    }

    private static final President president = new President();

    public static President getInstance() {
        return president;
    }
}
     class Main1{
        public static void main(String[] args) {
            President president = President.getInstance();
            President president1 = President.getInstance();
    }
}
