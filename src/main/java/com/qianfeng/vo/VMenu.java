package com.qianfeng.vo;

import com.qianfeng.entity.TAuthority;

import java.util.List;

public class VMenu {
    private String pTitle;
    private List<TAuthority> list;

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public List<TAuthority> getList() {
        return list;
    }

    public void setList(List<TAuthority> list) {
        this.list = list;
    }
}
