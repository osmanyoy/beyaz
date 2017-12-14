package com.training.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class STConfiguration {

    private MyObject mob;

    @Autowired
    public STConfiguration(final MyObject mob) {
        System.out.println("STConfiguration construct");
        this.mob = mob;
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @Bean
    // @Primary
    // @Scope("prototype")
    public Person createPerson() {
        System.out.println("createPerson");
        Person person = new Person();
        person.setName("osman");
        person.setSurname("yay");
        return person;
    }

    @Autowired
    public void runMeOnce(@Qualifier("person") final Person person) {
        System.err.println("Person : " + person);
    }

    @Autowired
    public void runMeOnce2() {
        System.err.println("Create Person : " + this.createPerson());
    }

}
