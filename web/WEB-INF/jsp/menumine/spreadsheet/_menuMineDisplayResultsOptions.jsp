<%@ taglib uri="webwork" prefix="webwork" %>


<webwork:form theme="'simple'" method="'post'" action="'menumineSpreadSheet.action'" name="'menuMineSpreadSheet'">
<h3>Spreadsheet Options</h3>
<table>
	<tr>
		<td >Sort By Field &amp; Direction</td>
		<td >Title</td>	
		<td></td>
	</tr>
	<tr>
		<td>
			<webwork:select theme="'simple'"
				name="'menuMineDisplayOptions.sortBy'"
				value="menuMineDisplayOptions.sortBy" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'false'"/>
			<webwork:select theme="'simple'"
				name="'menuMineDisplayOptions.sortType'"
				value="menuMineDisplayOptions.sortType" 
				list="menuMineDisplayOptions.sortByDirectionOptions" 
				multiple="'false'" 
				emptyOption="'false'"/>
		</td>
	<td>
	   		<webwork:textfield  theme="'simple'"
	   			
	   			name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" />
	 	</td>
		
		<td valign="top" align="left"><webwork:submit theme="'simple'" name="'submitOptions'" value="'Display Spreadsheet'" /></td>		
	</tr>	
</table>
</webwork:form>


