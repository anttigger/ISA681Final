<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.trivia.bean.Quiz"%>
<%@ page import="com.trivia.action.HistoryQuizAction"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz Time</title>
</head>
<body>
	<h1 align="center"><s:property value="category" /> Quiz</h1>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<s:if test="hasActionMessages()">
		<div class="errors">
			<s:actionmessage />
		</div>
	</s:if>
	<h3>Question <s:property value="question_number" />, <s:property value="question" /></h3>
	<s:form action="historyquiz" validate="true" method="post" namespace="action">
			<s:textfield name="user_answer" required="true" label="Your Answer" />
			<s:property value="answer_format" />
			<s:hidden name="answer" value="%{answer}" />
			<s:hidden name="userQuestion" value="%{userQuestion}" />
		<s:submit />
	</s:form>
</body>
</html>