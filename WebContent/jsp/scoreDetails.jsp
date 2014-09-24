<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<title>Scores</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#selectedYear")
								.change(
										function() {
											var xmlhttp;
											var selecteedYear = $(
													"#selectedYear").val();

											var url = "http://localhost:9090/CricWebApp//scoreDetailsPalaceAjax.do";
											var selectQuery = url;
											if (window.XMLHttpRequest) {
												xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari/ hadAjax.do
											} else {
												xmlhttp = new ActiveXObject(
														"Microsoft.XMLHTTP"); //for IE6, IE5
											}
											selectQuery = selectQuery
													+ "?selYear="
													+ selecteedYear;
											xmlhttp.onreadystatechange = function updateEnrollForm() {
												if (xmlhttp.readyState == 4) {
													if (xmlhttp.status == 200) {
														var player = xmlhttp.responseText;
														var valuefromServers = player
																.split("||");
														setOPtion(
																valuefromServers,
																"selectedPlace");

														//var valuefromServers = player.split(",", 8);
														// settingValues(valuefromServers);
													} else {
														alert(" failure in getting details ");
													}
												}
											};
											xmlhttp.open("GET", selectQuery,
													true);
											xmlhttp.send(null);

										});
						$("#selectedPlace")
								.change(
										function() {
											var xmlhttp;
											var selecteedYear = $(
													"#selectedYear").val();
											var selecteedPlace = $(
													"#selectedPlace").val();

											var url = "http://localhost:9090/CricWebApp//scoreDetailsMatchesAjax.do";
											var selectQuery = url;
											if (window.XMLHttpRequest) {
												xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari/ hadAjax.do
											} else {
												xmlhttp = new ActiveXObject(
														"Microsoft.XMLHTTP"); //for IE6, IE5
											}
											selectQuery = selectQuery
													+ "?selYear="
													+ selecteedYear
													+ "&selPlace="
													+ selecteedPlace;
											xmlhttp.onreadystatechange = function updateEnrollForm() {
												if (xmlhttp.readyState == 4) {
													if (xmlhttp.status == 200) {
														var player = xmlhttp.responseText;
														var valuefromServers = player
																.split("||");
														setOPtion(
																valuefromServers,
																"selectedMatch");
													} else {
														alert(" failure in getting details ");
													}
												}
											};
											xmlhttp.open("GET", selectQuery,
													true);
											xmlhttp.send(null);
										});
						function setOPtion(valuefromServers, elementId) {
							var selectedOption = document
									.getElementById(elementId);
							for ( var i = 0; selectedOption.length > 0; i++) {
								selectedOption
										.remove(selectedOption.length - 1);
							}
							for ( var i = 0; i < valuefromServers.length - 1; i++) {
								var keyValues = valuefromServers[i].split(":");
								var opt = document.createElement("option");
								document.getElementById(elementId).options
										.add(opt);
								opt.text = keyValues[1];
								opt.value = keyValues[1];

							}
						}
					});
</script>
<style type="text/css">
#resultTable,.results {
	border-style: solid;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1 style="color: red;">
		<c:out value="Still Unser Construction"></c:out>
	</h1>
	<html:form action="/proccessScoreDetails" method="POST"
		styleId="ScoreDetailsForm">
		<div id="scoredetails">
			<table>

				<tr>
					<td><bean:message key="score.select.year" /></td>
					<td><html:select property="selectedYear"
							styleId="selectedYear">
							<html:options name="PlayedYears" />
						</html:select></td>
				</tr>
				<tr>
					<td><bean:message key="score.select.place" /></td>
					<td><html:select property="selectedPlace"
							styleId="selectedPlace">
							<html:options name="Places" />
						</html:select></td>
				</tr>
				<tr>
					<td><bean:message key="score.select.match" /></td>
					<td><html:select property="selectedMatch"
							styleId="selectedMatch">
							<html:options name="matches" />
						</html:select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><html:submit
							value="GET SCORE DETAILS"></html:submit></td>
				</tr>

			</table>
		</div>
		<div style="margin-left: 15%;">
			<logic:present name="matchdetails">
				<table id="resultTable">
					<tr>
						<td class="results" colspan="2"><bean:write
								name="ScoreDetailsForm" property="selectedMatch" /></td>
					</tr>
					<tr>
						<td class="results"><bean:message key="score.toss.details" /></td>
						<td class="results"><bean:write name="matchdetails"
								property="tossDetails" /></td>
					</tr>
					<tr>
						<td class="results"><bean:message
								key="score.first.innings.score" /></td>
						<td class="results"><bean:write name="matchdetails"
								property="firstInningsScore" /></td>
					</tr>
					<tr>
						<td class="results"><bean:message
								key="score.second.inings.score" /></td>
						<td class="results"><bean:write name="matchdetails"
								property="secondInningsScore" /></td>
					</tr>
					<tr>
						<td class="results"><bean:message key="score.result" /></td>
						<td class="results"><bean:write name="matchdetails"
								property="result" /></td>
					</tr>
					<tr>
						<td class="results"><bean:message key="score.man.of.matach" /></td>
						<td class="results"><bean:write name="matchdetails"
								property="manOfMatch" /></td>
					</tr>
					<tr>
						<td class="results"><bean:message
								key="score.leading.wicketTaker" /></td>
						<td class="results"><bean:write name="matchdetails"
								property="leadingWicketTaker" /></td>
					</tr>
					<tr>
						<td class="results"><bean:message
								key="score.heigh.score.batsman" /></td>
						<td class="results"><bean:write name="matchdetails"
								property="highScorrer" /></td>
					</tr>
					<tr>
						<td class="results"><bean:message key="score.comments" /></td>
						<td class="results"><bean:write name="matchdetails"
								property="comments" /></td>
					</tr>
					<tr>
						<td colspan="2" class="results"><html:link action="Home.do">
								<bean:write name="ScoreDetailsForm" property="selectedMatch" />
							</html:link></td>
					</tr>
				</table>
			</logic:present>
			<logic:notPresent name="matchdetails">
				<!--  match has been called off due to rain  -->
				<p id="paragraph"></p>
			</logic:notPresent>
		</div>
	</html:form>
</body>
</html>