package com.qianfeng.service.impl;

import com.qianfeng.dao.TRoleMapper;
import com.qianfeng.entity.TAuthority;
import com.qianfeng.entity.TRole;
import com.qianfeng.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private TRoleMapper roleDao;

    @Override
    public List<TRole> findAllRole() {
        return roleDao.findAllRole();
    }

    @Override
    public List<TAuthority> findAuthorityByRoleId(int id) {
        return roleDao.findAuthorityByRoleId(id);
    }

}
