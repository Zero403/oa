package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.TDepartMapper;
import com.qianfeng.entity.TDepart;
import com.qianfeng.service.TDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TDpartServiceImpl implements TDepartService{

    @Autowired
    private TDepartMapper tdpartDao;

    @Override
    public void addTDpart(TDepart tDepart) {
            //添加部门
        tDepart.setFlag(1);
        tdpartDao.insertSelective(tDepart);
    }

    @Override
    public void updateTDpart(TDepart tDepart) {
        tdpartDao.updateByPrimaryKey(tDepart);
    }

    @Override
    public void deleteTDpartById(Integer id) {
        tdpartDao.deleteTDpart(id);
    }

    @Override
    public List<TDepart> findByPage(int page) {
        PageHelper.startPage(page, 10);
        List<TDepart> list = tdpartDao.findAllTDpart();


        return list;
    }
}
