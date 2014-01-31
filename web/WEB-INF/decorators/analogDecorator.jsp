<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>
<%@ taglib uri="webwork" prefix="webwork" %>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta http-equiv="expires" content=<%= new java.util.Date() %>>
		<meta http-equiv="no-cache">
        <title>
    		Menumine
    	</title>
    	<link rel="stylesheet" type="text/css" href="<webwork:url value="'/css/menumine.css'" />">

	<decorator:head />
    

	
    </head>
    <body>
  
<table class="header" width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="white">
    <td  class="pageHeader"  align="left"><img src="img/logo.gif" height="53"/></td>
    <td  class="pageHeaderFade" > <img align="right"  src="img/fade-page-header.jpg"  height="53"/ ></td>
  </tr>
</table>

<webwork:if test="menuMineSessionContextWrapper.valid">
<table   width="100%"  cellpadding="0" cellspacing="0" border="2">


  		<tr  class="header">
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'dashboard.action'"/>">HOME</a></td>
    			
    		<webwork:if test="menuMineSessionContextWrapper.authorizationBean.menumine">
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'usemenumine.action'"/>">MENUMINE</a></td>
    		</webwork:if>	
			<webwork:if test="menuMineSessionContextWrapper.authorizationBean.dessertMine">
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'dessertmine.action'"/>">DESSERT MENUMINE</a></td>
    		</webwork:if>
    		<webwork:if test="menuMineSessionContextWrapper.authorizationBean.ingredientMine">
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'ingredientmine.action'"/>">INGREDIENT MENUMINE</a></td>
    		</webwork:if>
    		
    		
			<webwork:if test="menuMineSessionContextWrapper.authorizationBean.justNationalAccountBenchmark">
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'menumineNatlAccountBenchmark.action'"/>">NATIONAL ACCOUNT BENCHMARK</a></td>
    		</webwork:if>    		
    		
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'savedQueryList.action'"/>">QUERY MANAGER</a> </td>
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'chainStatList.action'"/>">CHAIN STAT </a></td>
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'chainMap.action'"/>">CHAIN MAP </a></td>
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'menuBookList.action'"/>">MENUBOOK</a></td>
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'menuBookTrendList.action'"/>">MENUBOOK TRENDS </a></td>
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'flavorProfiler.action'"/>">PROFILER</a></td>
    		<webwork:if test="menuMineSessionContextWrapper.adminRights">
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'/administrationMenu.action'" />">ADMIN</a></td>
    		</webwork:if>
    		  	<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'forumMain.action'"/>">FORUM</a></td>
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'logout.action'"/>">LOGOUT</a></td>
  			

  			 
  			
  			</tr>
		
		
	

</table>
</webwork:if>	
	
	<decorator:body />

</body>
</html>