package com.mright.spring.framework;

public class BeanDefinition {

    private Object object;

    public BeanDefinition(Object object) {
        this.object = object;
    }

    public Object getBean() {
        return object;
    }
}
