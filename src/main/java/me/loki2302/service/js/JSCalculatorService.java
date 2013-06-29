package me.loki2302.service.js;

import me.loki2302.service.CalculatorService;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class JSCalculatorService implements CalculatorService {
    @Inject
    @Named("calculatorJavaScriptService")
    private JavaScriptService javaScriptService;
    
    @Override
    public int addNumbers(int a, int b) {
        return javaScriptService.invoke("addNumbers", int.class, a, b);
    }
}