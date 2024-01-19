package com.java.utilities.demo;

import com.java.utilities.demo.dto.Volunteer;
import com.java.utilities.demo.scope.BeanScopeTestService;
import com.java.utilities.demo.scope.CustomThreadScope;
import com.java.utilities.demo.scope.SingletonScopedBean;
import org.springframework.beans.factory.config.Scope;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		/*BeanScopeTestService service1 = context.getBean(BeanScopeTestService.class);
		BeanScopeTestService service2 = context.getBean(BeanScopeTestService.class);
		BeanScopeTestService service3 = context.getBean(BeanScopeTestService.class);*/

		/*SingletonScopedBean singletonScopedBean = context.getBean(SingletonScopedBean.class);
		SingletonScopedBean singletonScopedBeanNew = context.getBean(SingletonScopedBean.class);
		System.out.println(singletonScopedBean.getPrototypeScopedBean().hashCode()+" - "+ singletonScopedBeanNew.getPrototypeScopedBean().hashCode());*/

		Scope scope = new CustomThreadScope();
		context.getBeanFactory().registerScope("CustomScope", scope);

		Runnable childThread = () -> {
			Volunteer volunteer = context.getBean(Volunteer.class);
			Volunteer volunteer2 = context.getBean(Volunteer.class);
			System.out.println("Hashcode of two object created by child thread " + volunteer.hashCode() + " & " + volunteer2.hashCode());
		};

		new Thread(childThread).start();

		Volunteer volunteer = context.getBean(Volunteer.class);
		Volunteer volunteer2 = context.getBean(Volunteer.class);
		System.out.println("Hashcode of two object created by main thread " + volunteer.hashCode() + " & " + volunteer2.hashCode());

	}

}
