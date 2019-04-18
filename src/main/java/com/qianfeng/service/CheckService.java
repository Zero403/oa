package com.qianfeng.service;


import com.qianfeng.entity.TCheck;
import com.qianfeng.entity.TUser;

import java.util.List;
import java.util.Map;

public interface CheckService {
    public Map<String, Object> checkList(Integer page, Integer limit,String no);

    public void delCheck(int id);

    public List<TUser> allDeat();

    public void addProcess(TCheck check);
}
