package com.mright.spring.framework.beans.factory.support;

import com.mright.spring.framework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
