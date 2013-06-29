package conf;

import java.io.IOException;

import me.loki2302.service.CalculatorService;
import me.loki2302.service.NativeCalculatorService;
import me.loki2302.service.js.JSCalculatorService;
import me.loki2302.service.js.JavaScriptContext;
import me.loki2302.service.js.JavaScriptService;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(CalculatorService.class)
            .annotatedWith(Names.named("nativeCalculatorService"))
            .to(NativeCalculatorService.class)
            .asEagerSingleton();
        
        bind(CalculatorService.class)
            .annotatedWith(Names.named("jsCalculatorService"))
            .to(JSCalculatorService.class)
            .asEagerSingleton();
    }
    
    @Provides
    @Named("calculatorJavaScriptService")
    public JavaScriptService provideJsCalculatorService() throws IOException {
        JavaScriptContext context = new JavaScriptContext();        
        context.extendWithResource("/assets/js/calculator-service.js");
        JavaScriptService javaScriptService = context.getService("calculatorService");
        return javaScriptService;
    }
}