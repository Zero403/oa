package com.qianfeng.service;

import com.qianfeng.entity.TDepart;
import com.qianfeng.entity.TStaff;

import java.util.List;

public interface StaffService {
    //增加数据
    public void addStaff(TStaff tStaff);

    //展示所有
    public List<TStaff> findAll();

    //删除
    public void delStaff(String on);

    //编辑
    public void updateStaff(TStaff staff);

    //增加部门信息
    public List<TDepart> findAllDepart();
}
