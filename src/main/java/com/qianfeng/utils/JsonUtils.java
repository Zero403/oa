package com.qianfeng.utils;

import com.qianfeng.common.JsonBean;

public class JsonUtils {

	public static JsonBean createJsonBean(int code,int count, Object data){
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setCount(count);
		bean.setMsg("");
		bean.setData(data);
		
		return bean;
	}
}
