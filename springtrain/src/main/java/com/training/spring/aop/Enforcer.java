package com.training.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Enforcer {

    @Pointcut("execution(* com.training.spring.aop.Called.*(..)) ")
    public void xyz() {

    }

    @After("xyz() && args(str)")
    public void afterMethod(final JoinPoint joinPoint,
                            final String str) {

        System.out.println("after called  " + joinPoint.toShortString() + " parameter " + str);
    }

    @Before("xyz() && args(str)")
    public void beforeMethod(final JoinPoint joinPoint,
                             final String str) {
        System.out.println("before called  " + joinPoint.toShortString() + " parameter " + str);

    }

    @Around("xyz()")
    public Object around(final ProceedingJoinPoint joinPoint) {
        try {
            // Object[] args = joinPoint.getArgs();
            // args[0] = "Osman around";
            Object proceed = joinPoint.proceed();
            String string = (String) proceed;
            string += "Around called : " + string;
            return string;
        } catch (Throwable e) {
        }
        return null;
    }

    //
    // @AfterReturning(pointcut = "point() && args(str)",
    // returning = "retStr")
    // public void afterReturningMethod(final String str,
    // final String retStr) {
    // System.out.println("returning");
    //
    // }
    //
    // @AfterThrowing(pointcut = "point() && args(str)",
    // throwing = "exp")
    // public void afterThrowingMethod(final String str,
    // final Exception exp) {
    // System.out.println("throwing");
    //
    // }

}
