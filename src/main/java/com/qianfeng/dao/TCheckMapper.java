package com.qianfeng.dao;

import com.qianfeng.entity.TCheck;
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
}