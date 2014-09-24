<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TestPage</title>
<style type="text/css">
table ,td { /* text-align: center; */
border-style:solid ;
border-collapse:collapse;	
}
</style>
</head>

<body>
	hai
	<%-- <jsp:useBean class="com.pkrm.cric.model.Player" id="players"></jsp:useBean> --%>
	Batting Details
	<table>
		<tr>
			<td colspan="8"><bean:write name="firstInnings" property="battingTeamName" /> <bean:write
					name="firstInnings" property="totalRuns" />( <bean:write
					name="firstInnings" property="totalOvers" /> Overs)</td>
		</tr>
		<tr>
			<td colspan="3" style="text-align: left;">BATSMAN</td>
			<td>Runs</td>
			<td>Balls</td>
			<td>4's</td>
			<td>6's</td>
			<td>S/R</td>
		</tr>


		<logic:iterate id="batsman" name="batsmans">
			<tr>
				<td><bean:write name="batsman" property="name" /></td>
				<logic:notEmpty name="batsman" property="caatchedBy">
					<td>c <bean:write name="batsman" property="caatchedBy" /></td>
				</logic:notEmpty>
				<logic:notEmpty name="batsman" property="lbwBy">
					<td colspan="2">lbw <bean:write name="batsman"
							property="lbwBy" /></td>
				</logic:notEmpty>
				<logic:notEmpty name="batsman" property="bowledBy">
					<td colspan="2">b <bean:write name="batsman"
							property="bowledBy" /></td>
				</logic:notEmpty>
				<logic:notEmpty name="batsman" property="runOutBY">
					<td colspan="2">r/o <bean:write name="batsman"
							property="runOutBY" /></td>
				</logic:notEmpty>
				<td><bean:write name="batsman" property="runs" /></td>
				<td><bean:write name="batsman" property="balls" /></td>
				<td><bean:write name="batsman" property="fours" /></td>
				<logic:empty name="batsman" property="sixs">
					<td>-</td>
				</logic:empty>
				<logic:notEmpty name="batsman" property="sixs">
					<td><bean:write name="batsman" property="sixs" /></td>
				</logic:notEmpty>

				<td><bean:write name="batsman" property="strikeRate" /></td>
			</tr>
		</logic:iterate>
		<tr>
			<td colspan="8">Extras(<logic:notEmpty name="firstInnings" property="wides">
					Wides: <bean:write name="firstInnings" property="wides" />
				</logic:notEmpty> <logic:notEmpty name="firstInnings" property="noballs">
					,No Balls: <bean:write name="firstInnings"
							property="noballs" />
				</logic:notEmpty> <logic:notEmpty name="firstInnings" property="legByes">
					, Leg Byes: <bean:write name="firstInnings"
							property="legByes" />
				</logic:notEmpty> <logic:notEmpty name="firstInnings" property="byes">
					, Byes: <bean:write name="firstInnings" property="byes" />
				</logic:notEmpty> ) : <bean:write name="firstInnings" property="extras" />
			</td>
		</tr>
		<tr>
			<td colspan="8" style="text-align: right;">Total:<bean:write
					name="firstInnings" property="totalRuns" />( <bean:write
					name="firstInnings" property="totalOvers" />) Run Rate: <bean:write
					name="firstInnings" property="runrate" />
			</td>
		</tr>
	</table>
	<div style="margin-top: 2%; margin-bottom: 2%;"></div>
	<table>
	<tr><td colspan="8"><bean:write name="firstInnings" property="blowingTeamName"/> </td></tr>
		<tr>
			<td>blower</td>
			<td>Overs</td>
			<td>Madiens</td>
			<td>Runs</td>
			<td>wicket</td>
			<td>wide</td>
			<td>No Ball</td>
			<td>economy</td>
		</tr>
		<logic:iterate id="blower" name="blowers">
			<tr>
				<td><bean:write name="blower" property="name" /></td>
				<td><bean:write name="blower" property="overs" /></td>
				<td><bean:write name="blower" property="madiens" /></td>
				<td><bean:write name="blower" property="runs" /></td>
				<td><bean:write name="blower" property="wicket" /></td>
				<td><bean:write name="blower" property="noBall" /></td>
				<td><bean:write name="blower" property="wide" /></td>
				<td><bean:write name="blower" property="economy" /></td>
			</tr>
		</logic:iterate>

	</table>
	
