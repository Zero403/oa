package com.qianfeng.service;

import com.qianfeng.entity.TDepart;

import java.util.List;
import java.util.Map;

public interface TDepartService {
    //增加部门的名称和成立时间
    public void addTDpart(TDepart tDepart);
    //展示部门，并修改
    public void updateTDpart(TDepart tDepart);
    //删除部分信息
    public void deleteTDpartById(Integer id);

    public List<TDepart> findByPage(int page);
}
