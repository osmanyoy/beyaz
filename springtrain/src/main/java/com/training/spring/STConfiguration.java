package com.training.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class STConfiguration {

    @Bean
    // @Primary
    @Scope("prototype")
    public Person createPerson() {
        Person person = new Person();
        person.setName("osman");
        person.setSurname("yay");
        return person;
    }

}
