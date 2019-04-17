package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TRole;
import com.qianfeng.service.RoleService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService service;

    @RequestMapping("/roleall.do")
    public JsonBean findAllRoles(String no, Integer flag){

        if (null == flag){
            flag = 1;
        }
        List<TRole> list = service.findAllRole(no, flag);
        return JsonUtils.createJsonBean(0, list.size(), list);
    }

    @RequestMapping("/userroleedit.do")
    public JsonBean updateRoleAuthority(int id, int[] authoritys){
        service.updateRoleAuthority(id, authoritys);
        return JsonUtils.createJsonBean(1000, 1, null);
    }

    @RequestMapping("/roledel.do")
    public JsonBean delRole(int id){
        service.delRole(id);
        return JsonUtils.createJsonBean(1000,1, null);
    }

}
