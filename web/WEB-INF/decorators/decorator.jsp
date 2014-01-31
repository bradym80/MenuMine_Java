<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>
<%@ taglib uri="webwork" prefix="webwork" %>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>




<html lang="en">
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
      <meta http-equiv="expires" content="<%= new java.util.Date() %>" />
	<meta http-equiv="no-cache" content="" />
      
	<title><decorator:title default="MenuMine" /></title>

	<link rel="stylesheet" type="text/css" href="<webwork:url value="'/css/menumine.css'" />" />
	<link rel="stylesheet" type="text/css" href="<webwork:url value="'/css/menumine.v2.css'" />" />
<script defer type="text/javascript" src="js/pngfix.js"></script>
<script language="javascript" src="dojo031-ajax/dojo.js" ></script>
<script type="text/javascript">
	dojo.require('dojo.debug');
</script>

        
<webwork:include page="../jsp/menumine/_menuMineJavaScript.jsp" /> 
      <decorator:head />
    
	
   	</head>

    <body>


<webwork:include page="_decoratorHeader.jsp" /> 


<div id="mainStage">
	<decorator:body />
</div>

<webwork:include page="_decoratorFooter.jsp" />
			