<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:set name="isExcel" value="'true'"/>
            <webwork:set name="excelFile" value="'/categoryIncidenceExcel.xls'"/>
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
<tr><td align ="left" class="smallFont">Record Count: <webwork:property value="count" /> | 
<!--<a href="<webwork:url value="'categoryIncidenceExcel.xls'"/>">Export to Excel</a> |-->

Year:

<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2011'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2011</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2010'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2010</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2009'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2009</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2008'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2008</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2007'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2007</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2006'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2006</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2005'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2005</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2004'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2004</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2003'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2003</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2002'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2002</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2001'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2001</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'2000'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">2000</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'1999'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">1999</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'1998'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">1998</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'1997'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">1997</a>
<a href="<webwork:url value="'menumineCategoryIncidence.action'">
	<webwork:param name="'targetYear'" value="'1996'"/>
	<webwork:param name="'submitOptions'" value="'Submit'"/></webwork:url>">1996</a>


</td></tr>	
</table>
<table border="1" class="results" >	
<tr>
<th>&nbsp;  </th>
<th> # Operators in Segment/Sector </th>
<th> # Operators Menuing Item </th>
<th> % Operators Incidence </th>

</tr>
<tr>
		<td class="incidenceSector"> TOTAL</td>
		<td class="incidenceSector"> <webwork:property value="incidenceTableResults.totals.numberOfChainsInSector"/> </td>
		<td class="incidenceSector"> <webwork:property value="incidenceTableResults.totals.numberOfChainsMenuingItems"/> </td>
		<td class="incidenceSector">
		<webwork:text name="'percent.one.places.format'">
			<webwork:param value="incidenceTableResults.totals.categoryIncidence"/>
		</webwork:text>
		</td>

	</tr>

<webwork:set name="displayClass" value="'results_cellB'"/>
<webwork:iterator value="incidenceTableResults.incidenceSectors" status="mestatus">
	<webwork:if test="!rollUp">
	<webwork:iterator value="incidenceSegments" status="mestatus">

<tr>	
	<td class="<webwork:property value="#displayClass"/>"> <webwork:property value="name"/> </td>
	<td class="<webwork:property value="#displayClass"/>"> <webwork:property value="numberOfChains"/> </td>
	<td class="<webwork:property value="#displayClass"/>"> <webwork:property value="numberOfChainsMenuingItems"/> </td>
	<td class="<webwork:property value="#displayClass"/>">
		<webwork:text name="'decimal.one.places.format'">
			<webwork:param value="categoryIncidence"/>
		</webwork:text>
	 </td>
	 
	
		 
 </tr>
	</webwork:iterator>
		</webwork:if>
	<tr>
		<td class="incidenceSector"> <webwork:property value="name"/> </td>
		<td class="incidenceSector"> <webwork:property value="numberOfChains"/> </td>
		<td class="incidenceSector"> <webwork:property value="numberOfChainsMenuingItems"/> </td>
		<td class="incidenceSector">
		<webwork:text name="'decimal.one.places.format'">
			<webwork:param value="categoryIncidence"/>
		</webwork:text>
		</td>

	</tr>
</webwork:iterator>



</table>