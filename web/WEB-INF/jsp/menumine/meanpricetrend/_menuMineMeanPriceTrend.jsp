<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:set name="isExcel" value="'true'"/>
<webwork:set name="excelFile" value="'/meanTrendExcel.xls'"/>
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
<a href="<webwork:url value="'meanTrendExcel.xls'"/>">Export to Excel</a>--></td></tr>	
</table>
<table border="1" class="results" >	
	<tr>
		<th class="resultHeader">&nbsp;  </th>
		<th class="resultHeader"> Name </th>
	
		<th class="resultHeader"> Number in Sample </th>
		<th class="resultHeader" >Mean 2011</th>
		<th class="resultHeader" >Mean 2010</th>
		<th class="resultHeader" >Mean 2009</th>
		<th class="resultHeader" >Mean 2008</th>
		<th class="resultHeader" >Mean 2007</th>
		<th class="resultHeader" >Mean 2006</th>
		<th class="resultHeader" >Mean 2005</th>
		<th class="resultHeader" >Mean 2004</th>

		<th class="resultHeader" >Mean 2003</th>
		<th class="resultHeader" >Mean 2002</th>
		<th class="resultHeader" >Mean 2001</th>
		<th class="resultHeader" >Mean 2000</th>
		<th class="resultHeader" >Mean 1999</th>
		<th class="resultHeader" >Mean 1998</th>
		<th class="resultHeader" >Mean 1997</th>
		<th class="resultHeader" >Mean 1996</th>
		
		</th>

	</tr>


<!-- TOTALS -->
<tr>
		<td class="results_cellB">&nbsp; </td>

		<td class="results_cellB"><webwork:property value="statisticalTableResults.total.name" /></td>

		<td class="results_cellB"><webwork:property value="statisticalTableResults.total.numberInSample" /></td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2011"/>
			</webwork:text>
		</td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2010"/>
			</webwork:text>
		</td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2009"/>
			</webwork:text>
		</td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2008"/>
			</webwork:text>
		</td>
		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2007"/>
			</webwork:text>
		</td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2006"/>
			</webwork:text>
		</td>
		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2005"/>
			</webwork:text>
		</td>
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2004"/>
		</webwork:text>
		</td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2003"/>
		</webwork:text>
		</td>
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2002"/>
		</webwork:text>
		</td>
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2001"/>
		</webwork:text>
		</td>
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice2000"/>
		</webwork:text>
		</td>		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice1999"/>
		</webwork:text>
		</td>
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice1998"/>
		</webwork:text>
		</td>	
		
			<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice1997"/>
		</webwork:text>
		</td>	
		
		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
			<webwork:param value="statisticalTableResults.total.priceData.averagePrice1996"/>
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
			<webwork:if test="priceData.averagePrice2011 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2011"/>
			</webwork:text>
			</webwork:if>
		</td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2010 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2010"/>
			</webwork:text>
			</webwork:if>
		</td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2009 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2009"/>
			</webwork:text>
			</webwork:if>
		</td>
		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2008 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2008"/>
			</webwork:text>
			</webwork:if>
		</td>
		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2007 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2007"/>
			</webwork:text>
			</webwork:if>
		</td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2006 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2006"/>
			</webwork:text>
			</webwork:if>
		</td>
		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2005 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2005"/>
			</webwork:text>
			</webwork:if>
		</td>
		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2004 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2004"/>
			</webwork:text>
			</webwork:if>
		</td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2003 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2003"/>
			</webwork:text>
			</webwork:if>
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2002 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2002"/>
			</webwork:text>
			</webwork:if>
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2001 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2001"/>
			</webwork:text>
			</webwork:if>
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice2000 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice2000"/>
			</webwork:text>
			</webwork:if>
		</td>		
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice1999 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice1999"/>
			</webwork:text>
			</webwork:if>
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice1998 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice1998"/>
			</webwork:text>
			</webwork:if>
		</td>			
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice1997 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice1997"/>
			</webwork:text>
			</webwork:if>
		</td>			
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="priceData.averagePrice1996 != null">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.averagePrice1996"/>
			</webwork:text>
			</webwork:if>
		</td>		

	</tr>
</webwork:iterator>



</table>