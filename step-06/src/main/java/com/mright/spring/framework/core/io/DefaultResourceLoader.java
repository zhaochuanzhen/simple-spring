package com.mright.spring.framework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASS_PATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASS_PATH_URL_PREFIX.length()));
        }
        try {
            URL url = new URL(location);
            return new UrlResource(url);
        } catch (MalformedURLException e) {
            return new FileSystemResource(location);
        }
    }
}
