package com.mright.spring.framework.beans.factory.support;

import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException(MessageFormat.format("bean is not found. beanName: {0}", beanName));
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        if (beanDefinitionMap.get(beanName) != null) {
            throw new BeansException(MessageFormat.format("bean has exit, do not add container. beanName: {0}", beanName));
        }
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
