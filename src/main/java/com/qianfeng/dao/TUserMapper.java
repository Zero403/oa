package com.qianfeng.dao;

import com.qianfeng.entity.TUser;
import com.qianfeng.vo.VUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
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


    @Select("SELECT * from t_user WHERE no = #{name} and flag = 1")
    TUser findUserByName(String name);
    @Select("SELECT password from t_user WHERE no = #{name} and flag = 1")
    String findPwdByName(String name);


    List<VUser> findAllUserWithRole(@Param("no") String no, @Param("flag") int flag, @Param("page") int page, @Param("limit") int limit);

    void updateUserRole(int id, int[] rids);

    @Delete("DELETE FROM t_userrole WHERE uid = #{uid}")
    void delUserFromUserRole(int uid);

    @Select("SELECT count(1) FROM t_user")
    int findUserCount();
}