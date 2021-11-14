package com.mright.spring.test;

import com.mright.spring.configuration.ApplicationConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest1 {

    @Test
    public void iocTest1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        System.out.println("容器创建完成");
        context.close();
    }
}
