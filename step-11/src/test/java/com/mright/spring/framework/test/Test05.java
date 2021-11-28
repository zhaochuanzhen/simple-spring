package com.mright.spring.framework.test;

import cn.hutool.core.io.IoUtil;
import com.mright.spring.framework.bean.IndexService;
import com.mright.spring.framework.beans.factory.support.DefaultListableBeanFactory;
import com.mright.spring.framework.beans.factory.xml.XmlBeanDefinitionReader;
import com.mright.spring.framework.core.io.DefaultResourceLoader;
import com.mright.spring.framework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test05 {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_class_path() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        final InputStream inputStream = resource.getInputStream();
        final String context = IoUtil.readUtf8(inputStream);
        System.out.println(context);
    }

    @Test
    public void test_file() throws IOException {
        final Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        final InputStream inputStream = resource.getInputStream();
        final String context = IoUtil.readUtf8(inputStream);
        System.out.println(context);
    }

    @Test
    public void text_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        final IndexService indexService = beanFactory.getBean("indexService", IndexService.class);
        final String str = indexService.queryUserInfo();
        System.out.println(str);
    }
}
