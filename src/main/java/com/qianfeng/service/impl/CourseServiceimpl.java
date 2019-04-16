package com.qianfeng.service.impl;

import com.qianfeng.dao.TCourseMapper;
import com.qianfeng.entity.TCourse;
import com.qianfeng.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class CourseServiceimpl implements CourseService{
    /**
     *
     */
    @Autowired(required=false)
    private TCourseMapper tCourseMapper;

    @Override
    public void addCourse(TCourse tCourse) {
        TCourse course = tCourseMapper.findByName(tCourse.getName());

        if(course != null) {
            throw  new RuntimeException("存在相同课程，不能添加");

        }
        tCourseMapper.insertSelective(tCourse);


    }

    @Override
    public List<TCourse> findAllCourse() {
        List<TCourse> list = null;
        try {
            list = tCourseMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有课程异常");
        }
        return list;
    }

    @Override
    public void deleteCouById(Integer id) {
        if (id == null) {
            throw new RuntimeException("该课程不存在");
        }
        tCourseMapper.deleteByPrimaryKey(id);

    }

    @Override
    public TCourse findCourseByid(Integer id) {


        return tCourseMapper.findById(id);
    }

    @Override
    public void updateCou(TCourse tCourse) {
        if (tCourse == null) {
            throw new RuntimeException("该课程不存在");
        }
        tCourseMapper.updateByPrimaryKey(tCourse);

    }
}
