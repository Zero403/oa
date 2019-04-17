package com.qianfeng.service;

import com.qianfeng.entity.TAuthority;
import com.qianfeng.vo.VMenu;

import java.util.List;
import java.util.Map;

public interface AuthorityService {
    public List<VMenu> findMenu(int userId);

    public List<TAuthority> allAuthority();

    public Map<String, Object> authorityList(int page, int limit);

    public List<TAuthority> parentAuthority();

    public void addAuthoity(TAuthority authority);

    public void delAuthority(int aid);
}
