package com.qianfeng.service.impl;

import com.qianfeng.dao.TStaffMapper;
import com.qianfeng.entity.TStaff;
import com.qianfeng.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void delStaff(String on) {
        try {
            tStaffMapper.delStaff(on);
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
}
