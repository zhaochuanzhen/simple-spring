package com.mright.spring.framework.beans.factory.support;

import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            addSingleton(beanName, bean);
            return bean;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("InstantiationException of bean faild", e);
        }
    }
}
