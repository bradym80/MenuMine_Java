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
    <webwork:include page="../jsp/menumine/_menuMineJavaScript.jsp" />
        <decorator:head />
    
<%--
       <script type="text/javascript" language="javascript">
	<!--

      var onloads = new Array();
      function bodyOnLoad() {
       
         for ( var i = 0 ; i < onloads.length ; i++ )
            onloads[i]();
      }
	//-->
   </script>
	--%>
    </head>
    <%--  %><body onload="javascript:bodyOnLoad()"> --%>
    <body >
    
    
	<webwork:include page="_decoratorHeader.jsp" />
	
	
<table border="0" cellspacing="2" width="100%">
	
	<tr> 
	   <td width="1" valign="top" >
		
			
	   <webwork:if test="menuMineSessionContextWrapper.valid">   			
	    			  

		
		<webwork:include page="../jsp/menumine/_menuMineMainForm.jsp" />
	   </td>
	   <td width="*" valign="top" >
	
	  
	  
	  <table>
	  <tr>
	 	<td class="smallFont"> 
			<a href="#nowhere" onclick="javascript:toggle('mainFormDiv');" >
			<img id="mainFormDiv_image"  border="0" src="img/expand.gif" alt="expand" /> 
		</a>          
		</td>
		<td class="smallFont">
			Toggle Power Search
		</td>
	 </tr>
	 </table>
	

	
	<webwork:include page="../jsp/menumine/_menuMineLastQuerySummaryParagraphImpl.jsp" />	
	<%--
	<webwork:include page="../jsp/menumine/express/_menuMineExpressSearchOnMain.jsp" />	--%>
	<br/>	
	<webwork:include page="../jsp/menumine/_menuMineTabbedMenu.jsp" />
	
		
	
	 
	</webwork:if>
		 <decorator:body />
 
	  	
	  <webwork:if test="menuMineSessionContextWrapper.valid">   	

	 </td>
      </tr>
</table>

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
			