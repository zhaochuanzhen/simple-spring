package com.mright.spring.framework.beans.factory;

public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
