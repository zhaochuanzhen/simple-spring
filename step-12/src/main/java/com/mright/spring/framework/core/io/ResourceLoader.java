package com.mright.spring.framework.core.io;

public interface ResourceLoader {

    String CLASS_PATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
