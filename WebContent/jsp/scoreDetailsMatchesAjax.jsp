<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<logic:iterate id="match" name="showMatches"><bean:write name="match" />:<bean:write name="match" />||</logic:iterate>