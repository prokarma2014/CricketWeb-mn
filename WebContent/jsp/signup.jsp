<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUP</title>
<style>
b{
color: red;
}
</style>
</head>
<body>
	<div style="float:center;margin-left: 25% ">
		<b style="color: green;">SIGN UP FOR PPL </b>
		<html:form action="/signUpProcess" method="POST" >
			<b><html:errors property="all"/></b>
			<table>
				<tr>
					<td><bean:message key="firstName" /></td>
					<td><html:text property="firstName" /></td>
					<td><b><html:errors property="firstName" /></b></td>
				</tr>
				<tr>
					<td><bean:message key="lastName" /></td>
					<td><html:text property="lastName" /></td>
					<td><b><html:errors property="lastName" /></b></td>
				</tr>
				<tr>
					<td><bean:message key="player.id" /></td>
					<td><html:text property="employeeId" /></td>
					<td><b><html:errors property="employeeId" /></b></td>
				</tr>
				<tr>
					<td><bean:message key="emailId" /></td>
					<td><html:text property="emailId" /></td>
					<td><b><html:errors property="emailId" /></b></td>
				</tr>
				<tr>
					<td><bean:message key="lgoin.username" /></td>
					<td><html:text property="userName" /></td>
					<td><b><html:errors property="userName" /></b></td>
				</tr>
				<tr>
					<td><bean:message key="login.password" /></td>
					<td><html:password property="password" /></td>
					<td><b><html:errors property="password" /></b></td>
				</tr>
				<tr>
					<td><bean:message key="login.password.repeat" /></td>
					<td><html:password property="repeatPassword" /></td>
					 <td><b><html:errors property="repeatPassword" /></b></td>
				</tr>
				<tr>
					<td><html:submit value="Sign Up" /></td>
				</tr>
			</table>
		</html:form>
	</div>
</body>
</html>