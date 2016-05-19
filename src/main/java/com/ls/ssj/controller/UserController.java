package com.ls.ssj.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ls.ssj.base.AppContext;
import com.ls.ssj.entity.User;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@RequestMapping(value="/list")
	@ResponseBody
	public User list(){
		
		String name = Thread.currentThread().getName();
		AppContext.clearThreadContext();
		User user = AppContext.getCurrentUser();
		user.setThreadName(name);
		
		return user;
	}
	
	@RequestMapping(value="/info")
	@ResponseBody
	public Map info(HttpSession session){
		User user = new User();
		user.setId(new Random().nextInt(10));
		user.setName(session.getId());
		session.setAttribute("user", user);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "德玛西亚");
		map.put("age", 11);
		
		return map;
	}
	
	@RequestMapping(value="/info2")
	@ResponseBody
	public String info2(){
		AppContext.clearThreadContext();
		return "this is a test string";
	}
	
	@RequestMapping(value="/info3")
	@ResponseBody
	public User info3(User user){
		
		return user;
	}
	
}


