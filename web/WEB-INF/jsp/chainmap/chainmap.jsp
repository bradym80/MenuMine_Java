<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
<webwork:include page="_chainmapJavaScript.jsp" />
</head>

<body>

<table  align="left" width="200">
	
	<tr>
    <td colspan="2">
        	<webwork:set name="isExcel" value="'true'"/>
            <webwork:set name="excelFile" value="'/chainMapExcel.xls'"/>
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
            <webwork:include page="../menumine/_3panelLinks.jsp" />
        </td>
     </tr><tr>
		<td class="smallFont" align="left">
			<a href="<webwork:url value="'/chainStatList.action'" >
					<webwork:param name="'back'" value="'back'" /></webwork:url>">Back</a>
		</td>
		
	<!--	<td class="smallFont" align="left">
			<a href="<webwork:url value="'/chainMapExcel.xls'" >
				</webwork:url>">Excel</a>
		</td>-->
		<td class="smallFont" align="left">
			<a  onclick="javascript:toggle('chainMapHelp');" 
			   
			href="#nowhere">What is Chain Map?</a>
			
			<div id="chainMapHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink"  onclick="javascript:toggle('chainMapHelp');" >Select a chain and a state/regional concentration map and then a statistical table is created.


			</a>
		</div>	
		</td>		
		

	</tr>
</table>
<h2 align="center">Chain Map</h2>



<webwork:form theme="'simple'"method="'POST'" action="'chainMapSetTargetCollection.action'" name="'chainMapSetTargetCollection'">


<table align="center" width="10%">
<tr>
		<td align="center" class="chainMapLabel">Target Chains</td>
		<td  align="center" class="chainMapLabel">Benchmark Chains</td>
	</tr>
<tr>
<td valign="top" align="center">
	
	<table>
		<tr>
			<td align="center" class="chainMapSubLabel">Sectors</td>
			<td align="center" class="chainMapSubLabel">Chains</td>
		</tr>	
		<tr valign="top">
			<td>
				
				<webwork:select theme="'simple'" 
					cssClass="'graphFields'"
					name="'chainMapWebOptions.targetSectors'"
					value="chainMapWebOptions.targetSectors" 
					list="chainMapWebOptions.targetSectorsOptions"
					listKey="name" 
					listValue="name" 
					size="'4'"
					multiple="'true'" 
					emptyOption="'false'"
					onchange="'javascript:updateTarget();'" />
			</td>
			
			<td rowspan="3" >
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'chainMapWebOptions.targetChains'"
				value="chainMapWebOptions.targetChains" 
				list="chainMapWebOptions.targetChainsOptions" 
				listKey="name" 
				listValue="name" 				
				size="'13'"
				multiple="'true'" 
				emptyOption="'false'"
				/>
			</td>
			
		</tr>
		<tr>
			<td align="center" class="chainMapSubLabel">
				Segments
			</td>
		</tr>
		<tr>
			<td>
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'chainMapWebOptions.targetSegments'"
				value="chainMapWebOptions.targetSegments" 
				list="chainMapWebOptions.targetSegmentsOptions" 
				listKey="name" 
				listValue="name" 				
				size="'6'"
				multiple="'true'" 
				emptyOption="'false'"
				onchange="'javascript:updateTarget();'" 
				/>
			</td>
		</tr>

	</table>
	
</td>		
<!-- Benchmark Options -->	
<td valign="top" align="center">
	<table   align="center"  >
		<tr>
		<tr>
			<td align="center" class="chainMapSubLabel">Chains</td>
			<td align="center" class="chainMapSubLabel">Sectors</td>
		</tr>	
			<td rowspan="3">
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'chainMapWebOptions.benchmarkChains'"
				value="chainMapWebOptions.benchmarkChains" 
				listKey="name" 
				listValue="name" 
				list="chainMapWebOptions.benchmarkChainsOptions" 
				size="'13'"
				multiple="'true'" 
				emptyOption="'false'"
				/>
			</td>
			<td>
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'chainMapWebOptions.benchmarkSectors'"
				value="chainMapWebOptions.benchmarkSectors" 
				listKey="name" 
				listValue="name" 
				list="chainMapWebOptions.benchmarkSectorsOptions"
				size="'4'"
				multiple="'true'" 
				emptyOption="'false'"
				onchange="'javascript:updateBenchmark();'" 
				/>
			</td>			
		</tr>
		<tr>
			<td align="center" class="chainMapSubLabel">
				Segments
			</td>
		</tr>
		<tr>
			<td>
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'chainMapWebOptions.benchmarkSegments'"
				value="chainMapWebOptions.benchmarkSegments" 
				list="chainMapWebOptions.benchmarkSegmentsOptions" 
				listKey="name" 
				listValue="name" 
				size="'6'"
				multiple="'true'" 
				emptyOption="'false'"
				onchange="'javascript:updateBenchmark();'" 
				/>
			</td>
		</tr>
	</table>
</td>
</tr>
<tr>
<td width="100%" class="smallFont" style="white-space: nowrap;" align="right" valign="top">
				<webwork:submit  cssClass="'graphFields'" theme="'simple'" name="'submit'" value="'Display'" />
</td>
</tr>

</table>

</webwork:form>













