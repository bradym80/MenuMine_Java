<%@ taglib uri="webwork" prefix="webwork"%>


<h2><webwork:property value="trend2011.fieldEnum.friendlyName" /> Same Store <webwork:property value="trendType" /> Trend</h2>

<p class="smallFont">
	<a href="<webwork:url value="'menumineStatisticalTableV2.action'" />">Show All</a>
	| <a href="<webwork:url value="'menumineStatisticalTable.action'"><webwork:param name="'menuMineGraphOptions.graphByField'" value="fieldEnum.ognlName" /></webwork:url>">Show As Single</a>
	| <a href="<webwork:url value="'menumineChainTrend.action'"/>">Display Chain Trend</a> 
	(<a href="<webwork:url value="'menumineDisplayChainTrendExcel.xls'"/>">Excel</a>)
	| <a href="<webwork:url value="'menumineCuttingEdgeTrend.action'"/>">Display Cutting Edge Trend</a>					
	(<a href="<webwork:url value="'menumineDisplayCuttingEdgeTrendExcel.xls'"/>">Excel</a>)
	</p>
	
<table width="100%">
<tr>
<td width="50%" valign="top" >

<h2>2011</h2>

<table border="1" class="results">
	<tr>
		<th class="resultHeader" width="15px"></th>
		<th class="resultHeader" >Name</th>
		<th class="resultHeader" width="65px">Percent </th>
		<th class="resultHeader" width="65px">Number </th>
	</tr>

	<tr>
		<td class="results_cellB"></td>
		<td class="results_cellB"><webwork:property
			value="trend2011.total.name" /></td>
		<td class="results_cellB"><webwork:text
			name="'decimal.one.places.format'">
			<webwork:param value="trend2011.total.percent" name="" />
		</webwork:text></td>
		<td class="results_cellB"><webwork:property
			value="trend2011.total.numberInSample" /></td>
	</tr>
	<webwork:iterator value="trend2011.rows"
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
		</tr>

	</webwork:iterator>


</table>
</td>


<td width="50%" valign="top">

<h2>2006</h2>

<table border="1" class="results">
	<tr>
		<th class="resultHeader" width="15px"></th>
		<th class="resultHeader" >Name</th>
		<th class="resultHeader" width="65px">Percent </th>
		<th class="resultHeader" width="65px">Number </th>
	</tr>

	<tr>
		<td class="results_cellB"></td>
		<td class="results_cellB"><webwork:property
			value="trend2006.total.name" /></td>
		<td class="results_cellB"><webwork:text
			name="'decimal.one.places.format'">
			<webwork:param value="trend2006.total.percent" name="" />
		</webwork:text></td>
		<td class="results_cellB"><webwork:property
			value="trend2006.total.numberInSample" /></td>
	</tr>
	<webwork:iterator value="trend2006.rows"
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
		</tr>

	</webwork:iterator>


</table>


</td>
</tr>
</table>


<table width="100%">
<tr>
<td width="50%" valign="top" >



<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/
flash/swflash.cab#version=6,0,0,0" WIDTH="400" HEIGHT="420" id="FC_2_3_Bar2D">
<PARAM NAME=movie VALUE="<webwork:url value="'/Charts/FC_2_3_Bar2D.swf'" />">
<PARAM NAME="FlashVars" VALUE="&dataURL=lastStatFusion%2Exml%3FtableKey%3D<webwork:property value="trend2011.fieldEnum.ognlName + '-trend-2011'" />">
<PARAM NAME=quality VALUE=high>
<PARAM NAME=bgcolor VALUE=#FFFFFF>
<param name="wmode" value="transparent"> 
<EMBED src="<webwork:url value="'/Charts/FC_2_3_Bar2D.swf'" />" FlashVars="&dataURL=lastStatFusion%2Exml%3FtableKey%3D<webwork:property value="trend2011.fieldEnum.ognlName + '-trend-2011'" />" quality=high bgcolor=#FFFFFF WIDTH="400" HEIGHT="420" NAME="FC_2_3_Bar2D" TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer" wmode="transparent"></EMBED>
</OBJECT>


</td>
<td width="50%" valign="top">

<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/
flash/swflash.cab#version=6,0,0,0" WIDTH="400" HEIGHT="420" id="FC_2_3_Bar2D">
<PARAM NAME=movie VALUE="<webwork:url value="'/Charts/FC_2_3_Bar2D.swf'" />">
<PARAM NAME="FlashVars" VALUE="&dataURL=lastStatFusion%2Exml%3FtableKey%3D<webwork:property value="trend2006.fieldEnum.ognlName + '%2Dtrend%2D2006'" />">
<PARAM NAME=quality VALUE=high>
<PARAM NAME=bgcolor VALUE=#FFFFFF>
<param name="wmode" value="transparent"> 
<EMBED src="<webwork:url value="'/Charts/FC_2_3_Bar2D.swf'" />" FlashVars="&dataURL=lastStatFusion%2Exml%3FtableKey%3D<webwork:property value="trend2006.fieldEnum.ognlName + '%2Dtrend%2D2006'" />" quality=high bgcolor=#FFFFFF WIDTH="400" HEIGHT="420" NAME="FC_2_3_Bar2D" TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer" wmode="transparent"></EMBED>
</OBJECT>

</td>
</tr>
</table>