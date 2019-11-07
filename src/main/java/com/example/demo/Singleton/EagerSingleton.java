package com.example.demo.Singleton;

public class EagerSingleton {
    private EagerSingleton() {
    }

    private static final EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return instance;
    }
}

class Main {
    public static void main(String[] args) {

    }
}

class LazyInnerSingleton {
    private LazyInnerSingleton() {


    }
}
