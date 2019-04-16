package com.qianfeng.dao;

import com.qianfeng.entity.TAuthority;
import com.qianfeng.entity.TRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

    List<TRole> findAllRole(@Param("no") String no, @Param("flag") int flag);

    @Select("SELECT a.* from t_roleauthority ar INNER JOIN t_authority a on ar.aid = a.id INNER JOIN t_role r on ar.rid = r.id where r.id = #{id}")
    List<TAuthority> findAuthorityByRoleId(int id);


    @Select("SELECT count(1) FROM t_userrole WHERE rid = #{rid}")
    int findRoleInUserRole(int rid);
}