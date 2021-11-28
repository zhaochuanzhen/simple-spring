package com.mright.spring.framework.test;

import com.mright.spring.framework.aop.aspectj.AspectJExpressionPointcut;
import com.mright.spring.framework.bean.IIndexService;
import com.mright.spring.framework.bean.IndexService;
import com.mright.spring.framework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.lang.reflect.Method;

public class Test02 {

    @Test
    public void test1() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* com.mright.spring.framework.bean.IndexService.*(..))");
        Class<IndexService> clazz = IndexService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IndexService userService = applicationContext.getBean("indexService", IndexService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
