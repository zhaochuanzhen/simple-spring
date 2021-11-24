package com.mright.spring.framework.core.io;

public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASS_PATH_URL_PREFIX)) {

        }
        return null;
    }
}
