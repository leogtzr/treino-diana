package com.training.anonymous;

public class AnonymousApp {
    public static void main(final String[] args) {
        Flyer flyer = new Flyer() {
            @Override
            public void fly() {
                System.out.println("I am flying!!!");
            }
        };
        
        
        new Flyer() {
            @Override
            public void fly() {
                System.out.println("Vuelo como un Dron!");
            }
        }.fly();
        
    }
}

interface Flyer {
    void fly();
}