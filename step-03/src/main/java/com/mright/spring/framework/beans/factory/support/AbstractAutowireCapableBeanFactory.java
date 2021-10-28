package com.mright.spring.framework.beans.factory.support;

import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantistionStrategy instantistionStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        try {
            Object object = beanDefinition.getBeanClass().newInstance();
            addSingleton(beanName, object);
            return object;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException(MessageFormat.format("实例化Bean失败. beanName:{0}", beanName));
        }
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        try {
            return createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException(MessageFormat.format("实例化Bean失败. beanName:{0}", beanName));
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return instantistionStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }
}
