<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<logic:iterate id="place" name="showplaces"><bean:write name="place" />:<bean:write name="place" />||</logic:iterate>
