package com.ls.ssj.base;

import java.util.HashMap;
import java.util.Map;

import com.ls.ssj.entity.User;

public final class AppContext {

	private static ThreadLocal<Map<String, Object>> context = new ThreadLocal<Map<String, Object>>();
	
	public static void putThreadContext(String key, Object value){
		Map<String, Object> map = context.get();
		if(map == null){
			map = new HashMap<String, Object>();
			context.set(map);
		}
		map.put(key, value);
	}
	
	public static Object getThreadContext(String key){
		Map<String, Object> map = context.get();
		Object obj = null;
		if(map != null){
			obj = map.get(key);
		}
		return obj;
	}
	
	public static User getCurrentUser(){
		User user = (User) getThreadContext("user");
		return user;
	}
	
	public static void clearThreadContext(){
		context.remove();
		//context.set(null);
	}
}
