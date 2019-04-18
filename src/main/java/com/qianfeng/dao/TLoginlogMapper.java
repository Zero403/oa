package com.qianfeng.dao;

import com.qianfeng.entity.TLoginlog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TLoginlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TLoginlog record);

    int insertSelective(TLoginlog record);

    TLoginlog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TLoginlog record);

    int updateByPrimaryKey(TLoginlog record);

    @Select("SELECT * FROM t_loginlog ORDER BY createtime DESC")
    List<TLoginlog> loginlogList();
}