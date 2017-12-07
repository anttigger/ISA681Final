<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login to Trivia Game</title>
</head>
<body>
	<h1 align="center">Login</h1>
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
	
	<s:fielderror name="invalid" />
	<s:form action="loginAction" validate="true" method="post"
		namespace="action">
			<s:textfield name="username" required="true" label="Email Address" />
			<s:password name="password" required="true" label="Password" onsubmit="hashPass()"/>
		<s:submit />
	</s:form>
</body>
</html>