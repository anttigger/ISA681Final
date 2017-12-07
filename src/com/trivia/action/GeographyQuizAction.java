package com.trivia.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.trivia.bean.Database;
import com.trivia.bean.Quiz;

public class GeographyQuizAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6951392193848718634L;
	public Quiz q;
	Database db = new Database();
	public int userQuestion = 0;
	public String question;
	public int question_number;
	public String answer_format;
	public String answer;
	public String user_answer = null;
	public String category;

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public Quiz[] quizQuestions;

	public String execute() {

		int userscore = 0;
		ResultSet rs = db.getGeoQuestions();
		try {
			
			if (userQuestion == 0) {
				rs.next();
			} else if (userQuestion == 1) {
				rs.absolute(userQuestion + 1);
			} else {
				rs.absolute(userQuestion + 1);
			}

			question_number = rs.getInt("q_number");
			answer = rs.getString("answer");
			question = rs.getString("question");
			answer_format = rs.getString("answer_format");
			category = rs.getString("category");
			userQuestion = userQuestion + 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user_answer != null) {
			if (answer.equalsIgnoreCase(user_answer)) {
				userscore = userscore + 20;
			}
			try {
				db.putUserResponse(user_answer, (String) session.get("user"), question_number, answer, userscore);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (userQuestion > 5) {
				addActionMessage(
						"You have completed the quiz on the Geography Category. Complete the rest of the quizzes to get a final score. "
								+ "you can view your results of this quiz on the View Results page. ");
				return SUCCESS;
			}
			return INPUT;
		}
			
		
		return INPUT;
	}

	public Quiz getQ() {
		return q;
	}

	public void setQ(Quiz q) {
		this.q = q;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getQuestion_number() {
		return question_number;
	}

	public void setQuestion_number(int question_number) {
		this.question_number = question_number;
	}

	public String getAnswer_format() {
		return answer_format;
	}

	public void setAnswer_format(String answer_format) {
		this.answer_format = answer_format;
	}
}
