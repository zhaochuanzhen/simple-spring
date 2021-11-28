package com.mright.spring.framework.context.support;

import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.factory.ApplicationContextAware;
import com.mright.spring.framework.beans.factory.config.BeanPostProcessor;
import com.mright.spring.framework.context.ApplicationContext;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
