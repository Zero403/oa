package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.common.Layui;
import com.qianfeng.entity.TCourse;
import com.qianfeng.service.CourseService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@ResponseBody
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/coursepage.do")

    public Layui FindAll(int page, int limit) {
        List<TCourse> list = courseService.findAllCourse(page - 1, limit);
//        Map<String,Object> map = new HashMap<>();
//        map.put("code", 0); // 0 表示成功
//        map.put("msg", "");
//        map.put("count", list.size());
//        map.put("data", list);
        return Layui.data(1, list);
    }

    @RequestMapping("/courseupdate.do")
    public void updateCourse(TCourse course, HttpServletResponse response, HttpServletRequest request) throws Exception {

        courseService.updateCou(course);
        response.sendRedirect(request.getContextPath() + "/courselist.html");
}

    @RequestMapping("/coursedelete.do")
    public Map<String, Object> deleteById(int id) {
        Map<String, Object> map = new HashMap<>();

        courseService.deleteCouById(id);
        map.put("code", 1000); // 0 表示成功
        map.put("msg", "");
        return map;
    }

    @RequestMapping("/courseadd.do")
    public void CourseAdd(TCourse course, HttpServletRequest request, HttpServletResponse response) throws  Exception{

       course.setFlag(1);

        courseService.addCourse(course);

        response.sendRedirect(request.getContextPath() + "/courselist.html");
    }


}
