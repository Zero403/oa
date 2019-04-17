package com.qianfeng.service;


import java.util.Map;

public interface CheckService {
    public Map<String, Object> checkList(Integer page, Integer limit,String no);

    public void delCheck(int id);
}
