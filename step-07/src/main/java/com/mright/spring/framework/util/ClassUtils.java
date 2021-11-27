package com.mright.spring.framework.util;

public class ClassUtils {

    /**
     * 获取类加载器
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassUtils.class.getClassLoader();
        }
        return contextClassLoader;
    }
}
