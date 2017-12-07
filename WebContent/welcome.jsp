<%@ page language="java" contentType="text/html;" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trivia Game</title>
</head>
<body>
	<h3 align="center">Welcome <s:property value="#session.user" />, you have logged in successfully!</h3>
	<s:if test="hasActionMessages()">
		<div class="message">
			<s:actionmessage />
		</div>
	</s:if>
	<h3> The rules of this game are simple, take the three quizzes below and once you've completed you will have an overall score. <br />
		You can see where your score stands in comparison to other users by clicking on the View Results link below. <br />
		No Cheating and Have fun. 	
	</h3>
		
	<a href="action/historyquiz">History Quiz</a><br />
	<a href="action/sportsquiz">Sports Quiz</a><br />
	<a href="action/geographyquiz">Geography Quiz</a><br />
	<br /><br />
	<a href="action/results">View Results</a><br />
	<a href="action/logout">Logout</a>
</body>
</html>