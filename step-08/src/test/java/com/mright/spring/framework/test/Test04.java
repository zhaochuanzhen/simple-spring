package com.mright.spring.framework.test;

import com.mright.spring.framework.bean.UserService;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;
import com.mright.spring.framework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class Test04 {

    @Test
    public void test1() {
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService1 = (UserService) beanFactory.getBean("userService", "zhaochuanzhen");
        userService1.sayHello();

        UserService userService2 = (UserService) beanFactory.getBean("userService", "chenduxiu");
        userService2.sayHello();
    }

}
