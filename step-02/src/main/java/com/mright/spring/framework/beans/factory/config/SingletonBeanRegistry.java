package com.mright.spring.framework.beans.factory.config;

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
