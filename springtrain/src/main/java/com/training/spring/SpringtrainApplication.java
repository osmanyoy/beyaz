package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringtrainApplication {

    @Autowired
    @Qualifier("createPerson")
    private Person person;

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringtrainApplication.class,
                                                                       args);

        SpringtrainApplication bean = context.getBean(SpringtrainApplication.class);
        bean.person.getName();

        // SpringtrainApplication application = new SpringtrainApplication();
        // application.person.getName();
    }
}
