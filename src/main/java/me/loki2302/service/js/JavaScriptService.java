package me.loki2302.service.js;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class JavaScriptService {
    private final Scriptable serviceScriptable;

    public JavaScriptService(Scriptable serviceScriptable) {
        this.serviceScriptable = serviceScriptable;
    }

    public <T> T invoke(String functionName, Class<T> returningClass, Object... args) {
        Object result = ScriptableObject.callMethod(serviceScriptable, functionName, args);
        return (T) Context.jsToJava(result, returningClass);
    }
}