package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.TLoginlogMapper;
import com.qianfeng.entity.TLoginlog;
import com.qianfeng.service.LoginLogService;
import com.qianfeng.utils.PageListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private TLoginlogMapper loginDao;
    @Override
    public Map<String, Object> loginlogList(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<TLoginlog> list = loginDao.loginlogList();
        Map<String, Object> map = PageListUtil.mapList(list);
        return map;
    }

    @Override
    public void addLoginLog(TLoginlog loginlog) {
        loginDao.insertSelective(loginlog);
    }
}
