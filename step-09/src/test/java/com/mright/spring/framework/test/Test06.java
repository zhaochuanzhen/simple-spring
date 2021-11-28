package com.mright.spring.framework.test;

import com.mright.spring.framework.bean.IndexService;
import com.mright.spring.framework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class Test06 {

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        // 2. 获取Bean对象调用方法
        IndexService indexService = applicationContext.getBean("indexService", IndexService.class);
        String result = indexService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
