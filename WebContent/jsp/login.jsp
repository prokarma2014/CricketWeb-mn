<!DOCTYPE html:html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html:html>
<head>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<title><bean:message key="index.title" /></title>
</head>
<body>
	<div id="holdslogo" style="margin-bottom: 2%;">
		<div id="logomain">
			<html:img altKey="PPL.logoImage.name" srcKey="PPL.logoImage.src" />
		</div>
		<div id="HeaderMessage">
				<bean:message key="PPL.HeaderMessage" />
				<!--<bean:message key="PPL.Header.Location" />-->
		</div>
	</div>
	<html:form action="/loginprocess" styleId="loginform" method="POST">

		<div style="color: red;">
			<html:errors />
		</div>

		<div class="logincontent">
			
			<table id="tablogincontent">
				<tr>
					<td><bean:message key="lgoin.username" /></td>
					<td><html:text property="userName" /></td>
				</tr>
				<tr>
					<td><bean:message key="login.password" /></td>
					<td><html:password property="password" /></td>
				</tr>
				<tr>
					<td><html:submit value="login" style="margin-left:20px;width:70px;height:30px"/></td>
					<td><html:link action="signup" style="margin-left:20px;color:white;">
							<bean:message key="signup.link" />
						</html:link></td>
				</tr>

			</table>
		</div>
	</html:form>
</body>

</html:html>

