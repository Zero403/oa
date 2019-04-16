package com.qianfeng.dao;

import com.qianfeng.entity.TAuthority;
import com.qianfeng.vo.VMenu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TAuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TAuthority record);

    int insertSelective(TAuthority record);

    TAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAuthority record);

    int updateByPrimaryKey(TAuthority record);

    List<VMenu> findMenuByUserId(int userId);

    @Select("SELECT * FROM t_authority")
    List<TAuthority> findAllAuthority();

    @Select("SELECT * FROM t_authority WHERE parentId = 0")
    List<TAuthority> findParentAuthority();

    @Select("SELECT count(1) FROM t_roleauthority WHERE aid = #{id}")
    int findFromRoleAuthority(int id);
}