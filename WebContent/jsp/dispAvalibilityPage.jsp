<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<%
SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yyyy");
SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/YYYY");
Calendar curDate = Calendar.getInstance();%>
</head>
<body>
	<html:form action="getAvalibility.do" styleId="playerAvailform">
		<div style="width: 100%; border-bottom-color: black;">
			<div id="header" style="width: 100%">
				<div id="holdslogo" style="margin-bottom: 2%;">

					<div id="holdslogo" style="margin-bottom: 2%;">
						<div id="logomain">
							<html:img altKey="PPL.logoImage.name" srcKey="PPL.logoImage.src" />
						</div>
						<div id="HeaderMessage">
							<bean:message key="PPL.HeaderMessage" />
							<!--<bean:message key="PPL.Header.Location" />-->
						</div>
					</div>
				</div>

			</div>
		</div>
		<div id="teamAvilheadder">Players Availability System</div>
		<div id="teamAvilsubheader">Update your availability for this week(<%curDate.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
				out.println(""+sdf2.format(curDate.getTime())+" to "); curDate.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
				out.println(sdf2.format(curDate.getTime()));%> )</div>
		<div id="teamAvilcontent">
			<table>
				<tr>
					<td><bean:message key="avail.player.name" /></td>
					<td><html:select property="playerName" style="width: 110px;" styleId="playerName">
							<html:option value="Ashwin S" />
							<html:option value="Balaji S" />
							<html:option value="Deepesh PK" />
							<html:option value="Gnanasankar" />
							<html:option value="Gopal K" />
							<html:option value="Jagan M R" />
							<html:option value="John Thomas" />
							<html:option value="Maddula" />
							<html:option value="Magesh R" />
							<html:option value="Mohideen M" />
							<html:option value="Narayanan P" />
							<html:option value="Raghul" />
							<html:option value="Ram Sathia" />
							<html:option value="Ranjithkumar R" />
							<html:option value="Ravi Kiran M" />
							<html:option value="Santhanam E" />
							<html:option value="Saravanan" />
							<html:option value="Vignesh R" />
							<html:option value="Vinod Ram" />
							<html:option value="Vishal J" />
						</html:select> <b> <br> <html:errors property="tuesdayNets" /></b></td>
				</tr>
				<tr>
					<td><bean:message key="pavail.tuesday" /><% curDate.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
					out.println(" ("+sdf.format(curDate.getTime())+")"); %></td>
					<td><html:select property="tuesdayNets" style="width: 110px;" styleId="tuesdayNets">
							<html:option value="No" />
							<html:option value="Yes" />

						</html:select> <b> <br> <html:errors property="tuesdayNets" /></b></td>
				</tr>
				<tr>
					<td><bean:message key="pavail.thursday" /><% curDate.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
					out.println(" ("+sdf.format(curDate.getTime())+")"); %></td>
					<td><html:select property="thursdayNets" style="width: 110px;"
							styleId="thursdayNets">
							<html:option value="No" />
							<html:option value="Yes" />

						</html:select> <b> <br> <html:errors property="thursdayNets" /></b></td>
				</tr>
				<tr>
					<td><bean:message key="pavail.saturday" /><% curDate.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
					out.println(" ("+sdf.format(curDate.getTime())+")"); %></td>
					<td><html:select property="saturdaymatch" style="width: 110px;"
							styleId="saturdaymatch">
							<html:option value="No" />
							<html:option value="Yes" />

						</html:select> <b> <br> <html:errors property="saturdaymatch" /></b></td>
				</tr>
				<tr>
					<td><html:submit style="margin-left:90px;">Update</html:submit></td>
				</tr>

			</table>
		</div>
		<logic:present name="updated">
		<h1 style="margin-left: 40%; color: green;">Updated Successfully</h1>
		</logic:present>
		
		<html:hidden property="currentPlayer"/>
	</html:form>
</body>
</html>