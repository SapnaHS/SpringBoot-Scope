package com.java.utilities.demo.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class CustomThreadScope implements Scope {

    CustomThreadLocal customThreadLocal = new CustomThreadLocal();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("Fetched object from scope");
        Map<String, Object> scope = (Map<String, Object>) customThreadLocal.get();
        Object obj = scope.get(name);
        if(obj == null) {
            obj = objectFactory.getObject();
            scope.put(name, obj);
        }
        return obj;
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> scope = (Map<String, Object>) customThreadLocal.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

    class CustomThreadLocal extends ThreadLocal {
        protected Map<String, Object> initialValue() {
            System.out.println("Initialing ThreadLocal");
            return new HashMap<String, Object>();
        }
    }
}
