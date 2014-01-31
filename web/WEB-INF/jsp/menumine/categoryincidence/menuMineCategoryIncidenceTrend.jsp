<%@ taglib uri="webwork" prefix="webwork" %>
<webwork:set name="isExcel" value="'true'"/>
<webwork:set name="excelFile" value="'/menumineDisplayCategoryIncidenceTrendAsExcel.xls'"/>
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
<html>
<head>
<title>Category Incidence Trend</title>
</head>
<body>
<h2>Category Incidence Trend by Sector, Segment and Year</h2>

<!--<p><a href="<webwork:url value="'menumineDisplayCategoryIncidenceTrendAsExcel.xls'"/>">Export to Excel</a></p>-->

<webwork:set name="displayClass" value="'results_cellB'"/>

<table border="1" class="results">
	<tr>
		<td class="incidenceSector">&nbsp;</td>
		<td class="incidenceSector">2011</td>
		<td class="incidenceSector">2010</td>
		<td class="incidenceSector">2009</td>
		<td class="incidenceSector">2008</td>
		<td class="incidenceSector">2007</td>
		<td class="incidenceSector">2006</td>
		<td class="incidenceSector">2005</td>
		<td class="incidenceSector">2004</td>
		<td class="incidenceSector">2003</td>
		<td class="incidenceSector">2002</td>
		<td class="incidenceSector">2001</td>
		<td class="incidenceSector">2000</td>
		<td class="incidenceSector">1999</td>
		<td class="incidenceSector">1998</td>
		<td class="incidenceSector">1997</td>
		<td class="incidenceSector">1996</td>
	</tr>
	<tr>
		<td class="<webwork:property value="#displayClass"/>"># Records</td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2011.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2010.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2009.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2008.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2007.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2006.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2005.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2004.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2003.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2002.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2001.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2000.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1999.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1998.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1997.recordCount" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1996.recordCount" /></td>
	</tr>
	<tr>
		<td class="<webwork:property value="#displayClass"/>"># Operators</td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2011.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2010.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2009.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2008.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2007.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2006.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2005.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2004.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2003.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2002.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2001.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2000.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1999.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1998.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1997.numberOfChainsInSector" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1996.numberOfChainsInSector" /></td>
	</tr>	
	<tr>
		<td class="<webwork:property value="#displayClass"/>"># Menuing Item</td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2011.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2010.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2009.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2008.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2007.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2006.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2005.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2004.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2003.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2002.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2001.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total2000.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1999.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1998.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1997.numberOfChainsMenuingItems" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="trendTable.trendTotals.total1996.numberOfChainsMenuingItems" /></td>
	</tr>
	<tr>
		<td class="incidenceSector">Operator Incidence</td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2011.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2010.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2009.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2008.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2007.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2006.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2005.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2004.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2003.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2002.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2001.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total2000.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total1999.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total1998.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total1997.categoryIncidence" /></webwork:text></td>
		<td class="incidenceSector"><webwork:text name="'percent.one.places.format'"><webwork:param value="trendTable.trendTotals.total1996.categoryIncidence" /></webwork:text></td>
	</tr>					
	<webwork:iterator value="trendTable.sortedTrendHeaders">
		<webwork:iterator value="sortedTrendItems">
			<tr>
				<td class="<webwork:property value="#displayClass"/>"><webwork:property value="name" /></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2011 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2011"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2010 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2010"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2009 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2009"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2008 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2008"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2007 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2007"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2006 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2006"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2005 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2005"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2004 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2004"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2003 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2003"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2002 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2002"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2001 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2001"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence2000 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence2000"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence1999 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence1999"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence1998 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence1998"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence1997 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence1997"/></webwork:text></webwork:if></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:if test="incidence1996 > 0.0"><webwork:text name="'decimal.one.places.format'">
					<webwork:param value="incidence1996"/></webwork:text></webwork:if></td>
			</tr>
		</webwork:iterator>
		<tr>
			<td class="incidenceSector"><webwork:property value="name" /></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2011"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2010"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2009"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2008"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2007"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2006"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2005"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2004"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2003"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2002"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2001"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence2000"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence1999"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence1998"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence1997"/></webwork:text></td>
			<td class="incidenceSector"><webwork:text name="'decimal.one.places.format'">
				<webwork:param value="incidence1996"/></webwork:text></td>
		</tr>		
	</webwork:iterator>
	
	
</table>

</body>
</html>