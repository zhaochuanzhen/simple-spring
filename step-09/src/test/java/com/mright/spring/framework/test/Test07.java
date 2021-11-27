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

    @Test
    public void test_aware() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.registerShutdownHook();

        final IndexService indexService = context.getBean("indexService", IndexService.class);
        System.out.println(indexService.queryUserInfo());
        System.out.println("ApplicationContextAware：" + indexService.getApplicationContext());
        System.out.println("BeanFactoryAware：" + indexService.getBeanFactory());
    }

    @Test
    public void test_scope() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        IndexService userService01 = applicationContext.getBean("indexService", IndexService.class);
        IndexService userService02 = applicationContext.getBean("indexService", IndexService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
//        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }
}
