package com.java.utilities.demo.controller;

import com.java.utilities.demo.scope.RequestScopedBean;
import com.java.utilities.demo.scope.SessionScopedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    /*@Autowired
    private RequestScopedBean requestScopedBean;*/

    @Autowired
    private SessionScopedBean sessionScopedBean;

    @GetMapping("/message")
    public String getMessage(){
        //return requestScopedBean.getMessage();
        return sessionScopedBean.getMessage();
    }
}
