package com.qianfeng.dao;

import com.qianfeng.entity.TAuthority;
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

    @Select("SELECT a.* from t_roleauthority ar INNER JOIN t_authority a on ar.aid = a.id INNER JOIN t_role r on ar.rid = r.id where r.id = #{id}")
    List<TAuthority> findAuthorityByRoleId(int id);
}