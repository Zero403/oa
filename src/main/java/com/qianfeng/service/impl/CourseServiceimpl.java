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
        TCourse tCourse1 = tCourseMapper.findByName(tCourse.getName());

        if(tCourse1 != null) {
            throw  new RuntimeException("存在相同课程，不能添加");

        }
        tCourseMapper.insert(tCourse);

    }

    @Override
    public List<TCourse> findAll() {
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

    }

    @Override
    public TCourse findCourse(Integer id) {

        return null;
    }

    @Override
    public void updateCou(TCourse tCourse) {

    }
}
