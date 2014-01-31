<%@ taglib uri="webwork" prefix="webwork" %>


<webwork:form theme="'simple'"method="'POST'" action="postAction" name="'menuMine'">

<table  align="center">
	
	<tr>
		<th  class="chainStatHeader">Profiler</th>
		<th  class="chainStatHeader">Application Focus</th>
		<th  class="chainStatHeader">&nbsp;</th>
		<th  class="chainStatHeader">&nbsp;</th>
	</tr>
	<tr>
		<td>
		<webwork:textfield  theme="'simple'"
	   		 cssClass="'filterFieldsLike'"
	   		 name="'searchString'" 
			 value="searchString" />
		</td>
		
		<webwork:if test="displayType != 'Applications'">
		<td>
			<webwork:select theme="'simple'"
				cssClass="'filterFieldsLike'"
				name="'profileContext.applicationFocus'"
				value="profileContext.applicationFocus" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldListProvider.fields" 
				multiple="'false'" 
				emptyOption="'true'" />		
		
		
		</td>
		</webwork:if>
		
		<td valign="top" align="left">
			<webwork:submit  theme="'simple'" name="'displayType'" value="displayType" />	
		</td>
		<td class="smallFont" valign="bottom">
			<webwork:if test="profileAvailable">
				<a  href="<webwork:url value="'profilerExcel.xls'" />">	
					(Excel)
				</a>
			</webwork:if>
		</td>
	</tr>	
</table>	
</webwork:form>