package com.mright.spring.framework.context;

import com.mright.spring.framework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;
}
