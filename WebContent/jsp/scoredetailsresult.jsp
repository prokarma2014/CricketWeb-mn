<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<bean:write name="ScoreDetailsForm" property="selectedYear" />
	ghai
	<div>
		<logic:present name="matchdetails">
			<table>
				<tr>
					<td><bean:write name="ScoreDetailsForm"
							property="selectedMatch" /></td>
				</tr>
				<tr>
					<td><bean:message key="score.toss.details" /></td>
					<td><bean:write name="matchdetails" property="tossDetails" />
					</td>
				</tr>
				<tr>
					<td><bean:message key="score.first.innings.score" /></td>
					<td><bean:write name="matchdetails"
							property="firstInningsScore" /></td>
				</tr>
				<tr>
					<td><bean:message key="score.second.inings.score" /></td>
					<td><bean:write name="matchdetails"
							property="secondInningsScore" /></td>
				</tr>
				<tr>
					<td><bean:message key="score.result" /></td>
					<td><bean:write name="matchdetails" property="result" /></td>
				</tr>
				<tr>
					<td><bean:message key="score.man.of.matach" /></td>
					<td><bean:write name="matchdetails" property="manOfMatch" /></td>
				</tr>
				<tr>
					<td><bean:message key="score.leading.wicketTaker" /></td>
					<td><bean:write name="matchdetails"
							property="leadingWicketTaker" /></td>
				</tr>
				<tr>
					<td><bean:message key="score.heigh.score.batsman" /></td>
					<td><bean:write name="matchdetails" property="highScorrer" /></td>
				</tr>
				<tr>
					<td><bean:message key="score.comments" /></td>
					<td><bean:write name="matchdetails" property="comments" /></td>
				</tr>
				<tr>
					<td colspan="2"><html:link action="Home.do">
							<bean:write name="ScoreDetailsForm" property="selectedMatch" />
						</html:link></td>
				</tr>
			</table>
		</logic:present>
		<logic:notPresent name="matchdetails">
match has been called off due to rain
</logic:notPresent>
	</div>
</body>
</html>