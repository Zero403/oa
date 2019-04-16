package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TDepart;
import com.qianfeng.service.TDepartService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/TDpart")
@RestController
public class TDpartController {


    @Autowired
    private TDepartService tDepartService;

    JsonBean bean = null;

    @RequestMapping("/addTDpart.do")
    public JsonBean addTDpart(TDepart tDepart) {
        System.out.println(tDepart.getCreatetime());
        try {
            tDepartService.addTDpart(tDepart);
            bean = JsonUtils.createJsonBean(1, 3, null);
        } catch (Exception e) {
            bean = JsonUtils.createJsonBean(0, 3, e.getMessage());
        }
        return bean;
    }

    @RequestMapping("/update.do")
    public JsonBean updateTDpart(TDepart tDepart) {
        tDepartService.updateTDpart(tDepart);
        return JsonUtils.createJsonBean(1, 4, null);
    }

    @RequestMapping("/delete.do")
    public JsonBean deleteTDparteById(Integer id) {
        try {
            tDepartService.deleteTDpartById(id);
            return JsonUtils.createJsonBean(1000, 4, null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0, 4, e.getMessage());
        }
    }

    @RequestMapping("/list.do")
    public JsonBean findByPage(int page) {
        try {
            List<TDepart> map = tDepartService.findByPage(page);
            bean = JsonUtils.createJsonBean(0, 5, map);
        } catch (Exception e) {
            bean = JsonUtils.createJsonBean(1, 5, e.getMessage());
        }
        return  bean;
    }
}