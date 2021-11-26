package com.mright.spring.framework.bean;

public class IndexService {

    private String uId;

    private IndexDao indexDao;

    public String queryUserInfo() {
        return indexDao.queryUserName(uId);
    }
}
