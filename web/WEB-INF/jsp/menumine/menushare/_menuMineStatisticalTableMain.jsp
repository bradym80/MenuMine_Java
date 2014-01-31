<%@ taglib uri="webwork" prefix="webwork"%>

<webwork:set name="isExcel" value="'true'"/>
<webwork:set name="excelFile" value="'/statisticalTableExcel.xls'"/>
<webwork:set name="isAll" value="'true'"/>
<webwork:set name="isTrend" value="'true'"/>
<webwork:set name="isCut" value="'true'"/>
<webwork:set name="isPie" value="'true'"/>
<webwork:set name="isBar" value="'true'"/>
<webwork:if test="chainStat.chainStateCount!=null">	
    <webwork:set name="isMap" value="'true'"/>
</webwork:if>
<webwork:else>
    <webwork:set name="isMap" value="'false'"/>
</webwork:else>

<webwork:include page="../_menuMineTitle.jsp" />
<table>
	<tr>
		<td align="left" class="smallFont">Record Count: <webwork:property
			value="count" /> <!--|
			<a href="<webwork:url value="'statisticalTableExcel.xls'"/>">Export to Excel</a>
			| <a href="<webwork:url value="'menumineStatisticalTableV2.action'" />">Show All</a>
			| <a href="<webwork:url value="'menumineChainTrend.action'"/>">Display Chain Trend</a>		
			| <a href="<webwork:url value="'menumineCuttingEdgeTrend.action'"/>">Display Cutting Edge Trend</a>					
			| <a href="<webwork:url value="'menumineStatisticalTable.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="statisticalTableResults.fieldEnum.ognlName" />
					<webwork:param name="'submitPieGraph'" value="'View Pie'" /></webwork:url>">Pie Chart</a>			
			| <a href="<webwork:url value="'menumineStatisticalTable.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="statisticalTableResults.fieldEnum.ognlName" />
					<webwork:param name="'submitBarGraph'" value="'View Bar'" /></webwork:url>">Bar Graph</a>			
			-->
			</td> 
	</tr>
</table>

<table width="100%">
<tr>
<td width="50%" valign="top" >

<h2><webwork:property value="statisticalTableResults.fieldEnum.friendlyName" /></h2>

<table border="1" class="results">
	<tr>
		<th class="resultHeader" width="15px"></th>
		<th class="resultHeader" >Name</th>
		<th class="resultHeader" width="65px">Percent </th>
		<th class="resultHeader" width="65px">Number </th>
		<%--<th class="resultHeader">Size of Sample</th>--%>
	</tr>

	<tr>
		<td class="results_cellB"></td>
		<td class="results_cellB"><webwork:property
			value="statisticalTableResults.total.name" /></td>
		<td class="results_cellB"><webwork:text
			name="'decimal.one.places.format'">
			<webwork:param value="statisticalTableResults.total.percent" name="" />
		</webwork:text></td>
		<td class="results_cellB"><webwork:property
			value="statisticalTableResults.total.numberInSample" /></td>
		<%--<td class="results_cellB"><webwork:property
			value="statisticalTableResults.total.sizeOfSample" /></td>--%>


	</tr>
	<webwork:iterator value="statisticalTableResults.rows"
		status="mestatus">
		<webwork:if
			test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
			<webwork:set name="displayClass" value="'results_cellA'" />
		</webwork:if>
		<webwork:else>
			<webwork:set name="displayClass" value="'results_cellB'" />
		</webwork:else>



		<tr>
			<td class='<webwork:property value="#displayClass"/>'><webwork:property
				value="#mestatus.count" /></td>

			<td class='<webwork:property value="#displayClass"/>'><webwork:property
				value="nameWordClickable" /></td>
			<td class='<webwork:property value="#displayClass"/>'><webwork:text
				name="'decimal.one.places.format'">
				<webwork:param value="percent" name="" />
			</webwork:text></td>
			<td class='<webwork:property value="#displayClass"/>'><webwork:property
				value="numberInSample" /></td>
			<%--<td class='<webwork:property value="#displayClass"/>'><webwork:property
				value="sizeOfSample" /></td>--%>





		</tr>

	</webwork:iterator>


</table>
</td>
</tr>
</table>