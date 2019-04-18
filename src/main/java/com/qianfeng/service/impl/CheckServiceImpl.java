package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.TCheckMapper;
import com.qianfeng.entity.TCheck;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.CheckService;
import com.qianfeng.utils.PageListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CheckServiceImpl implements CheckService {

    @Resource
    private TCheckMapper checkDao;
    @Override
    public Map<String, Object> checkList(Integer page, Integer limit, String no) {
        PageHelper.startPage(page, limit);
        List<TCheck> list = checkDao.selectByUserNo(no);
        Map<String, Object> map = PageListUtil.mapList(list);
        return map;
    }

    @Override
    public void delCheck(int id) {
        checkDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<TUser> allDeat() {
        return checkDao.allDepar();
    }

    @Override
    public void addProcess(TCheck check) {
        checkDao.insertSelective(check);
    }
}
