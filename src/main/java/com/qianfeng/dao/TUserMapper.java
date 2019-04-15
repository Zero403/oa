package com.qianfeng.dao;

import com.qianfeng.entity.TUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    @Select("SELECT r.info from t_user u INNER JOIN t_userrole ur ON u.id = ur.uid INNER JOIN t_role r ON r.id = ur.rid WHERE u.id = \n" +
            "(SELECT id from t_user where no = #{name})")
    List<String> findRoleByName(String name);

    @Select("SELECT DISTINCT a.title from t_user u INNER JOIN t_userrole ur ON u.id = ur.uid \n" +
            "INNER JOIN t_role r ON r.id = ur.rid \n" +
            "INNER JOIN t_roleauthority ar on r.id = ar.rid  \n" +
            "INNER JOIN t_authority a on a.id = ar.aid  \n" +
            "WHERE u.id = (SELECT id from t_user where no = #{name})")
    List<String> findPermisionByName(String name);

    @Select("SELECT * from t_user WHERE no = #{name}")
    TUser findPwdByName(String name);
}