package com.mright.spring.framework.beans.factory;

import com.mright.spring.framework.beans.BeansException;

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
