package com.training.spring;

import org.springframework.stereotype.Component;

@Component
public class MyObject {
    private String teString;

    public MyObject() {
        System.out.println("MyObject construct");

    }

    public String getTeString() {
        return this.teString;
    }

    public void setTeString(final String teString) {
        this.teString = teString;
    }

}
