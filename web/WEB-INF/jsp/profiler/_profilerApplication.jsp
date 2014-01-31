<%@ taglib uri="webwork" prefix="webwork" %>
	
	<webwork:set name="displayClass" value="'results_cellA'"/>
	<table >
	<tr>
	
	
	  <td class="<webwork:property value="#displayClass"/>">
	   	# Operators In MenuMine
	   </td>
	  <td class="<webwork:property value="#displayClass"/>">
	   	1409
	   </td>
	</tr>
	<tr>
	   <td class="<webwork:property value="#displayClass"/>">
	   	# Operators Using Ingredient
	   </td>
	    <td class="<webwork:property value="#displayClass"/>">
	   	<webwork:property value="bigPicture.numberOfOperationsUsing"/> 
	   </td>
	   </tr>
	<tr>
	   <td class="<webwork:property value="#displayClass"/>">
	   	Ingredient Penetration
	   </td>
	   <td class="<webwork:property value="#displayClass"/>">
	   		<webwork:text name="'percent.one.places.format'">
				<webwork:param value="bigPicture.operationPenetration"/>
			</webwork:text>
	   </td>	
	</tr>
	<tr>
	  <td class="<webwork:property value="#displayClass"/>">
	   	Total Applications
	   </td>
	   <td class="<webwork:property value="#displayClass"/>">
	   	<webwork:property value="bigPicture.totalApplications"/> 
	   </td>	
	</tr>
	<tr>
	   <td class="<webwork:property value="#displayClass"/>">
	   	Applications Per Operator
	   </td>
	   <td class="<webwork:property value="#displayClass"/>">
	   	   <webwork:text name="'decimal.one.places.format'">
				<webwork:param value="bigPicture.numberOfApplicationsPerOperator"/>
		 </webwork:text>
	   </td>	
	</tr>
	</table>
	
	
	
	
	<table>
	<tr>
		<th>Application</th>
		<th># Applications</th>
		<th>Application Share</th>
		<th># Operations Using</th>
		<th># Applications Per Operator</th>
	</tr>
	<webwork:iterator value="applications" status="mestatus">
	<tr>
		<webwork:if test="#mestatus.modulus(6) <= 3 && #mestatus.modulus(10) != 0">
			<webwork:set name="displayClass" value="'results_cellA'"/>
		</webwork:if>
		<webwork:else>
			<webwork:set name="displayClass" value="'results_cellB'"/>			
		</webwork:else>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:property value="name"/> 
		</td>		
		
		<td align="left" class="<webwork:property value="#displayClass"/>">
			<webwork:property value="numberOfApplications"/> 
		</td>
		
		<td  align="left" class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'percent.one.places.format'">
				<webwork:param value="applicationShare"/>
			 </webwork:text>
		</td>
		
		<td  align="left" class="<webwork:property value="#displayClass"/>">
			<webwork:property value="numberOfOperationsUsing"/> 
		</td>
		
		<td  align="left" class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'decimal.one.places.format'">
				<webwork:param value="numberOfApplicationsPerOperator"/>
			 </webwork:text>
		</td>
		
	</tr>
	
	</webwork:iterator>
	</table>

	<webwork:iterator value="tables" >

	<webwork:include page="../menumine/menushare/_menuMineStatisticalTableMainV2.jsp" />

	</webwork:iterator>
