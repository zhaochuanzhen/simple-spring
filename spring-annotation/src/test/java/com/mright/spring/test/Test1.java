package com.mright.spring.test;

import com.mright.spring.bean.Person;
import com.mright.spring.configuration.ApplicationConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Person mac = (Person) context.getBean("windows");
        if (mac != null) {
            System.out.println(mac.getName());
        }

        /*Person linux = (Person) context.getBean("linux");
        if (linux != null) {
            System.out.println(linux.getName());
        }*/

    }
}
