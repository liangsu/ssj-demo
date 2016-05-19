package com.ls.ssj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tracing.dtrace.ModuleAttributes;

/**
 * 用于测试线程安全
 * @author Administrator
 *
 */
@RestController
@RequestMapping("thread/")
public class ThreadController {

	private HttpServletRequest request;
	private int a = 0;
	private int b = 0;
	
	@RequestMapping("/test1")
	public int test1(int i, HttpServletRequest request){
		a = i;
		if(b % 2 == 0){
			b++;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
	
	@RequestMapping("/test2")
	public String test2(){
		if(b % 2 == 0){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b++;
		String i = request.getParameter("i");
		String tName = Thread.currentThread().getName();
		System.out.println(tName +" b:"+b+" i:");
		return tName +" b:"+b+" i:"+ i;
	}
	
	@ModelAttribute
	public void getRequest(HttpServletRequest request){
		this.request =  request;
	}
}
