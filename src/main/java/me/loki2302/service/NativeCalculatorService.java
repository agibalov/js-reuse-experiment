package me.loki2302.service;

public class NativeCalculatorService implements CalculatorService {
    @Override
    public int addNumbers(int a, int b) {
        return a + b;
    }	    
}