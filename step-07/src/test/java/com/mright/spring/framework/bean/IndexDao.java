package com.mright.spring.framework.bean;

import java.util.HashMap;
import java.util.Map;

public class IndexDao {
    public IndexDao() {
        System.out.println("IndexDao 构造方法");
    }

    private static Map<String, String> hashMap = new HashMap<>();

    public void initMethod() {
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
