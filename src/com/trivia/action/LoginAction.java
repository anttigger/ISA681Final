package com.trivia.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import com.trivia.bean.User;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.trivia.bean.Database;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 2051601449480157041L;
	private String password;
	private ResultSet rs;
	private String username;

	private Map<String, Object> session;

	Database db = new Database();

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() throws Exception {

		return login();
	}

	public String login() throws SQLException {
		String loggedUserName = null;
		User user = new User();
		// check if the userName is already stored in the session
		if (session.containsKey("username")) {
			loggedUserName = (String) session.get(username);
		}
		if (loggedUserName != null) {
			return SUCCESS; // return welcome page
		}

		// if no userName stored in the session,
		// check the entered userName and password
		HashPassword h = new HashPassword();
		rs = db.getUser(username);
		if (rs.isBeforeFirst()) {
			rs.next();
			byte[] salt = rs.getBytes("SALT");
			String entered_password_hash = h.hashPassword(password, salt);
			if ((rs.getString("user_email").equalsIgnoreCase(username)) && (rs.getString("user_pass").equalsIgnoreCase(entered_password_hash))) {
				user.setUsername(username);
				user.setPassword(password);
				session.put("user", username);
				db.updateLoginDate(username);
				addActionMessage("Your last login occured on: "+rs.getString("LAST_LOGIN"));
				return SUCCESS;
			} else {
				addActionError("Incorrect password. Please try again.");
				return INPUT;
			}
		} else {
			addActionError("Username does not exist. Please register before attempting to login.");
			return INPUT;
		}
	}
	
	public String getPassword() {
		return password;
	}
	@RegexFieldValidator(       
		    regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{10,12}$",
		    message = "You must enter a valid Password (10-12 Characters, At least 1-Uppercase letter, 1-Lowercase letter, 1 number, and 1 Special Character (!@#$%^*)"
		)
	public void setPassword(String password) {
		this.password = password;
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
