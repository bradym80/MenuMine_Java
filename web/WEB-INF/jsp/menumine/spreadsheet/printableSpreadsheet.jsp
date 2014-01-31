<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>

	  
</head>
<body >


	<webwork:include page="../_menuMineTitle.jsp" />
	
		
		 	

<table border="1" class="results" width="100%" >
	<tr>
		<th  class="resultHeader"> &nbsp; </th>
		<th class="resultHeader">
			<webwork:property value="resultHeader.value1.friendlyName" />
			
		</th>
	
	
	<webwork:if test="resultHeader.value2 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value2.friendlyName" />
			
			
			
		</th>
	</webwork:if>
	<webwork:if test="resultHeader.value3 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value3.friendlyName" />
		</th>
	</webwork:if>
	<webwork:if test="resultHeader.value4 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value4.friendlyName" />
		</th>
	</webwork:if>
	<webwork:if test="resultHeader.value5 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value5.friendlyName" />
		</th>
	</webwork:if>
	<webwork:if test="resultHeader.value6 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value6.friendlyName" />
		</th>
	</webwork:if>
		<webwork:if test="resultHeader.value7 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value7.friendlyName" />
		</th>
	</webwork:if>
	

	<webwork:if test="resultHeader.value8 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value8.friendlyName" />

		</th>
	</webwork:if>
	
	<webwork:if test="resultHeader.value9 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value9.friendlyName" />
		</th>
	</webwork:if>	

	<webwork:if test="resultHeader.value10 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value10.friendlyName" />
		</th>
	</webwork:if>

	<webwork:if test="resultHeader.value11 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value11.friendlyName" />
		</th>
	</webwork:if>

	<webwork:if test="resultHeader.value12 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value12.friendlyName" />
		</th>
	</webwork:if>

	<webwork:if test="resultHeader.value13 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value13.friendlyName" />
		</th>
	</webwork:if>

	<webwork:if test="resultHeader.value14 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value14.friendlyName" />
		</th>
	</webwork:if>

	<webwork:if test="resultHeader.value15 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value15.friendlyName" />
		</th>
	</webwork:if>
	
	</tr>
<webwork:iterator value="wrappedResults" status="mestatus">
	
	<webwork:if test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
		<webwork:set name="displayClass" value="'results_cellA'"/>
	</webwork:if>
	<webwork:else>
		<webwork:set name="displayClass" value="'results_cellB'"/>			
	</webwork:else>
	
	<tr>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="#mestatus.count"/> </td>
	<webwork:if test="resultHeader.value1 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value1Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value2 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value2Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value3 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value3Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value4 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value4Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value5 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value5Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value6 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value6Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value7!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value7Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value8!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value8Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value9!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value9Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value10!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value10Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value11!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value11Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value12!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value12Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value13!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value13Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value14!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value14Clean" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value15!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value15Clean" /></td>
	</webwork:if>
	</tr>
</webwork:iterator>
</table>

	   


</body>
</html>