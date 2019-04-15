package com.qianfeng.dao;

import com.qianfeng.entity.TRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

    @Select("SELECT * FROM t_role")
    List<TRole> findAllRole();
}