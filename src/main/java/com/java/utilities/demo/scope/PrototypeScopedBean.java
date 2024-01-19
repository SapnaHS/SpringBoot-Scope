package com.java.utilities.demo.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeScopedBean {

    public PrototypeScopedBean(){
        System.out.println("PrototypeScopedBean() instance created");
    }
}
