<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="java.util.Date;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
</head>
<body>
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
			<div id="MessageScrool"
				style="color:white;height: 40%; width: 20%; border: thin, solid, black; float: right;">
				<!--need to get data from session  -->
				<marquee behavior="scroll" truespeed="truespeed" direction="up"><%=session.getAttribute("daystogo")%>days
					to go
				</marquee>
			</div>
		</div>
		
		<div id="menuLinks">
			<ul style="list-style-type: none">
				<li><html:link styleClass="headerMenu" action="enrollment.do">
						<bean:message key="menu.enrollment" />
					</html:link></li>
				<li><html:link styleClass="headerMenu"
						action="teamSelection.do">
						<bean:message key="menu.team.selection" />
					</html:link></li>
				<li><html:link styleClass="headerMenu" action="scoreDetails.do">
						<bean:message key="menu.score.details" />
					</html:link></li>
				<li><html:link styleClass="headerMenu" action="Fixtures.do">
						<bean:message key="menu.fixtures.tournament" />
					</html:link></li>
				<li><html:link styleClass="headerMenu" indexId="loging" action="logout.do">
						<bean:message key="logout.key" />
					</html:link></li>
			</ul>

		</div>
		
	</div>
</body>
</html>