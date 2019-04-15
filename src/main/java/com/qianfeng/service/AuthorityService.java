package com.qianfeng.service;

import com.qianfeng.vo.VMenu;

import java.util.List;

public interface AuthorityService {
    public List<VMenu> findMenu(int userId);
}
