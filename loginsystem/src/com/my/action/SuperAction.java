package com.my.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class SuperAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware{
	
	private static final long serialVersionUID = 7647775830384115500L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext servletcontext;
	protected HttpSession httpSession;
	
	@Override
	public void setServletContext(ServletContext servletcontext) {
		// TODO Auto-generated method stub
		this.servletcontext = servletcontext;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.httpSession = this.request.getSession();
	}
	
}
