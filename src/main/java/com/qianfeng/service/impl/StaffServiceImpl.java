package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.TStaffMapper;
import com.qianfeng.entity.TDepart;
import com.qianfeng.entity.TStaff;
import com.qianfeng.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {


    @Autowired
    private TStaffMapper tStaffMapper;


    @Override
    public void addStaff(TStaff tStaff) {
        tStaffMapper.insert(tStaff);
    }

    @Override
    public List<TStaff> findAll() {
        List<TStaff> list = null;
        try {
            list = tStaffMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delStaff(String no) {
        try {
            tStaffMapper.delStaff(no);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStaff(TStaff staff) {
        try {
            tStaffMapper.updateStaff(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TDepart> findAllDepart() {
        List<TDepart> bean;
            bean = tStaffMapper.findAlldep();

        return bean;
    }

    @Override
    public void addTstaffBatch(List<TStaff> list) {
        //每一百条数据，进行一次批量操作
        int count = 1;
        List<TStaff> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tempList.add(list.get(i));
            if(count % 100 != 0) {
                count++;
            }else {
                tStaffMapper.addBatch(tempList);
                tempList.clear();
                count = 1;
            }
        }
        if(tempList.size() != 0){
            tStaffMapper.addBatch(tempList);
        }
    }
}
