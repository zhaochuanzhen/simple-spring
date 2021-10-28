package com.mright.spring.framework.test;

import com.mright.spring.framework.bean.UserService;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;
import com.mright.spring.framework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class TestRegister {

    @Test
    public void registerBean() {
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService beanService1 = (UserService) beanFactory.getBean("userService");
        beanService1.sayHello();

        System.out.println(beanFactory.getBean("userService"));
        System.out.println(beanFactory.getBean("userService"));
    }
}
