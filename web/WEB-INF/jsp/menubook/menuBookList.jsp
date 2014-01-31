<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
</head>



<body>
<table>
	<tr>
		<td class="smallFont" >
		<a  onclick="javascript:toggle('menuBookHelp');" 
			href="#nowhere">What is MenuBook?</a>
			<div id="menuBookHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink"  onclick="javascript:toggle('menuBookHelp');" >MenuBook allows you to see every current item available from a particular chain all on one screen for the latest year. Both the name of the item and the price is listed.


			</a>
		</div>	

		</td>
	</tr>
</table>
<p>&nbsp;</p>


<webwork:include page="_menuBookForm.jsp" />

<table width="100%">

<tr>
<th class="chainStatHeader" >&nbsp; </th>
<th class="chainStatHeader" >Chain Name</th>
<th class="chainStatHeader" >City</th>
<th class="chainStatHeader" >State</th>
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
			<a href="<webwork:url value="'/menuBook.action'" >
					<webwork:param name="'target'" value="operationName" /></webwork:url>"><webwork:property value="operationName"/> </a>&nbsp;&nbsp;<a href="<webwork:url value="'/menuBookTrend.action'" >
					<webwork:param name="'target'" value="operationName" /></webwork:url>">Trend </a>&nbsp;&nbsp;
            <a href="<webwork:url value="'/chainStatDetail.action'" >
					<webwork:param name="'target'" value="id" /></webwork:url>">Stat </a>&nbsp;&nbsp;
            <webwork:if test="chainStateCount!=null">		
				<a   href="<webwork:url value="'/chainMap.action'" >
					<webwork:param name="'target'" value="operationName" /></webwork:url>" class="javascriptLink">
				<img height="11" src="img/map3.gif" border="0" alt="Display Chain Map"/></a>
			</webwork:if>
			&nbsp;
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:property value="hqCity"/> 
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:property value="hqState"/> 
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