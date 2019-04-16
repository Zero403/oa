package com.qianfeng.service.impl;

import com.qianfeng.dao.TAuthorityMapper;
import com.qianfeng.entity.TAuthority;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.vo.VMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthorityServiceImpl implements AuthorityService {

    @Autowired
    private TAuthorityMapper tAuthorityMapper;

    @Override
    public List<VMenu> findMenu(int userId) {
        List<VMenu> menus = tAuthorityMapper.findMenuByUserId(userId);
        return menus;
    }
}
