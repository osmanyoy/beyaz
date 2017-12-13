package com.training.spring;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private String surname;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

}
