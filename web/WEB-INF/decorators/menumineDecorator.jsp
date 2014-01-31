<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>
<%@ taglib uri="webwork" prefix="webwork" %>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="en">
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<meta http-equiv="expires" content="<%= new java.util.Date() %>" />
		<meta http-equiv="no-cache" content="" />
		<meta http-equiv="refresh" content="3600;url=<webwork:url value="'/logout.action'" />" />
	      <title><decorator:title default="MenuMine" /></title>
    		<link rel="stylesheet" type="text/css" href="<webwork:url value="'/css/menumine.css'" />" />
	    	<link rel="stylesheet" type="text/css" href="<webwork:url value="'/css/menumine.v2.css'" />" />

		<webwork:include page="../jsp/menumine/_menuMineJavaScript.jsp" />
	
      <decorator:head />
    

    </head>

    <body >
    
    
	<webwork:include page="_decoratorHeader.jsp" />
	

<webwork:if test="menuMineDisplayOptions.displayType != 'Profiler'">
	
<table border="0" cellspacing="2" width="100%">
	<tr> 
	   <td width="1" valign="top" >
			<webwork:include page="../jsp/menumine/_menuMineMainForm3Panel.jsp" />
	   </td>
	   <td width="*" valign="top" >
	<webwork:include page="../jsp/menumine/_menuMineTabbedMenu.jsp" />
</webwork:if>
<webwork:else>
<table border="0" cellspacing="2" width="100%">
	<tr> 
	   <td width="*" valign="top" >
</webwork:else>
	
<webwork:if test="menuMineSessionContextWrapper.errorContext.hasErrors()">
<table>
	<webwork:iterator value="menuMineSessionContextWrapper.errorContext.errors" status="mestatus">
	<tr>
		<td>
		  <font color="red"> <webwork:property value="message"/> </font>
		</td>
	</tr>
	</webwork:iterator>
</table>
</webwork:if>

		 <decorator:body />
 
	  	
	 </td>
      </tr>
</table>




<webwork:if test="menuMineDisplayOptions.displayType != 'Profiler'">
<webwork:if test="resetSubmit">
<script>
resetCookies();
</script>
</webwork:if>
<webwork:else>
<script type="text/javascript" language="javascript">
initialize();
</script>
</webwork:else>
</webwork:if>
	
	
	<webwork:include page="_decoratorFooter.jsp" />
			