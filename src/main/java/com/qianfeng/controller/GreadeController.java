package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TCourse;
import com.qianfeng.entity.TGrade;
import com.qianfeng.service.GradeService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grade")
public class GreadeController {

    @Resource
    private GradeService gradeService;

    @RequestMapping("/gradepage.do")
    public JsonBean gradeList(Integer page, Integer limit){
        Map<String, Object> map = gradeService.gradeList(page, limit);

        return JsonUtils.createJsonBean(0, Integer.parseInt(map.get("total").toString()), map.get("rows"));
    }




    @RequestMapping("/gradedelete.do")
    public JsonBean delGrade(Integer id){
        gradeService.deleteGrade(id);
        return JsonUtils.createJsonBean(1000, 1, null);
    }

    @RequestMapping("/gradeupdate.do")
    public void gradeUpdate(TGrade grade, HttpServletResponse response) throws IOException {

        gradeService.updateGrade(grade);
        response.sendRedirect("../gradelist.html");
    }

    @RequestMapping("/gradeadd.do")
    public void addGrade(TGrade grade, HttpServletResponse response) throws IOException {
        grade.setFlag(1);
        gradeService.addGrade(grade);
        response.sendRedirect("../gradelist.html");
    }

    @RequestMapping("/courseall.do")
    public List<TCourse> allCourse(){
        return gradeService.allCourse();
    }
}
