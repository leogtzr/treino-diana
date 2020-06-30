package com.training.codetoabstractions;

import java.util.List;

public class CodeToAbstractionsApp {
    public static void main(final String[] args) {
        
    }
    
    private static void printList1(final List<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
    
    private static void printList2(final ArrayList<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
    
}
