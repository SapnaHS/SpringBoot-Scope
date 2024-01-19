package com.java.utilities.demo.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SingletonScopedBean {

    /*@Autowired
    private PrototypeScopedBean prototypeScopedBean;*/

    /*@Autowired
    ApplicationContext applicationContext;*/

   /* @Autowired
    private ObjectFactory<PrototypeScopedBean> prototypeScopedBeanObjectFactory;*/

    public PrototypeScopedBean getPrototypeScopedBean() {
        return getInstance();
        //return prototypeScopedBeanObjectFactory.getObject();
        //return applicationContext.getBean(PrototypeScopedBean.class);
    }

    @Lookup
    public PrototypeScopedBean getInstance() {
        return null;
    }

    public SingletonScopedBean() {
        System.out.println("SingletonScopedBean() instance created");
    }


}
