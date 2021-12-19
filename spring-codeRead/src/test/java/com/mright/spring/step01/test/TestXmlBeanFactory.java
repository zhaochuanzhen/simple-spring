package com.mright.spring.step01.test;

import com.mright.spring.step01.bean.UserService;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestXmlBeanFactory {

    @Test
    public void test01() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring.xml");
//        ClassPathResource resource = new ClassPathResource("spring.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        final int i = reader.loadBeanDefinitions(resource);
//        System.out.println(i);

        final UserService userService = context.getBean(UserService.class);
        userService.sayHello();
    }
}
