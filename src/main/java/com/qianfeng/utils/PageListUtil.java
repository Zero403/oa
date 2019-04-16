package com.qianfeng.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

public class PageListUtil {
	
	public static <E> Map<String, Object> mapList(List<E> list) {
		
		long total = ((Page)list).getTotal();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("total", total);
		map.put("rows", list);
		
		return map;
	}
}
