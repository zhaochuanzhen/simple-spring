package com.mright.spring.framework.common;

import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.factory.ConfigurableListableBeanFactory;
import com.mright.spring.framework.beans.factory.config.BeanFactoryPostProcessor;

public class MyPostFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyPostFactoryPostProcessor.postProcessBeanFactory. ");
    }
}
