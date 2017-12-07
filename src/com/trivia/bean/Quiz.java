package com.trivia.bean;
	
public class Quiz {
	public static int questionNumber;
	public static String question;
	public static String answer;
	public static String answerFormat;
	public static String category;
	
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestion_number(int questionNumber) {
		Quiz.questionNumber = questionNumber;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		Quiz.question = question;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		Quiz.category = category;
	}
	public String getAnswerFormat() {
		return answerFormat;
	}
	public void setAnswer_format(String answer_format) {
		Quiz.answerFormat = answer_format;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		Quiz.answer = answer;
	}
	
	
}
