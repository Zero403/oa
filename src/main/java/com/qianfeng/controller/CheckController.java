package com.qianfeng.controller;

import com.qianfeng.common.CommonInfo;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.TCheck;
import com.qianfeng.entity.TUser;
import com.qianfeng.service.CheckService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/check")
public class CheckController {

    @Autowired
    private CheckService checkService;

    @RequestMapping("/processlist.do")
    public JsonBean checkList(Integer page, Integer limit, HttpSession session){
        TUser user = (TUser) session.getAttribute(CommonInfo.LOGIN_USER);
        Map<String, Object> map = checkService.checkList(page, limit, user.getNo());

        return JsonUtils.createJsonBean(0, Integer.parseInt(map.get("total").toString()), map.get("rows"));
    }

    @RequestMapping("/processdel.do")
    public JsonBean delCheck(Integer id){
        checkService.delCheck(id);
        return JsonUtils.createJsonBean(1000,1, null);
    }

    @RequestMapping("/departall.do")
    public List<TUser> depatrAll(){

        return checkService.allDeat();
    }

    @RequestMapping("/processadd.do")
    public void processAdd(TCheck check, HttpServletResponse response, HttpSession session) throws IOException {
        TUser user = (TUser) session.getAttribute(CommonInfo.LOGIN_USER);
        check.setFlag(1);
        check.setStartname(user.getName());
        check.setStartno(user.getNo());
        checkService.addProcess(check);
        response.sendRedirect("../processlist.html");
    }
}
