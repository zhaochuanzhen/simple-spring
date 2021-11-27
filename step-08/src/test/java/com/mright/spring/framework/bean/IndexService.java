package com.mright.spring.framework.bean;

import com.mright.spring.framework.beans.factory.DisposableBean;
import com.mright.spring.framework.beans.factory.InitializingBean;

public class IndexService implements InitializingBean, DisposableBean {
    public IndexService() {
        System.out.println("IndexService 构造方法");
    }

    private String uId;

    private IndexDao indexDao;

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
}
