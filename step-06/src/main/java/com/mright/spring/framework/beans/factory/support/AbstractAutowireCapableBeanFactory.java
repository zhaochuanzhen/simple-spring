package com.mright.spring.framework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.PropertyValue;
import com.mright.spring.framework.beans.PropertyValues;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;
import com.mright.spring.framework.beans.factory.config.BeanReference;

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
            Object beanInstance = createBeanInstance(beanDefinition, beanName, args);
            // 属性填充
            applyPropertyValues(beanName, beanInstance, beanDefinition);
            addSingleton(beanName, beanInstance);
            return beanInstance;
        } catch (Exception e) {
            throw new BeansException(MessageFormat.format("实例化Bean失败. beanName:{0}", beanName));
        }
    }

    protected void applyPropertyValues(String beanName, Object beanInstance, BeanDefinition beanDefinition){
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        if (propertyValues == null) {
            return;
        }
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                // 如果value是一个bean的引用，此处需要递归处理，获取所有bean
                value = getBean(((BeanReference) value).getBeanName());
            }
            // 属性直接填充
            BeanUtil.setProperty(beanInstance, name, value);
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
