package com.qianfeng.dao;

import com.qianfeng.entity.TGrade;
import com.qianfeng.entity.TSchedule;
import com.qianfeng.entity.TStudent;
import com.qianfeng.vo.VStu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TStudentMapper {
    int deleteByPrimaryKey(String no);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    TStudent selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);

    List<VStu> findAll(@Param("page") int page, @Param("limit") int limit);

    int selectById(String no);

    @Select("select * from t_staff ")
    List<TSchedule> findAlls();

    @Select("select * from t_grade")
    List<TGrade> find();
}