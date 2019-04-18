package com.qianfeng.dao;

import com.qianfeng.entity.TCourse;
import com.qianfeng.entity.TGrade;
import com.qianfeng.vo.VGrade;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TGradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TGrade record);

    int insertSelective(TGrade record);

    TGrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TGrade record);

    int updateByPrimaryKey(TGrade record);

    @Select("SELECT count(s.gid) count, g.*,c.`name` cname FROM t_student s right JOIN t_grade g ON s.gid = g.id INNER JOIN t_course c ON g.cid = c.id WHERE g.flag = 1 GROUP BY g.id")
    List<VGrade> greadeList();

    @Select("SELECT count(1) FROM t_student WHERE gid = #{id}")
    int countStudentByGid(int id);

    @Select("SELECT * FROM t_course")
    List<TCourse> allCourse();
}