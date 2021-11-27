package com.mright.spring.framework.bean;

import com.mright.spring.framework.beans.BeansException;
import com.mright.spring.framework.beans.factory.*;
import com.mright.spring.framework.context.ApplicationContext;

public class IndexService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
    public IndexService() {
        System.out.println("IndexService 构造方法");
    }

    private String uId;

    private IndexDao indexDao;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public String queryUserInfo() {
        return indexDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public IndexDao getIndexDao() {
        return indexDao;
    }

    public void setIndexDao(IndexDao indexDao) {
        this.indexDao = indexDao;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("IndexService 销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("IndexService 初始化方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

}
