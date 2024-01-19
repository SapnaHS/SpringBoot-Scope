package com.java.utilities.demo.processor;

import com.java.utilities.demo.dto.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof User user){
            if(!(isValidPassword(user.getPassword()))){
                throw new RuntimeException("Password is invalid");
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    private boolean isValidPassword(String password) {
        return password.length() > 8 && password.matches(".*[@#$%!].*");
    }
}
