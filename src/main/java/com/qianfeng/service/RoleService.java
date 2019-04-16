package com.qianfeng.service;

import com.qianfeng.entity.TAuthority;
import com.qianfeng.entity.TRole;

import java.util.List;

public interface RoleService {
    public List<TRole> findAllRole();

    public List<TAuthority> findAuthorityByRoleId(int id);
}
