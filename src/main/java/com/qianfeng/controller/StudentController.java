package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TCourse;
import com.qianfeng.entity.TGrade;
import com.qianfeng.entity.TSchedule;
import com.qianfeng.entity.TStudent;
import com.qianfeng.service.StudentService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VStu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("studentpage.do")
    public JsonBean findAllStu(int page, int limit){
        List<VStu> list = studentService.findStudent(page - 1, limit);

        return JsonUtils.createJsonBean(0,list.size(),list);

    }
    @RequestMapping("studentadd.do")
    public void addStu(TStudent student, HttpServletRequest request, HttpServletResponse response) throws  Exception{

        student.setFlag(1);

        studentService.addStu(student);

        response.sendRedirect(request.getContextPath() + "/studentlist.html");
    }

    @RequestMapping("studentdelete.do")
    public JsonBean deleteStu(String no) {
        studentService.deleteStuById(no);
        return JsonUtils.createJsonBean(1000,1,null);
    }


//    @RequestMapping("staffall.do")
//    public JsonBean findAll() {
//        List<TSchedule> list = studentService.findName();
//        return JsonUtils.createJsonBean(0, list.size(), list);
//    }
//
//    @RequestMapping("gradeall.do")
//    public JsonBean find() {
//        List<TGrade> list = studentService.findAll();
//        return JsonUtils.createJsonBean(0, list.size(), list);
//    }
}
