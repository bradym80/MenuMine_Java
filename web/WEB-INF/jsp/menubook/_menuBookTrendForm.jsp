<%@ taglib uri="webwork" prefix="webwork" %>



<form  action="menuBookTrendList.action" method="post" name="menuMine" id="menuMine">
<table  align="center">
	
	<tr>
		<th  class="chainStatHeader">Chain Name</th>
		<th  class="chainStatHeader">Segment</th>
		<th  class="chainStatHeader">Sector</th>
		
	</tr>
	<tr>
		<td>
		<webwork:textfield  theme="'simple'"
	   							 cssClass="'filterFieldsLike'"
	   							 name="'chainStatFilterParameters.operationName'" 
								 value="chainStatFilterParameters.operationName" />
		</td>
		<td>
	 	<webwork:select theme="'simple'"
			cssClass="'filterFieldsPrimary'"
			name="'chainStatFilterParameters.segment'"
			value="chainStatFilterParameters.segment" 
			list="distinctSegments" 
			size="'1'"
			multiple="'false'" 
			emptyOption="'true'"/>
		</td>
		<td>
		 <webwork:select theme="'simple'"
			cssClass="'filterFieldsPrimary'"
			name="'chainStatFilterParameters.sectorName'"
			value="chainStatFilterParameters.sectorName" 
			list="distinctSectorNames" 
			size="'1'"
			multiple="'false'" 
			emptyOption="'true'"/>
		</td>
		<td>	
		< webwork:submit cssClass="'filterButtons'" theme="'simple'" name="'submit'" value="'Search'" />
		</td>
	</tr>	
</table>	
</form>