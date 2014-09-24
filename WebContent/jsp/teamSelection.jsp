<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div id="header">
	<jsp:include page="header.jsp" />
</div>
	<center>
		<h1>
			<bean:message key="registerForm.title" />
		</h1>
	</center>
	<html:form action="/registerprocess" styleId="registerform"
		enctype="multipart/form-data" method="POST" >
		<div id="teamselection">
		<table border="0" cellspacing="10">
			<tr>
				<td><bean:message key="label.teamName" /></td>
				<td><html:text property="teamName" /></td>
				<td><bean:message key="label.teamId" /></td>
				<td><html:text property="teamID"></html:text>
			</tr>
			<tr>
				<td><bean:message key="label.captainName" /></td>
				<td><html:text property="captainName" /></td>
				<td><bean:message key="labe.viceCaptionName" /></td>
				<td><html:text property="viceCaptainName"></html:text>
			</tr>

			<tr>
				<td><bean:message key="label.captainId" /></td>
				<td><html:text property="captainID" /></td>
				<td><bean:message key="label.viceCaptainId" /></td>
				<td><html:text property="viceCaptainID"></html:text>
			</tr>

			<tr>
				<td><bean:message key="label.selectPlayers" /></td>
				<td><html:text property="selectPlayers">
					</html:text></td>
				<td><bean:message key="label.uploadLogo" />
				<td><html:file property="teamLogo"></html:file></td>
			</tr>

			<tr>
				<td><bean:message key="label.selectedPlayers" /></td>
				<td><html:textarea property="selectedPlayers"></html:textarea></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><html:submit>
						<bean:message key="label.save" />
					</html:submit></td>
				<td><html:submit>
						<bean:message key="label.edit" />
					</html:submit></td>
			</tr>
		</table>
</div>
		<!-- <input type="text" id="namesId" name="names"> -->
		<script>
			$('#selectBy').autocomplete("PlayerNames.jsp");
		</script>

	</html:form>



</body>
</html>