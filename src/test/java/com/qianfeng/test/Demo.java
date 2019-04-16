package com.qianfeng.test;

import com.qianfeng.service.TDepartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Demo extends BaseTest{

    @Autowired
    private TDepartService ser;

    @Test
    public void add() {
        ser.findByPage(1);
    }
}
