package com.mright.spring.framework.common;

import com.mright.spring.framework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class IndexServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
