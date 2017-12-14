package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.training.spring.aop.Called;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringtrainApplication {

    @Autowired
    private Called cll;

    @Autowired
    @Qualifier("createPerson")
    private Person person;

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringtrainApplication.class,
                                                                       args);

        SpringtrainApplication bean = context.getBean(SpringtrainApplication.class);
        bean.person.getName();

        String hello = bean.cll.hello("osman");

        System.out.println("Hello result : " + hello);

        // SpringtrainApplication application = new SpringtrainApplication();
        // application.person.getName();
    }
}
