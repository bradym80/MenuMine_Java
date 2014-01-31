<%@ taglib uri="webwork" prefix="webwork" %>


	<table>
			<tr>
			<th> Application</th>
			<th># Applications</th>
			<th>Application Share</th>
			<th># Operations Using</th>
			<th># Applications Per Operator</th>
			</tr>
			<webwork:iterator value="applications" status="mestatus">
			
		<webwork:if test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
			<webwork:set name="displayClass" value="'results_cellA'"/>
		</webwork:if>
		<webwork:else>
			<webwork:set name="displayClass" value="'results_cellB'"/>			
		</webwork:else>
			
			<tr>
				<td class="<webwork:property value="#displayClass"/>">
					<webwork:property value="name"/>  
				</td>
				<td  align="left" class="<webwork:property value="#displayClass"/>">
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
	
	