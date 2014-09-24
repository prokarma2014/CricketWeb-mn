<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<b style="color: green;"> Your Team has been registred and <br> Details are </b>
	<div>
		<table>
			<tr><td><bean:message key="label.teamName" /></td>
				<td><bean:write name="registerform" property="teamName" /></td>
				<td><bean:message key="label.teamId" /></td>
				<td><bean:write name="registerform" property="teamID" /></td>
			</tr>
			<tr><td><bean:message key="label.captainName" /></td>
				<td><bean:write name="registerform" property="captainName" /></td>
						<td><bean:message key="labe.viceCaptionName" /></td>
				<td><bean:write name="registerform" property="viceCaptainName" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.captainId" /></td>
				<td><bean:write name="registerform" property="captainID" /></td>
				<td><bean:message key="label.viceCaptainId" /></td>
				<td><bean:write name="registerform" property="viceCaptainID" /></td>
			</tr>
			<tr>
			<td><bean:message key="label.uploadLogo" /></td>
				<td><bean:write name="registerform" property="teamLogo" /></td>
				<td colspan="2"><html:img action="/LogoImageAction" alt="image"
						border="solid" width="250px" height="250px"></html:img></td>
			</tr>

		</table>
	</div>
<html:link action="goHome" >goto HomePage</html:link>



</body>
</html>