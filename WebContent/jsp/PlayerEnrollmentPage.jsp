<!DOCTYPE html:html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>Enrollment</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var xmlhttp;
				$("#hadplayed").change(function() {
					var hadplayed = $("#hadplayed").val();
					var url = "http://localhost:9090CricWebApp/hadAjax.do";

					if (window.XMLHttpRequest) {
						xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari/ hadAjax.do
					} else {
						xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
					}
					xmlhttp.onreadystatechange = updateEnrollForm;
					xmlhttp.open("GET", url, true);

					if (hadplayed == "Yes") {
						xmlhttp.send(null);
						setdisabled();
					}

				});
				function updateEnrollForm() {
					if (xmlhttp.readyState == 4) {
						if (xmlhttp.status == 200) {
							var player = xmlhttp.responseText;
							var valuefromServers = player.split(",", 8);
							settingValues(valuefromServers);
						} else {
							alert(" failure in getting details ");

						}
					}
				}
				function settingValues(valuefromServers) {
					for ( var i = 0; i < valuefromServers.length; i++) {
						var keyValues = valuefromServers[i].split(":");
						if (keyValues[1].indexOf("null") == -1) {
						document.getElementById(keyValues[0]).value=keyValues[1];
						//	document.getElementById(keyValues[0]).setAttribute(
							//		"value", keyValues[1]);
						} else {
							document.getElementById(keyValues[0]).value="";
							//document.getElementById(keyValues[0]).setAttribute(
								//	"value", "");
						}
					}
				}
			});

	function setdisabled() {
		document.getElementById("name").disabled = true;
		document.getElementById("employeeId").disabled = true;
		document.getElementById("personalHighscore").disabled = true;
		document.getElementById("designation").disabled = true;
		document.getElementById("bowlingBest").disabled = true;
		document.getElementById("projectName").disabled = true;
		document.getElementById("petName").disabled = true;
		document.getElementById("enroll").disabled = true;

	}
</script>

</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
	</div>

	<div>

		<html:form action="enrolled" styleId="enrollform" method="post">
			 <html:errors property="all" />
			<div id="playerenrollment">
			<table>
				<tr>
					<td class="enrollform"><bean:message key="Player.have.Played" /></td>
					<td><html:select property="havePlayed" styleId="hadplayed">
							<html:option value="No" />
							<html:option value="Yes" />

						</html:select></td>
					<td><bean:message key="player.name" /></td>
					<td><html:text property="name" disabled="false" styleId="name"></html:text>
						<b> <br> <html:errors property="name" /></b></td>
				</tr>
				<tr>
					<td class="enrollform"><bean:message key="player.id" /></td>
					<td><html:text property="employeeId" disabled="false"
							styleId="employeeId"></html:text><br> <b> <html:errors
								property="employeeId" /></b></td>
					<td class="enrollform"><bean:message
							key="Player.personal.high.score" /></td>
					<td><html:text property="personalHighscore" disabled="false"
							styleId="personalHighscore"></html:text></td>
				</tr>
				<tr>
					<td class="enrollform"><bean:message key="palyer.designation" /></td>
					<td><html:text property="designation" disabled="false"
							styleId="designation"></html:text> <br> <b> <html:errors
								property="designation" /></b></td>
					<td class="enrollform"><bean:message key="player.bowling.best" /></td>
					<td><html:text property="bowlingBest" disabled="false"
							styleId="bowlingBest"></html:text></td>
				</tr>
				<tr>
					<td class="enrollform"><bean:message key="player.project.name" /></td>
					<td><html:text property="projectName" disabled="false"
							styleId="projectName"></html:text> <br> <b><html:errors
								property="projectName" /></b></td>
					<td class="enrollform"><bean:message key="player.pet.name" /></td>
					<td><html:text property="petName" disabled="false"
							styleId="petName"></html:text> <br> <b><html:errors
								property="petName" /></b></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><html:submit value="ENROLL" styleId="enroll" /></td>
				</tr>
			</table>
			</div>

		</html:form>
	</div>
	<script type="text/javascript">
		var hadplay = document.getElementById("hadplayed").value;
		if (hadplay.toString().indexOf("Yes", 0) == 0) {
			setdisabled();

		}
	</script>
</body>
</html>