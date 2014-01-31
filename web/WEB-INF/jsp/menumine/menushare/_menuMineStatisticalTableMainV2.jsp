<%@ taglib uri="webwork" prefix="webwork"%>
<webwork:set name="isExcel" value="'true'"/>
<webwork:set name="excelFile" value="'/statisticalTableExcel.xls'"/>
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

<%--
<webwork:include page="../_menuMineTitle.jsp" />
--%>


<table>
	<tr>
		<td align="left" class="smallFont">Record Count: <webwork:property
			value="count" /><%-- |
			<a href="<webwork:url value="'statisticalTableExcel.xls'"/>">Export to Excel</a>--%></td>
	</tr>
</table>




<table width="100%">

<tr>
	<td width="50%" valign="top">

<h2><webwork:property value="fieldEnum.friendlyName" /></h2>

<webwork:if test="menuMineDisplayOptions.displayType != 'Profiler'">
<p><a href="<webwork:url value="'menumineStatisticalTable.action'"><webwork:param name="'menuMineGraphOptions.graphByField'" value="fieldEnum.ognlName" /></webwork:url>">View Detail</a></p>
</webwork:if>

<table border="1" class="results" width="100%">
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
			<webwork:param value="total.percent" name="" />
		</webwork:text></td>
		<td class="results_cellB"><webwork:property
			value="total.numberInSample" /></td>
		<%--<td class="results_cellB"><webwork:property
			value="total.sizeOfSample" /></td>--%>


	</tr>
	<webwork:iterator value="rows"
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

<td width="50%" valign="top">
<!-- JDL 04-24-08 Bug #20 Removing charts from menushare
<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/
flash/swflash.cab#version=6,0,0,0" WIDTH="400" HEIGHT="420" id="FC_2_3_Bar2D">
<PARAM NAME=movie VALUE="<webwork:url value="'/Charts/FC_2_3_Bar2D.swf'" />">
<PARAM NAME="FlashVars" VALUE="&dataURL=lastStatFusion%2Exml%3FtableKey%3D<webwork:property value="fieldEnum.ognlName" />">
<PARAM NAME=quality VALUE=high>
<PARAM NAME=bgcolor VALUE=#FFFFFF>
<param name="wmode" value="transparent"> 
<EMBED src="<webwork:url value="'/Charts/FC_2_3_Bar2D.swf'" />" FlashVars="&dataURL=lastStatFusion%2Exml%3FtableKey%3D<webwork:property value="fieldEnum.ognlName" />" quality=high bgcolor=#FFFFFF WIDTH="400" HEIGHT="420" NAME="FC_2_3_Bar2D" TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer" wmode="transparent"></EMBED>
</OBJECT>
-->
</td>
</tr>
</table>

