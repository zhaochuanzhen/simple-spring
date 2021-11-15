package com.mright.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Book {

    public Book() {
        System.out.println("Book constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Book init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Book destroy method");
    }
}
