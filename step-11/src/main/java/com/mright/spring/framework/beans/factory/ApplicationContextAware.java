package com.mright.spring.framework.beans.factory;

import com.mright.spring.framework.context.ApplicationContext;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext);
}
