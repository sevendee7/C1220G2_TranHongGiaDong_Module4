package com.codegym.book_manager.concern;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LibraryAspect {
    private static int count = 0;

    @Pointcut("execution(* com.codegym.book_manager.controller.CustomerCodeController.borrowBook(..))")
    public void borrowBook() {
    }

    @After("borrowBook()")
    public void beforeController(JoinPoint joinPoint) {
        System.err.println("Book has been rented " + joinPoint.getSignature().getName() + " - at : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.book_manager.controller.CustomerCodeController.returnBook(..))")
    public void returnBook() {
    }

    @After("returnBook()")
    public void afterController(JoinPoint joinPoint) {
        System.err.println("Book has been returned" + joinPoint.getSignature().getName() + " - at : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.book_manager.controller.CustomerCodeController.*(..))")
    public void checkCountLog() {
    }

    @Before("checkCountLog()")
    public void count(JoinPoint joinPoint) {

        System.err.println("Total views " + ++count);

    }
}
