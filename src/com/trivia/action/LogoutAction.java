package com.trivia.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 4818327577348149967L;
	private Map<String,Object> session;
	
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	@Override
	public String execute() {
		session.remove("user");
		return SUCCESS;
	}
}
