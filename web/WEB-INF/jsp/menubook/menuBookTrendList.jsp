<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
</head>



<body>
<p>&nbsp;</p>

<webwork:include page="_menuBookTrendForm.jsp" />

<table width="100%">

<tr>
<th class="chainStatHeader" >&nbsp; </th>
<th class="chainStatHeader" >Chain Name</th>

<th class="chainStatHeader" >Segment</th>
<th class="chainStatHeader" >Sector</th>


</tr>
	<webwork:iterator value="list" status="mestatus">
	
		<webwork:if test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
			<webwork:set name="displayClass" value="'results_cellA'"/>
		</webwork:if>
		<webwork:else>
			<webwork:set name="displayClass" value="'results_cellB'"/>			
		</webwork:else> 
	
	<tr>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="#mestatus.count"/> </td>
		
		
		<td class="<webwork:property value="#displayClass"/>">
			<a href="<webwork:url value="'/menuBookTrend.action'" >
					<webwork:param name="'target'" value="operationName" /></webwork:url>"><webwork:property value="operationName"/> </a>
		
			
		</td>
		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:property value="segment"/> 
		</td>
				<td class="<webwork:property value="#displayClass"/>">
			<webwork:property value="sectorName"/> 
		</td>
	
		
		
	</tr>
	</webwork:iterator>
</table>


</body>
</html>