package com.mright.spring.framework.beans.factory.support;

import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.factory.BeanFactory;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    public Object getBean(String beanName) {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
