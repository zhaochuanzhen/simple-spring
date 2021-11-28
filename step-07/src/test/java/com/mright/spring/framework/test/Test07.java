package com.mright.spring.framework.test;

import com.mright.spring.framework.bean.IndexService;
import com.mright.spring.framework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class Test07 {

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.registerShutdownHook();

        final IndexService indexService = context.getBean("indexService", IndexService.class);
        System.out.println(indexService.queryUserInfo());
    }
}
