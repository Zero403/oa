package com.qianfeng.vo;

import java.util.ArrayList;

public class VRole {
    private Integer id;

    private String info;

    private String name;

    private Integer parentid;

    private ArrayList<String> authoritys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public ArrayList<String> getAuthoritys() {
        return authoritys;
    }

    public void setAuthoritys(ArrayList<String> authoritys) {
        this.authoritys = authoritys;
    }
}
