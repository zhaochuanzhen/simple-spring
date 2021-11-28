package com.mright.spring.framework.test;

import com.mright.spring.framework.aop.MethodMatcher;
import com.mright.spring.framework.aop.aspectj.AspectJExpressionPointcut;
import com.mright.spring.framework.aop.framework.ReflectiveMethodInvocation;
import com.mright.spring.framework.bean.IIndexService;
import com.mright.spring.framework.bean.IndexService;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test01 {

    @Test
    public void test_proxy_method() {

        // 目标对象(可以替换成任何的目标对象)
        Object targetObj = new IndexService();

        // AOP 代理
        IIndexService proxy = (IIndexService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* com.mright.spring.framework.bean.IIndexService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    // 方法拦截器
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin By AOP");
                            System.out.println("方法名称：" + invocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    // 反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });

        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);

    }
}
