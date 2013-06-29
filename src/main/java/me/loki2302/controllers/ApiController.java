package me.loki2302.controllers;

import me.loki2302.service.AddNumbersResponse;
import me.loki2302.service.CalculatorService;
import ninja.Result;
import ninja.Results;
import ninja.params.Param;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class ApiController {    
    @Inject
    @Named("nativeCalculatorService")
    private CalculatorService nativeCalculatorService;
    
    @Inject
    @Named("jsCalculatorService")
    private CalculatorService jsCalculatorService;
    
    public Result addNumbersNative(
            @Param("a") int a,
            @Param("b") int b) {
        
        int result = nativeCalculatorService.addNumbers(a, b);
        
        AddNumbersResponse addNumbersResponse = new AddNumbersResponse();
        addNumbersResponse.a = a;
        addNumbersResponse.b = b;
        addNumbersResponse.result = result;
        
        return Results.json().render(addNumbersResponse);
    }
    
    public Result addNumbersJS(
            @Param("a") int a,
            @Param("b") int b) {
        
        int result = jsCalculatorService.addNumbers(a, b);
        
        AddNumbersResponse addNumbersResponse = new AddNumbersResponse();
        addNumbersResponse.a = a;
        addNumbersResponse.b = b;
        addNumbersResponse.result = result;
        
        return Results.json().render(addNumbersResponse);
    }
}