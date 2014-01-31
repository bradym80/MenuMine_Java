<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>
<%@ taglib uri="webwork" prefix="webwork" %>


<webwork:if test="menuMineSessionContextWrapper.valid">

<div id="header">
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr >
    <td width="193" ><a href="<webwork:url value="'dashboard.action'" includeParams="'none'"/>"><img src="img/logo.gif" width="193" height="53" alt="MenuMine" border="0" /></a></td>
    <td class="fade" > 
    
    
	
	<div id="headerMenu">
	
	
	<table width="100%">
	<tr>
		<td colspan="9"><p class="mainMenuPhone" >888-386-MENU</p></td></tr>
	<tr >
		<td > <a class="mainMenu" href="<webwork:url value="'dashboard.action'" includeParams="'none'"/>">HOME</a>	</td>
		
    		
    		<%-- 06-18-08 MJB Removed Select Mine Because it is confusing.
    		 <td > 
			
		
		<a href="#nowhere" class="mainMenu" onclick="javascript:toggle('mailshortcuts');" >SELECT MINE </a>
                  	
                <div id="mailshortcuts" class="shortcuts" style="display:none;">
                  
                  <ul >
				<!-- 6-18-08 MJB Changed ingredient mine to "Savory Menumine" -->
				<!-- <li><a  class="mainMenu" href="<webwork:url value="'usemenumine.action'" includeParams="'none'"/>">MENUMINE</a> </li> -->
				<li><a class="mainMenu" href="<webwork:url value="'dessertmine.action'" includeParams="'none'"/>">Dessert MenuMine</a></li>
		 		<li><a class="mainMenu" href="<webwork:url value="'ingredientmine.action'" includeParams="'none'"/>">Savory MenuMine</a></li>
				<li><a class="mainMenu" href="<webwork:url value="'beveragemine.action'" includeParams="'none'"/>">Beverage MenuMine</a></li>
				<li ><a class="mainMenu" href="<webwork:url value="'breakfastmine.action'" includeParams="'none'"/>">Breakfast MenuMine</a></li>
                    </ul>
             
	      
	      </div>
		</td>--%>
			
    			

			<%-- 2006-04-04 This is going away.
			<webwork:if test="menuMineSessionContextWrapper.authorizationBean.justNationalAccountBenchmark">
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'menumineNatlAccountBenchmark.action'" includeParams="'none'"/>">NATIONAL ACCOUNT BENCHMARK</a></td>
    		</webwork:if>    		
    		--%>    		<%--
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'savedQueryList.action'" includeParams="'none'"/>">QUERY MANAGER</a> </td>--%>
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'flavorProfiler.action'" includeParams="'none'"/>">PROFILER</a></td>
    			<!-- <td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'chainStatList.action'" includeParams="'none'"/>">CHAIN STAT </a></td> -->
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'chainMap.action'" includeParams="'none'"/>">CHAIN MAP </a></td>
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'menuBookList.action'" includeParams="'none'"/>">MENUBOOK</a></td>
    			<!-- <td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'menuBookTrendList.action'" includeParams="'none'"/>">MENUBOOK TRENDS </a></td> -->
				<td class="mainMenu" style="width: 100px;"></td>
				<td class="mainMenu" style="width: 100px;"></td>
				
    		<webwork:if test="menuMineSessionContextWrapper.adminRights">
    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'/administrationMenu.action'"  includeParams="'none'"/>">ADMIN</a></td>
    		</webwork:if>
    		<webwork:else>
    			<td class="mainMenu"></td>
    		</webwork:else>
    		

    			<td class="mainMenu"> <a class="mainMenu" href="<webwork:url value="'logout.action'" includeParams="'none'"/>">LOGOUT</a></td>
  			

  			 
  			
  			</tr>
		</table>
		</div>
		
		<!--  -->
		
		</td>
  </tr>
</table>
</div>


</webwork:if>
<webwork:else>
</webwork:else>





<webwork:if test="hasErrors() || hasActionMessages()">
<div id="systemErrors">
	<webwork:if test="hasActionMessages()">
		<h1>Errors</h1>
		<ul>
	    <webwork:iterator value="actionErrors">
	      <li><webwork:property/></li>
	    </webwork:iterator>
		</ul>
	</webwork:if>
	<webwork:if test="hasActionMessages()">
		<h1>Messages</h1>
		<ul>
	    <webwork:iterator value="actionMessages">
	      <li><webwork:property/></li>
	    </webwork:iterator>
		</ul>
	</webwork:if>
</div>
</webwork:if>

