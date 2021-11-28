package com.mright.spring.framework.beans.factory.support;

import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantistionStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}
