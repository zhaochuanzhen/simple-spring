package com.mright.spring.framework.test;

import com.mright.spring.framework.BeanDefinition;
import com.mright.spring.framework.BeanFactory;
import com.mright.spring.framework.bean.UserService;
import org.junit.Test;

public class TestRegister {

    @Test
    public void registerBean() {
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.sayHello();
    }
}
