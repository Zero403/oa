package com.qianfeng.service;

import com.qianfeng.entity.TAuthority;
import com.qianfeng.entity.TRole;

import java.util.List;

public interface RoleService {
    public List<TRole> findAllRole(String no, int flag);

    public List<TAuthority> findAuthorityByRoleId(int id);

    public void updateRoleAuthority(int rid, int[] aids);

    public void delRole(int rid);
}
