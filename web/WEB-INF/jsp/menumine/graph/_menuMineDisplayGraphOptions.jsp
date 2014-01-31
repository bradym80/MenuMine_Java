<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:form theme="'simple'" method="'post'" action="'menumineGraph.action'" name="'menuMineGraph'">
<h3>Graph Options</h3>
<table>
	<tr>
		<td >Group By Field</td>
		<td >Graph Title</td>
		<td ></td>
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
				emptyOption="'false'"/>
		</td>
		<td>
	   		<webwork:textfield  theme="'simple'"
	   			name="'menuMineGraphOptions.graphTitle'" 
			    value="menuMineGraphOptions.graphTitle" />
	 	</td>
		<td>
			<webwork:submit  theme="'simple'" name="'menuMineGraphOptions.graphByType'" value="'View Pie Graph'" />
			<webwork:submit  theme="'simple'" name="'menuMineGraphOptions.graphByType'" value="'View Bar Graph'" />
		</td>	
	</tr>	

</table>
</webwork:form>


