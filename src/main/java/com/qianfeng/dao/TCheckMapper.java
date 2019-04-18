package com.qianfeng.dao;

import com.qianfeng.entity.TCheck;
import com.qianfeng.entity.TUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCheck record);

    int insertSelective(TCheck record);

    TCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCheck record);

    int updateByPrimaryKey(TCheck record);

    @Select("SELECT * FROM t_check WHERE startno = #{no}")
    List<TCheck> selectByUserNo(String no);

    @Select("SELECT DISTINCT u.* FROM t_user u INNER JOIN t_userrole ur ON u.id = ur.uid WHERE u.id != 1")
    List<TUser> allDepar();
}