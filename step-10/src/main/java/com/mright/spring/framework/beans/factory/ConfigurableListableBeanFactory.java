package com.mright.spring.framework.beans.factory;

import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.factory.config.AutowireCapableBeanFactory;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;
import com.mright.spring.framework.beans.factory.config.BeanPostProcessor;
import com.mright.spring.framework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
