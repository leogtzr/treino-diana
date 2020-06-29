package com.training.interfaces;

public class InterfaceApp {
    public static void main(final String[] args) {
        
    }
}

interface Flyer {
    void fly();
}

class Superman implements Flyer {
    @Override
    public void fly() {
        System.out.println("Vuelo como Superman ...");
    }
}

class Dron implements Flyer {
    @Override
    public void fly() {
        System.out.println("Vuelo como un Dron ... ");
    }
}

interface Volador {
    
}

interface A {
    
}

interface B {
    
}

interface C extends A, B {
    
}

class D implements C {
    
}

