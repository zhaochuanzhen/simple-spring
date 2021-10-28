package com.mright.spring.framework.beans.factory.support;

import com.mright.spring.framework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonBeanMap = new HashMap<>();

    public Object getSingleton(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    protected void addSingleton(String beanName, Object bean) {
        singletonBeanMap.put(beanName, bean);
    }
}
