<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.nio.charset.StandardCharsets" %>
<%@page import="org.bouncycastle.util.encoders.Hex" %>
<%
 session = request.getSession(true);
 MessageDigest digest = MessageDigest.getInstance("SHA-256");
 SecureRandom secr = SecureRandom.getInstance("SHA1PRNG");
 byte[] salt = new byte[16];
 secr.nextBytes(salt);
 session.setAttribute("salt", salt);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register User</title>
</head>
<body>
	<h1 align="center">Register</h1>
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

	<p>Please enter your email address and a password to register your
		account.</p>
		<s:fielderror name="invalid" />
	<s:form action="registerAction" validate="true" method="post"
		namespace="action">
		<s:textfield name="username" required="true" label="Email Address" />
		<s:password name="password" required="true" label="Password" />

		<s:submit />
	</s:form>
</body>
</html>