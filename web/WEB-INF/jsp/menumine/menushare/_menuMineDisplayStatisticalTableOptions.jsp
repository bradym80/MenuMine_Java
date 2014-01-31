<%@ taglib uri="webwork" prefix="webwork" %>

<h3>Menu Share Options</h3>
<webwork:form theme="'simple'" method="'post'" action="'menumineStatisticalTable.action'" name="'menuMineStatisticalTable'">	
<table  >	
	<tr>
 		<td >Group By Field</td>
 		<td >Title</td>		
 		<td >Roll Up | <a href="<webwork:url value="'menumineBuildRollUp.action'" />">Build Roll Up Manager</a></td>	
	</tr>
	<tr>
		<td>
			<webwork:select theme="'simple'"
				name="'menuMineGraphOptions.graphByField'"
				value="menuMineGraphOptions.graphByField" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'false'" />
		</td>
		<td>
	   		<webwork:textfield  theme="'simple'"
	   			name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" />
	 	</td>
		
		<td>
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

		</td>	
	</tr>
	<tr> 
		<td colspan="3">
			<webwork:submit
				theme="'simple'" 
				id="'sub'" name="'submitOptions'" value="'Display Single Table'" />

			<webwork:submit
				theme="'simple'" 
				id="'sub'" name="'submitOptionsAll'" value="'Display Tables For All Fields Selected in Power Search'" />
		</td>

	</tr>

</table>
</webwork:form>

	