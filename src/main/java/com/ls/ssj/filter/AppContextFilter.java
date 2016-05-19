package com.ls.ssj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ls.ssj.base.AppContext;
import com.ls.ssj.entity.User;

public class AppContextFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		User user = (User) req.getSession().getAttribute("user");
		
		AppContext.putThreadContext("user", user);
		
		chain.doFilter(request, response);
		
		System.out.println("aaaaaaaaaaaaa");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

}
