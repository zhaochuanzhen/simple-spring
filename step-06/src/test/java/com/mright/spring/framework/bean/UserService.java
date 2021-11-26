package com.mright.spring.framework.bean;

public class UserService {

    private String name;

    private Integer age;

    private UserDao userDao;

    private String id;

    public UserService(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("hello " + name);
    }

    public void queryUserInfo() {
        System.out.println("查询到用户信息，id: " + id + ", 明细：" + userDao.queryUserName(id));
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public String getId() {
        return id;
    }
}
