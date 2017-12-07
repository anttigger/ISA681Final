package com.trivia.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;

public class Database {
	public static Connection connection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project", "root", "Hockey13?");
	}

	
	public ResultSet getUser(String user_email) {
		try {
			String insertUser = "SELECT * FROM USER_TABLE WHERE USER_EMAIL = ?";
			PreparedStatement ps = connection().prepareStatement(insertUser);
			ps.setString(1, user_email);
			ResultSet rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addUser(String user_name, String user_pass, byte[] salt_hash) {
		String insertUser = "INSERT INTO USER_TABLE (USER_EMAIL, USER_PASS, SALT)"+
							"VALUES (?,?,?)";
		try {
			PreparedStatement ps = connection().prepareStatement(insertUser);
			ps.setString(1, user_name);
			ps.setString(2, user_pass);
			ps.setBytes(3, salt_hash);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
	public void updateLoginDate(String user) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		String insertUser = "UPDATE USER_TABLE SET LAST_LOGIN = ? where "+
							"user_email = ?";
		try {
			PreparedStatement ps = connection().prepareStatement(insertUser);
			ps.setString(1, timeStamp);
			ps.setString(2, user);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
	public ResultSet getHistoryQuestions() {
		String historyquiz = "SELECT * FROM question_table WHERE category = ?";
		try {
			PreparedStatement ps = connection().prepareStatement(historyquiz);
			ps.setString(1,"history");
			return ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	public ResultSet getSportsQuestions() {
		String historyquiz = "SELECT * FROM question_table WHERE category = ?";
		try {
			PreparedStatement ps = connection().prepareStatement(historyquiz);
			ps.setString(1, "sports");
			return ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	public ResultSet getGeoQuestions() {
		String historyquiz = "SELECT * FROM question_table WHERE category = ?";
		try {
			PreparedStatement ps = connection().prepareStatement(historyquiz);
			ps.setString(1, "geography");
			return ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	public void putUserResponse(String response, String user_id, int question_id, String correct_answer, int userscore) throws Exception {
		String insertResponse = "INSERT INTO USER_RESPONSE (RESPONSE, USER_ID, QUESTION_ID, CORRECT_ANSWER, USER_SCORE) "+
				"VALUES (?,?,?,?,?)";		
		try {
			PreparedStatement ps = connection().prepareStatement(insertResponse);
			ps.setString(1,response);
			ps.setString(2,user_id);
			ps.setInt(3, question_id);
			ps.setString(4, correct_answer);
			ps.setInt(5, userscore);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
