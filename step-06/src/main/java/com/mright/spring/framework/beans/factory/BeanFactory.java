package com.mright.spring.framework.beans.factory;

import com.mright.spring.framework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
