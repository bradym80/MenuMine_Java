<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:set name="isExcel" value="'true'"/>
<webwork:set name="excelFile" value="'/itemsPerChainMenuingExcel.xls'"/>
<webwork:set name="isAll" value="'false'"/>
<webwork:set name="isTrend" value="'false'"/>
<webwork:set name="isCut" value="'false'"/>
<webwork:set name="isPie" value="'false'"/>
<webwork:set name="isBar" value="'false'"/>
<webwork:if test="chainStat.chainStateCount!=null">	
    <webwork:set name="isMap" value="'true'"/>
</webwork:if>
<webwork:else>
    <webwork:set name="isMap" value="'false'"/>
</webwork:else>
<webwork:include page="../_menuMineTitle.jsp" />

<table>
<tr><td align ="left" class="smallFont">Record Count: <webwork:property value="count" /> <!--|
<a href="<webwork:url value="'itemsPerChainMenuingExcel.xls'"/>">Export to Excel</a>--></td></tr>	
</table>
<table border="1" class="results"  width="100%">	
<tr>
<th>&nbsp;  </th>

<th> # Operators Menuing Item </th>
<th> # Items Being Menued </th>
<th> # Items per Chain Menuing </th>
</tr>

	<tr>
		<td class="incidenceSector"> TOTAL </td>
	
		<td class="incidenceSector"> <webwork:property value="incidenceTableResults.totals.numberOfChainsMenuingItems"/> </td>

		<td class="incidenceSector"> <webwork:property value="incidenceTableResults.totals.numberOfItemsBeingMenued"/> </td>
		<td class="incidenceSector"> 
		<webwork:text name="'decimal.one.places.format'">
			<webwork:param value="incidenceTableResults.totals.numberOfItemsPerChainMenued"/>
		</webwork:text>
		</td>
	</tr>




<webwork:set name="displayClass" value="'results_cellB'"/>			

<webwork:iterator value="incidenceTableResults.incidenceSectors" status="mestatus">
	
	<webwork:if test="!rollUp">
		<webwork:iterator value="incidenceSegments" status="mestatus">
	
<tr>	
	<td class="<webwork:property value="#displayClass"/>"> <webwork:property value="name"/> </td>
	<td class="<webwork:property value="#displayClass"/>"> <webwork:property value="numberOfChainsMenuingItems"/> </td>

	 
	<td class="<webwork:property value="#displayClass"/>"> <webwork:property value="numberOfItemsBeingMenued"/> </td>
	<td class="<webwork:property value="#displayClass"/>"> 
		<webwork:text name="'decimal.one.places.format'">
			<webwork:param value="numberOfItemsPerChainMenued"/>
		</webwork:text>
	</td>
		 
 </tr>
	</webwork:iterator>
	</webwork:if>
<tr>	
	<td class="incidenceSector"> <webwork:property value="name"/> </td>
	<td class="incidenceSector"> <webwork:property value="numberOfChainsMenuingItems"/> </td>

	 
	<td class="incidenceSector"> <webwork:property value="numberOfItemsBeingMenued"/> </td>
	<td class="incidenceSector"> 
		<webwork:text name="'decimal.one.places.format'">
			<webwork:param value="numberOfItemsPerChainMenued"/>
		</webwork:text>
	</td>
		 
 </tr>
	</webwork:iterator>
	
</table>

