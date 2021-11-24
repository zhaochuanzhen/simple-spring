package com.mright.spring.framework.test;

import com.mright.spring.framework.bean.UserDao;
import com.mright.spring.framework.bean.UserService;
import com.mright.spring.framework.beans.PropertyValue;
import com.mright.spring.framework.beans.PropertyValues;
import com.mright.spring.framework.beans.factory.config.BeanDefinition;
import com.mright.spring.framework.beans.factory.config.BeanReference;
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

    @Test
    public void test2() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        UserService userService = (UserService) beanFactory.getBean("userService", "zhaochuanzhen");

        userService.queryUserInfo();
    }
}
