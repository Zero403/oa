package com.qianfeng.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TDepart;
import com.qianfeng.entity.TSchedule;
import com.qianfeng.entity.TStaff;
import com.qianfeng.service.StaffService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;


    @RequestMapping("/addStaff.do")
    public JsonBean addStaff(TStaff tStaff) {
        JsonBean bean = null;
        try {
            staffService.addStaff(tStaff);
            bean = JsonUtils.createJsonBean(1000, 10, null);
        } catch (Exception e) {
            bean = JsonUtils.createJsonBean(0, 10, e.getMessage());
        }
        return bean;
    }

    @RequestMapping("/staffList.do")
    public Map<String, Object> courseList(Integer page) {

        PageHelper.startPage(page, 5);
        Map<String, Object> map = new HashMap<>();

        try {
            List<TStaff> list = staffService.findAll();
            long total = ((Page) list).getTotal();
            map.put("code", 0); // 0 表示成功
            map.put("msg", "");
            map.put("count", total);
            map.put("data", list);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        }

    }

    @RequestMapping("/staffdelete.do")
    public JsonBean delStaff(String no){
        staffService.delStaff(no);
        return JsonUtils.createJsonBean(1000, 6, null);
    }


    @RequestMapping("/staffUpdate.do")
    public JsonBean updateStaff(TStaff staff) {
        try {
            staffService.updateStaff(staff);
            return JsonUtils.createJsonBean(1, 8, null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0, 8, e.getMessage());
        }
    }

    @RequestMapping("/findAllDept.do")
    public JsonBean findAll() {
        List<TDepart> bean;
        bean = staffService.findAllDepart();
        return JsonUtils.createJsonBean(0,bean.size(),bean);
    }

}
