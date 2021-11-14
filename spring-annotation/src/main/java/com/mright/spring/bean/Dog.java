package com.mright.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Dog implements InitializingBean, DisposableBean {

    public Dog() {
        System.out.println("Dog constructor");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Dog init afterPropertiesSet");
    }

    public void destroy() throws Exception {
        System.out.println("Dog destroy method");
    }
}
