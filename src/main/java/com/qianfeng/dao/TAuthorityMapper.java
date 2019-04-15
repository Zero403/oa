package com.qianfeng.dao;

import com.qianfeng.entity.TAuthority;
import com.qianfeng.vo.VMenu;

import java.util.List;

public interface TAuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TAuthority record);

    int insertSelective(TAuthority record);

    TAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAuthority record);

    int updateByPrimaryKey(TAuthority record);

    List<VMenu> findMenuByUserId(int userId);
}