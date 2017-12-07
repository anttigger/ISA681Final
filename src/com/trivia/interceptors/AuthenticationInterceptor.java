package com.trivia.interceptors;
import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.trivia.bean.User;

public class AuthenticationInterceptor implements Interceptor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8737468309439937L;

	public void destroy(){
		
	}
	
	public void init() {
		
	}
	
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			return ActionSupport.LOGIN;
		}
		return actionInvocation.invoke();
	}
}
