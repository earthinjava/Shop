package com.duan.utils;

import java.util.List;

import net.sf.json.JSONArray;

public class JsonUtil {
	public  static String	list2json(List list) {		
		JSONArray ja=JSONArray.fromObject(list);		
		return ja.toString();
	}
}
