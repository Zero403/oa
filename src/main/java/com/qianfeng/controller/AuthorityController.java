package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TAuthority;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/allAuthority.do")
    public JsonBean authoritys(){

        List<TAuthority> list = authorityService.allAuthority();
        return JsonUtils.createJsonBean(0, list.size(), list);
    }

    @RequestMapping("/authoritylist.do")
    public JsonBean authoritsys(Integer page, Integer limit){

        Map<String, Object> map = authorityService.authorityList(page, limit);

        return JsonUtils.createJsonBean(0, Integer.parseInt(map.get("total").toString()), map.get("rows"));
    }

    @RequestMapping("/authorityroot.do")
    public JsonBean parentAuthority(){
        List<TAuthority> list = authorityService.parentAuthority();
        return JsonUtils.createJsonBean(0, list.size(), list);
    }

    @RequestMapping("/authorityadd.do")
    public JsonBean authorityAdd(int pid, TAuthority authority){

        if (0 == pid){
            authority.setParentid(0);
        }
        authority.setType(1);
        authorityService.addAuthoity(authority);
        return JsonUtils.createJsonBean(1000, 1, null);
    }

    @RequestMapping("/coursedelete.do")
    public JsonBean delAuthority(int id){
        authorityService.delAuthority(id);
        return JsonUtils.createJsonBean(1000,1,null);
    }
}
