<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:set name="isExcel" value="'true'"/>
<webwork:set name="excelFile" value="'/medianTrendExcel.xls'"/>
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
<a href="<webwork:url value="'medianTrendExcel.xls'"/>">Export to Excel</a>-->
</td></tr>	
</table>
<table border="1" class="results" >	
	<tr>
		<th class="resultHeader">&nbsp;  </th>
		<th class="resultHeader"> Name </th>
	
		<th class="resultHeader"> Number in Sample </th>
		<th class="resultHeader" >Median 2011</th>
		<th class="resultHeader" >Median 2010</th>
		<th class="resultHeader" >Median 2009</th>
		<th class="resultHeader" >Median 2008</th>
		<th class="resultHeader" >Median 2007</th>
		<th class="resultHeader" >Median 2006</th>
		<th class="resultHeader" >Median 2005</th>
		<th class="resultHeader" >Median 2004</th>

		<th class="resultHeader" >Median 2003</th>
		<th class="resultHeader" >Median 2002</th>
		<th class="resultHeader" >Median 2001</th>
		<th class="resultHeader" >Median 2000</th>
		<th class="resultHeader" >Median 1999</th>
		<th class="resultHeader" >Median 1998</th>
		<th class="resultHeader" >Median 1997</th>
		<th class="resultHeader" >Median 1996</th>
		
		</th>

	</tr>


<!-- TOTALS -->
<tr>
		<td class="results_cellB">&nbsp; </td>

		<td class="results_cellB"><webwork:property value="statisticalTableResults.total.name" /></td>

		<td class="results_cellB"><webwork:property value="statisticalTableResults.total.numberInSample" /></td>
		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2010"/>
		</webwork:text>
		</td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2009"/>
		</webwork:text>
		</td>
		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2008"/>
		</webwork:text>
		</td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2007"/>
		</webwork:text>
		</td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2006"/>
		</webwork:text>
		</td>
		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2005"/>
		</webwork:text>
		</td>
		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2004"/>
		</webwork:text>
		</td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2003"/>
		</webwork:text>
		</td>
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2002"/>
		</webwork:text>
		</td>
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2001"/>
		</webwork:text>
		</td>
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice2000"/>
		</webwork:text>
		</td>		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice1999"/>
		</webwork:text>
		</td>
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice1998"/>
		</webwork:text>
		</td>	
		
			<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice1997"/>
		</webwork:text>
		</td>	
		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.medianPrice1996"/>
		</webwork:text>
		</td>		

	</tr>


<!-- THE DATA -->

<webwork:iterator value="statisticalTableResults.rows" status="mestatus">
	<webwork:if test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
		<webwork:set name="displayClass" value="'results_cellA'"/>
	</webwork:if>
	<webwork:else>
		<webwork:set name="displayClass" value="'results_cellB'"/>			
	</webwork:else>
	
	
	
	<tr>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="#mestatus.count"/> </td>

		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="name" /></td>

		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="numberInSample" /></td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2010"/>
		</webwork:text>
		</td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2009"/>
		</webwork:text>
		</td>
		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2008"/>
		</webwork:text>
		</td>
		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2007"/>
		</webwork:text>
		</td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2006"/>
		</webwork:text>
		</td>
		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2005"/>
		</webwork:text>
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2004"/>
		</webwork:text>
		</td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2003"/>
		</webwork:text>
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2002"/>
		</webwork:text>
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2001"/>
		</webwork:text>
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2000"/>
		</webwork:text>
		</td>		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice1999"/>
		</webwork:text>
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice1998"/>
		</webwork:text>
		</td>	
		
			<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice1997"/>
		</webwork:text>
		</td>	
		
				<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice1996"/>
		</webwork:text>
		</td>		

	</tr>
</webwork:iterator>



</table>