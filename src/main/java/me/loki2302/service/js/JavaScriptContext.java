package me.loki2302.service.js;

import java.io.IOException;
import java.net.URL;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class JavaScriptContext {
    private Context context;
    private Scriptable scope;

    public JavaScriptContext() {
        context = Context.enter();            
        scope = context.initStandardObjects();
    }

    public void stop() {
        Context.exit();
    }

    public void extendWithResource(String resourceName) throws IOException {
        URL resourceUrl = Resources.getResource(resourceName);
        String resourceContents = Resources.toString(resourceUrl, Charsets.UTF_8);
        context.evaluateString(scope, resourceContents, resourceName, 1, null);
    }

    public JavaScriptService getService(String serviceName) {
        Scriptable serviceScriptable = (Scriptable) scope.get(serviceName, scope);
        JavaScriptService javaScriptService = new JavaScriptService(serviceScriptable);
        return javaScriptService;
    }
}