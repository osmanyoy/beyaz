package com.training.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// @Component
public class BeanTest implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(final Object arg0,
                                                 final String arg1) throws BeansException {
        System.out.println("Bean after init : " + arg1);
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(final Object arg0,
                                                  final String arg1) throws BeansException {
        System.out.println("Bean before init : " + arg1);
        return arg0;
    }

}
