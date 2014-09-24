<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="css/jquery.autocomplete.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="js/jquery.autocomplete.js"></script>
<style>
input {
	font-size: 120%;
}
</style>
<!-- var request;
function myFunction()
{
	var url="http://localhost:9090/CricWebApp/register.do";
	   if (window.XMLHttpRequest) {
		      request = new XMLHttpRequest();
		      request.onreadystatechange = displayNames;
		      try
		      {
		    	  request.open("POST", url, true);
		    	  }
		      catch (e) {
		    	  alert("Unable to connect to server to retrieve Names");
				// TODO: handle exception
			}
		      request.send(null);
		      }
	   
	   else if(window.ActiveXObject)
		   {
		   request = new ActiveXObject("Microsoft.XMLHTTP");
		   if (request) {
			   request.onreadystatechange = displayNames;
			   request.open("GET", url, true);
		        request.send();
		   }
		   }
	
	}
	
	function displayNames()
	{
		 if (request.readyState == 4) {
		      if (request.status == 200) {
		    	  var names=request.responseText;
		    	  document.getElementById("textId").innerHTML=names;
		      }
		      else
		    	  {
		    	  alert("unable to retrive names");
		    	  }
		    	  }
	} -->


</head>
<body>
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