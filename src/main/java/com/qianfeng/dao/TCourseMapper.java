package com.qianfeng.dao;

import com.qianfeng.entity.TCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCourse record);

    int insertSelective(TCourse record);

    TCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCourse record);

    int updateByPrimaryKey(TCourse record);

    public  TCourse  findByName(String name);

    public List<TCourse> findAll(@Param("page") int page, @Param("limit") int limit);

    public TCourse findById(Integer id);

}