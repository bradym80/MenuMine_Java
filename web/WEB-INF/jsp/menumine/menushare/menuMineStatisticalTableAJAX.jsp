<?xml version="1.0" encoding="ISO-8859-1"?>
<%@ taglib uri="webwork" prefix="webwork" %>
<%
response.setHeader("Content-Type","text/xml; charset=iso-8859-1"); 
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<ajax-response>
	<response type="element" id="shareTable">
	
	<webwork:include page="_menuMineStatisticalTableMain.jsp" />
	
	</response>
</ajax-response>
 