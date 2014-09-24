<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
<style type="text/css">
td{
margin-right:2px;
}

</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin-top: 2%;">
		your details are
		<table>
			<tr>
				<td><bean:message key="player.name" /></td>
				<td><bean:write name="enrollfrom" property="name" /></td>
				<td><bean:message key="Player.have.Played" /></td>
				<td><bean:write name="enrollfrom" property="havePlayed" /></td>
			</tr>
			<tr>
				<td><bean:message key="Player.have.Played" /></td>
				<td><bean:write name="enrollfrom" property="employeeId" /></td>
				<td><bean:message key="Player.personal.high.score" /></td>
				<td><bean:write name="enrollfrom" property="personalHighscore" /></td>
			</tr>
			<tr>
				<td><bean:message key="palyer.designation" /></td>
				<td><bean:write name="enrollfrom" property="designation" /></td>
				<td><bean:message key="player.bowling.best" /></td>
				<td><bean:write name="enrollfrom" property="bowlingBest" /></td>
			</tr>
			<tr>
				<td><bean:message key="player.project.name" /></td>
				<td><bean:write name="enrollfrom" property="projectName" /></td>
				<td><bean:message key="player.pet.name" /></td>
				<td><bean:write name="enrollfrom" property="petName" /></td>
			</tr>
		</table>
	</div>

</body>
</html>