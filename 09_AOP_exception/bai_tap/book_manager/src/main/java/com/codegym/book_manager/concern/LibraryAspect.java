package com.codegym.book_manager.concern;

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
    private int view = 0;

    @Pointcut("execution(* com.codegym.book_manager.controller.CustomerCodeController.rentBook(..))")
    public void rentBook() {
    }

    @After("rentBook()")
    public void beforeController(JoinPoint joinPoint) {
        System.err.println("Book has been rented - method called : " + joinPoint.getSignature().getName() + " - at : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.book_manager.controller.CustomerCodeController.returnBook(..))")
    public void returnBook() {
    }

    @After("returnBook()")
    public void afterController(JoinPoint joinPoint) {
        System.err.println("Book has been returned - method called : " + joinPoint.getSignature().getName() + " - at : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.book_manager.controller.CustomerCodeController.*(..))")
    public void viewCount() {
    }

    @Before("viewCount()")
    public void count() {
        view += 1;
        System.err.println("Total views " + view );

    }
}
