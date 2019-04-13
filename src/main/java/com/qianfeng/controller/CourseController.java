package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TCourse;
import com.qianfeng.service.CourseService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/add.do")
    public JsonBean addCou(TCourse tCourse) {
        try {
            courseService.addCourse(tCourse);
            return JsonUtils.createJsonBean(1, 1,null);

        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,0,e.getMessage());
        }

    }
    @RequestMapping("/coursepage.do")
    public JsonBean listCou(Model model){
        List<TCourse> list = courseService.findAll();


        return JsonUtils.createJsonBean(1,1,list);
    }
}
