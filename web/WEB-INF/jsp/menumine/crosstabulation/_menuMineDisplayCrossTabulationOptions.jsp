<%@ taglib uri="webwork" prefix="webwork" %>

<h3>Cross Tabulation Options</h3>
<webwork:form theme="'simple'" method="'post'" action="'menumineCrossTabulation.action'" name="'menuMineCrossTabulation'">
<table >
	<tr>
		<td  >Column Field</td>
		<td>
			<webwork:select theme="'simple'"
				name="'menuMineCrossTabulationOptions.horizontalField'"
				value="menuMineCrossTabulationOptions.horizontalField" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'true'"/>
		</td>
		<td >Row Field</td>
		<td>
			<webwork:select theme="'simple'"
				name="'menuMineCrossTabulationOptions.verticalField'"
				value="menuMineCrossTabulationOptions.verticalField" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'true'"/>
		</td>
		<td >Title
	   		<webwork:textfield  theme="'simple'"	
	   			name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" />
	 	</td>
	</tr>
	<tr>
		<td >Column RollUp</td>
		<td>
			<webwork:select theme="'simple'"
				cssClass="'filterFieldsHistory'"
				name="'menuMineCrossTabulationOptions.horizontalRollUpName'"
				value="menuMineCrossTabulationOptions.horizontalRollUpName"
				list="savedRollUps" 
				listValue="longName"
				listKey="name"
				headerKey="'--'"
				headerValue="'-----No RollUp-----'"
				onchange="'javascript:coordinateGroupByFieldWithSavedRollUp(document.menuMineCrossTabulation[\"menuMineCrossTabulationOptions.horizontalField\"],document.menuMineCrossTabulation[\"menuMineCrossTabulationOptions.horizontalRollUpName\"]);'"/>
	
			
		</td>
		<td >Row RollUp</td>
		<td>
			<webwork:select theme="'simple'"
					cssClass="'filterFieldsHistory'"
					name="'menuMineCrossTabulationOptions.verticalRollUpName'"
					value="menuMineCrossTabulationOptions.verticalRollUpName"
					list="savedRollUps" 
					listValue="longName"
					listKey="name"
					headerKey="'--'"
					headerValue="'-----No RollUp-----'"
					onchange="'javascript:coordinateGroupByFieldWithSavedRollUp(document.menuMineCrossTabulation[\"menuMineCrossTabulationOptions.verticalField\"],document.menuMineCrossTabulation[\"menuMineCrossTabulationOptions.verticalRollUpName\"]);'"/>
	
			
		</td>
		<td >
			<webwork:submit  theme="'simple'" name="'submitOptions'" value="'Display Cross Tab'" />		
		 </td>
		
			</tr>	
	
	
	
	
	
	
	
	
				
</table>
</webwork:form>
