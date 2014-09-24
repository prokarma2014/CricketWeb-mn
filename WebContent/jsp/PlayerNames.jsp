<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.pkrm.cric.action.PlayerDAOImplDB"%>
<%
PlayerDAOImplDB players=new PlayerDAOImplDB();
String query = request.getParameter("q");
List<String> nameList=players.getPlayerDetailsByName(query);
Iterator<String> iterator = nameList.iterator();
while(iterator.hasNext())
{
	String names =(String)iterator.next();
	out.println(names);
}

%>
<%= "hi" %>