<!--     SECOND innigs -->
<b style="margin-top: 3%">
Second Innings</b>
Batting Details
	<table>
		<tr>
			<td colspan="8"><bean:write name="secondInnings" property="battingTeamName" /> <bean:write
					name="secondInnings" property="totalRuns" />( <bean:write
					name="secondInnings" property="totalOvers" /> Overs)</td>
		</tr>
		<tr>
			<td colspan="3" style="text-align: left;">BATSMAN</td>
			<td>Runs</td>
			<td>Balls</td>
			<td>4's</td>
			<td>6's</td>
			<td>S/R</td>
		</tr>


		<logic:iterate id="batsman" name="secondInningsBatsmans">
			<tr>
				<td><bean:write name="batsman" property="name" /></td>
				<logic:notEmpty name="batsman" property="caatchedBy">
					<td>c <bean:write name="batsman" property="caatchedBy" /></td>
				</logic:notEmpty>
				<logic:notEmpty name="batsman" property="lbwBy">
					<td colspan="2">lbw <bean:write name="batsman"
							property="lbwBy" /></td>
				</logic:notEmpty>
				<logic:notEmpty name="batsman" property="bowledBy">
					<td colspan="2">b <bean:write name="batsman"
							property="bowledBy" /></td>
				</logic:notEmpty>
				<logic:notEmpty name="batsman" property="runOutBY">
					<td colspan="2">r/o <bean:write name="batsman"
							property="runOutBY" /></td>
				</logic:notEmpty>
				<td><bean:write name="batsman" property="runs" /></td>
				<td><bean:write name="batsman" property="balls" /></td>
				<td><bean:write name="batsman" property="fours" /></td>
				<logic:empty name="batsman" property="sixs">
					<td>-</td>
				</logic:empty>
				<logic:notEmpty name="batsman" property="sixs">
					<td><bean:write name="batsman" property="sixs" /></td>
				</logic:notEmpty>

				<td><bean:write name="batsman" property="strikeRate" /></td>
			</tr>
		</logic:iterate>
		<tr>
			<td colspan="8">Extras(<logic:notEmpty name="secondInnings" property="wides">
					Wides: <bean:write name="secondInnings" property="wides" />
				</logic:notEmpty> <logic:notEmpty name="secondInnings" property="noballs">
					,No Balls: <bean:write name="secondInnings"
							property="noballs" />
				</logic:notEmpty> <logic:notEmpty name="secondInnings" property="legByes">
					, Leg Byes: <bean:write name="secondInnings"
							property="legByes" />
				</logic:notEmpty> <logic:notEmpty name="secondInnings" property="byes">
					, Byes: <bean:write name="secondInnings" property="byes" />
				</logic:notEmpty> ) : <bean:write name="secondInnings" property="extras" />
			</td>
		</tr>
		<tr>
			<td colspan="8" style="text-align: right;">Total:<bean:write
					name="secondInnings" property="totalRuns" />( <bean:write
					name="secondInnings" property="totalOvers" />) Run Rate: <bean:write
					name="secondInnings" property="runrate" />
			</td>
		</tr>
	</table>
	<div style="margin-top: 2%; margin-bottom: 2%;"></div>
	<table>
	<tr><td colspan="8"><bean:write name="secondInnings" property="blowingTeamName"/> </td></tr>
		<tr>
			<td>blower</td>
			<td>Overs</td>
			<td>Madiens</td>
			<td>Runs</td>
			<td>wicket</td>
			<td>wide</td>
			<td>No Ball</td>
			<td>economy</td>
		</tr>
		<logic:iterate id="blower" name="secondInningsBlowers">
			<tr>
				<td><bean:write name="blower" property="name" /></td>
				<td><bean:write name="blower" property="overs" /></td>
				<td><bean:write name="blower" property="madiens" /></td>
				<td><bean:write name="blower" property="runs" /></td>
				<td><bean:write name="blower" property="wicket" /></td>
				<td><bean:write name="blower" property="noBall" /></td>
				<td><bean:write name="blower" property="wide" /></td>
				<td><bean:write name="blower" property="economy" /></td>
			</tr>
		</logic:iterate>

	</table>
	
</body>
</html>