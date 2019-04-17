package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.TAuthorityMapper;
import com.qianfeng.entity.TAuthority;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.utils.PageListUtil;
import com.qianfeng.vo.VMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AthorityServiceImpl implements AuthorityService {

    @Autowired
    private TAuthorityMapper tAuthorityMapper;

    @Override
    public List<VMenu> findMenu(int userId) {
        List<VMenu> menus = tAuthorityMapper.findMenuByUserId(userId);
        return menus;
    }

    @Override
    public List<TAuthority> allAuthority() {

        return tAuthorityMapper.findAllAuthority();
    }

    @Override
    public Map<String, Object> authorityList(int page, int limit) {

        PageHelper.startPage(page, limit);
        List<TAuthority> list = tAuthorityMapper.findAllAuthority();
        Map<String, Object> map = PageListUtil.mapList(list);
        return map;
    }

    @Override
    public List<TAuthority> parentAuthority() {
        return tAuthorityMapper.findParentAuthority();
    }

    @Override
    public void addAuthoity(TAuthority authority) {
        tAuthorityMapper.insertSelective(authority);
    }

    @Override
    public void delAuthority(int aid) {
        int count = tAuthorityMapper.findFromRoleAuthority(aid);
        if (count > 0){
            throw new RuntimeException("改权限仍有角色使用,删除失败");
        }

        tAuthorityMapper.deleteByPrimaryKey(aid);
    }


}
