package com.qianfeng.dao;

import com.qianfeng.entity.TAuthority;
import com.qianfeng.vo.VMenu;

public interface TAuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TAuthority record);

    int insertSelective(TAuthority record);

    TAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAuthority record);

    int updateByPrimaryKey(TAuthority record);

    VMenu findMenuByUserId(int userId);
}