<table border="1" align="center">
<tr><td align="center" colspan="5" class="chainStatHeader" >Target Chains</td></tr>
<webwork:iterator value="chainMapWebOptions.targetChains" status="mestatus">
	<webwork:if test="#mestatus.modulus(5)==1">
	<tr>
	</webwork:if>
		<td  class="results_cellA">
			<webwork:property/>
		</td>
	<webwork:if test="#mestatus.last">
		<webwork:if test="#mestatus.modulus(5)==0 || #mestatus.count <5">
	</tr>
		</webwork:if>
		<webwork:else>
			<td class="results_cellA" colspan="5-#mestatus.modulus(5)">&nbsp;</td> </tr>
		</webwork:else>
	</webwork:if>
	<webwork:else>
	<webwork:if test="#mestatus.modulus(5)==0">
		</tr>
	</webwork:if>
	</webwork:else>
</webwork:iterator>
</table>


<%--
<div align="center">
	<h2>Chain Map By Census Region</h2> 
	<img align="center" src="chainMapImage.menuminepng?target=<webwork:property value="timestamp" />" alt="Error Building Map"/>  
</div>--%>

<div align="center">
	<h2>Chain Map By Census Region</h2> 
	<img align="center" src="<webwork:url value="mapByCensusPath" />" alt="Error Building Map"/>  
</div>



<table align="center">
	<tr>
		<th colspan="6" class="chainStatHeader">Regional Breakdown</th>
		
	</tr>
	<tr>
		<th class="chainStatHeader">Census Region</th>
		<th class="chainStatHeader">All Chain Count</th>
		<th class="chainStatHeader">All Chain Share(%)</th>
		<th class="chainStatHeader">
		<webwork:if test="target != null && target !=''">
			<webwork:property value="target"/>
		</webwork:if>
		<webwork:else>
		Chain
		</webwork:else>
		Count</th>
		<th class="chainStatHeader">
		<webwork:if test="target != null && target !=''">
			<webwork:property value="target"/>
		</webwork:if>
		<webwork:else>
		Chain
		</webwork:else>
		Share(%)</th>
		<th class="chainStatHeader">Index</th>
	</tr>
	<webwork:iterator value="chainMapTable.regions">
	<tr>
		<td class="results_cellA"><webwork:property value="name"/></td>
		<td class="results_cellA"><webwork:property value="allChainCount"/></td>
		<td class="results_cellA">
			<webwork:text name="'decimal.one.places.format'">
					<webwork:param value="allChainPercent"/>
			</webwork:text>
		</td>
		<td class="results_cellA"><webwork:property value="chainCount"/></td>
		<td class="results_cellA">
			<webwork:text name="'decimal.one.places.format'">
					<webwork:param value="chainPercent"/>
			</webwork:text>
		</td>
		<td class="results_cellA">
			<webwork:text name="'decimal.zero.places.format'">
					<webwork:param value="index"/>
			</webwork:text>
		
		</td>			
	</tr>
	</webwork:iterator>
	<!--
	Totals!
	-->
	<tr>
		<td class="results_cellA"><webwork:property value="chainMapTable.totalCount.name"/></td>
		<td class="results_cellA"><webwork:property value="chainMapTable.totalCount.allChainCount"/></td>
		<td class="results_cellA">
			<webwork:text name="'decimal.one.places.format'">
					<webwork:param value="chainMapTable.totalCount.allChainPercent"/>
			</webwork:text>
		</td>
		<td class="results_cellA"><webwork:property value="chainMapTable.totalCount.chainCount"/></td>
		<td class="results_cellA">
			<webwork:text name="'decimal.one.places.format'">
					<webwork:param value="chainMapTable.totalCount.chainPercent"/>
			</webwork:text>
		</td>
		<td class="results_cellA">
			<webwork:text name="'decimal.zero.places.format'">
					<webwork:param value="chainMapTable.totalCount.index"/>
			</webwork:text>
		
		</td>			
	</tr>
</table>	

<%--
<div align="center">
	<h2>Chain Map By State </h2> 
	<img align="center" src="chainMapImageByState.menuminepng?target=<webwork:property value="timestamp" />" alt="Error Building Map"/>  
</div> --%>

<div align="center">
	<h2>Chain Map By State</h2> 
	<img align="center" src="<webwork:url value="mapByStatePath" />" alt="Error Building Map"/>  
</div>



<table table align="center">
	<tr>
		<th colspan="4" class="chainStatHeader">State Breakdown</th>
		
	</tr>
	<tr>
	
		<th class="chainStatHeader">Name</th>
		<th class="chainStatHeader">
		<webwork:if test="target != null && target !=''">
			<webwork:property value="target"/>
		</webwork:if>
		<webwork:else>
		Chain
		</webwork:else>
		Count
		
		</th>
		<th class="chainStatHeader">
		<webwork:if test="target != null &&target !=''">
			<webwork:property value="target"/>
		</webwork:if>
		<webwork:else>
		Chain
		</webwork:else> Share(%)</th>
		<th class="chainStatHeader">&nbsp;</th>
	</tr>
	<webwork:iterator value="stateIntensityList">
	<tr>
		<td class="results_cellA"><webwork:property value="chainMapTableLineItem.name"/></td>
	
		<td class="results_cellA"><webwork:property value="chainMapTableLineItem.chainCount"/></td>
		<td class="results_cellA">
			<webwork:text name="'decimal.one.places.format'">
					<webwork:param value="chainMapTableLineItem.chainPercent"/>
			</webwork:text>
		</td>
		<td class="Intensity<webwork:property value="myIntensity"/>">&nbsp;</td>
		
			
	</tr>
	</webwork:iterator>
</table>	



</body>
</html>