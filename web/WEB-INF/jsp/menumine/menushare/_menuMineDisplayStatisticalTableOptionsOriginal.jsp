<%@ taglib uri="webwork" prefix="webwork" %>


<table class="menuOptions" width="100%" >	
<tr><td colspan="3">Menu Share Options:</td></tr>
<webwork:form theme="'simple'"method="'POST'" action="'menumineStatisticalTable.action'" name="'menuMineStatisticalTable'">	
	<tr>
	<td class="smallFont" style="white-space: nowrap;" align="left" valign="top" >Group By Field</td>
		
	<td class="smallFont" style="white-space: nowrap;" align="left" valign="top" >Title</td>		
	
	<td class="smallFont" style="white-space: nowrap;" align="left" valign="top" >Roll Up</td>	
	
	</tr>
	<tr>
		<td>
			<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'menuMineGraphOptions.graphByField'"
				value="menuMineGraphOptions.graphByField" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'false'"
				headerKey="'-----Select A Field-----'"
				headerValue="'-----Select A Field-----'"
				onchange="'document.menuMineStatisticalTable.submitOptions[0].click();'"/>
		</td>
		
		
	 	
		<td>
	   		<webwork:textfield  theme="'simple'"
	   			cssClass="'graphFields'"	
	   			name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" />
			    
		
	
		
		
	
		
			    
			    
			    
	 	</td>
		
		<td class="smallFont" style="white-space: nowrap;" align="left" valign="top">
		Current Roll Up: 
		
		
		<webwork:if test="menuMineSessionContextWrapper.rollUpOptions.rollUpElements.size() >0 &&   menuMineSessionContextWrapper.rollUpOptions.name != null && menuMineSessionContextWrapper.rollUpOptions.name.length() >0" >
			<webwork:property value="menuMineSessionContextWrapper.rollUpOptions.name"/>
		</webwork:if>
		<webwork:else>
			None
		</webwork:else>
		</td>	
		
	</tr>
		<tr> 

		<td valign="top" align="left">< webwork:submit  cssClass="'graphFields'" theme="'simple'" id="'sub'" name="'submitOptions'" value="'Display Table'" />	</td>
		
		<td valign="top" align="left">< webwork:submit  cssClass="'graphFields'" theme="'simple'" name="'submitOptions'" value="'Download Table As Excel'" />	</td>	
	
		<td class="smallFont" style="white-space: nowrap;" align="left" valign="top">
		
		<webwork:select theme="'simple'"
					cssClass="'filterFieldsHistory'"
					name="'menuMineGraphOptions.rollUpToLoadName'"
					value="menuMineSessionContextWrapper.rollUpOptions.name"
					list="savedRollUps" 
					listValue="longName"
					listKey="name"
					headerKey="'--'"
					headerValue="'-----No RollUp-----'"
					onchange="'javascript:coordinateGroupByFieldWithSavedRollUp(document.menuMineStatisticalTable[\"menuMineGraphOptions.graphByField\"],document.menuMineStatisticalTable[\"menuMineGraphOptions.rollUpToLoadName\"]);'"/>
		
		 <script type="text/javascript" language="javascript">
		 <!--
		 	function confirmBuildRollUp(url){
				if(confirm("Are you sure you want to build a roll up for the current rollup <webwork:property value="menuMineSessionContextWrapper.rollUpOptions.name"/>?"))
				{
					location.replace(url)
				}
			}
		//-->
		</script>
	 		<%--
			<a class="mainLinks" href="<webwork:url value="'menumineBuildRollUp.action'" />">
				<img  align="bottom" border="0" src="img/build-rollup.gif" alt="build rollup" />
			</a>
			--%>
			<a class="mainLinks" onClick="confirmBuildRollUp('<webwork:url value="'menumineBuildRollUp.action'" />')">
				<img  align="bottom" border="0" src="img/build-rollup.gif" alt="build rollup" />
			</a>
	 	</td>
	
		


	
	</tr>
	</table>
</webwork:form>
	