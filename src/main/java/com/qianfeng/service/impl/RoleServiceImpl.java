package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.TRoleMapper;
import com.qianfeng.dao.TRoleauthorityMapper;
import com.qianfeng.entity.TAuthority;
import com.qianfeng.entity.TRole;
import com.qianfeng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private TRoleMapper roleDao;

    @Override
    public List<TRole> findAllRole(String no, int flag) {

        List<TRole> list = roleDao.findAllRole(no, flag);
        return list;
    }

    @Override
    public List<TAuthority> findAuthorityByRoleId(int id) {
        return roleDao.findAuthorityByRoleId(id);
    }

    @Autowired
    private TRoleauthorityMapper tRoleauthorityMapper;
    @Override
    public void updateRoleAuthority(int rid, int[] aids) {
        tRoleauthorityMapper.deleteByRoleId(rid);

        tRoleauthorityMapper.insertByRidAid(rid, aids);
    }

    @Override
    public void delRole(int rid) {
        int roles = roleDao.findRoleInUserRole(rid);
        if (roles > 0){

            throw new RuntimeException("该角色下扔有用户，删除失败");
        }else {
            roleDao.deleteByPrimaryKey(rid);
        }
    }


}
