package com.mright.spring.framework.bean;

import java.util.HashMap;
import java.util.Map;

public class IndexDao {
    public IndexDao() {
        System.out.println("IndexDao 构造方法");
    }

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod(){
        System.out.println("IndexDao 初始化方法");
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public void destroyDataMethod(){
        System.out.println("IndexDao 销毁方法");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
