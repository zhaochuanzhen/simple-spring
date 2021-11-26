package com.mright.spring.framework.test;

import com.mright.spring.framework.core.io.DefaultResourceLoader;
import com.mright.spring.framework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

public class Test05 {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_class_path() {
        Resource resource = resourceLoader.getResource("");
    }
}
