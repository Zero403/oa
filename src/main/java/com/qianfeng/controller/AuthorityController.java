package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/menu.do")
    public JsonBean findMenu(HttpSession session){

        TUser user = (TUser) session.getAttribute(CommonInfo.LOGIN_USER);
        List<VMenu> menu = authorityService.findMenu(user.getId());

        return JsonUtils.createJsonBean(1, 20, menu);
    }
}
