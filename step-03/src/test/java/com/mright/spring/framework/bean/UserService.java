package com.mright.spring.framework.bean;

public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public UserService() {
    }

    public void sayHello() {
        System.out.println("hello spring! from " + name);
    }
}
