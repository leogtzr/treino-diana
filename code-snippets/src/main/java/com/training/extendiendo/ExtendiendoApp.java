package com.training.extendiendo;

public class ExtendiendoApp {
    public static void main(final String[] args) {
        
    }
}

interface Device {}
interface Game {}

class Entertainment {}

abstract class Console extends Entertainment implements Device, Game {
    
}

abstract class Animal {
    public abstract void hacerRuido();
}

abstract class Mamifero {
    
    public void dormir() {
        System.out.println("zzzZZZzzZZZ");
    }
    
    public abstract void comer();
}

class Gato extends Animal {
    @Override
    public void hacerRuido() {
        System.out.println("Miauuuuu");
    }
}

abstract class Carro {
    public void correr() {
        // ...
    }
}