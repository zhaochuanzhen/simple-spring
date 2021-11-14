package com.mright.spring.bean;

public class Cat {

    public Cat() {
        System.out.println("Cat constructor");
    }

    public void init() {
        System.out.println("Cat init method");
    }

    public void destroy() {
        System.out.println("Cat destroy method");
    }
}
