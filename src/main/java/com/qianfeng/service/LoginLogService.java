package com.qianfeng.service;

import com.qianfeng.entity.TLoginlog;

import java.util.Map;

public interface LoginLogService {
    Map<String, Object> loginlogList(int page, int limit);

    void addLoginLog(TLoginlog loginlog);
}
