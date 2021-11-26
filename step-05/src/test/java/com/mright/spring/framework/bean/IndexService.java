package com.mright.spring.framework.bean;

public class IndexService {

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
}
