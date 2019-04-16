package com.qianfeng.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class VDpart {
    private Integer id;
    private String name;
    private Integer no;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

}
