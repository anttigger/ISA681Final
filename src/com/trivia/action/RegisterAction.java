package com.trivia.action;

import java.sql.ResultSet;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.trivia.bean.Database;
import com.trivia.action.HashPassword;

public class RegisterAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3423525817316322938L;
	private String username, password, msg;
	Database db = new Database();
	@SuppressWarnings("unused")
	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public String execute() throws Exception {
		try {
			ResultSet rs = db.getUser(username);
			if (rs.isBeforeFirst()) {
				addActionError("There is already an account with this username. Please try a different email address.");
				return INPUT;
			} else {
				byte[] salt_hash = (byte[]) session.get("salt");
				System.out.println("Salt in byte: "+salt_hash);
				System.out.println("Salt in string: "+salt_hash);
				HashPassword h = new HashPassword();
				password = h.hashPassword(password, salt_hash);
				db.addUser(username, password, salt_hash);
				addActionMessage("Account has been created. You are now able to login.");
				return SUCCESS;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}
	

	public String getPassword() {
		return password;
	}
	@RegexFieldValidator(       
		    regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{10,12}$",
		    message = "You must enter a valid Password (10-12 Characters, At least 1-Uppercase letter, 1-Lowercase letter, 1 number, and 1 Special Character (!@#$%^*)"
		)
	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUsername() {
		return username;
	}
	@RegexFieldValidator(  
		    regex = "^([a-zA-Z0-9_\\-\\.]+)@(([a-zA-Z0-9\\-]+\\.)+)([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",
		    message = "Please enter a valid username (example@gmu.edu)"
		)
	public void setUsername(String username) {
		this.username = username;
	}
}
