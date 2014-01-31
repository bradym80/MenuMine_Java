<%@ taglib uri="webwork" prefix="webwork"%>

			<table cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<td><h2>Reports</h2></td>
				</tr>
	<!-- 06-19-08 MJB Removed Text
				<tr>
					<td class="smallFont"
						style="white-space: nowrap; background-color: #CCCCCC;"
						align="left" valign="top"><b>Report Options and Styles</b></td>
				</tr>
-->
						<tr>
							<td>

<table cellpadding="0" cellspacing="0" width="100%">


<tr>
	<td width="100%" class="powerSearchReportName"><a href="javascript:showPopupAtHeight('reportMenuShareOptions', 230);">MenuShare &amp; Graphs</a></td>
</tr>
<tr>
	<td width="100%" class="powerSearchReportName"><a href="javascript:showPopupAtHeight('reportSpreadSheetOptions', 230);">Spreadsheet</a></td>
</tr>
<tr>
	<td width="100%" class="powerSearchReportName"><a href="javascript:showPopupAtHeight('reportMeanPriceTrend', 230);">Price Trends</a></td>
</tr>
<tr>
	<td width="100%" class="powerSearchReportName"><a href="javascript:showPopupAtHeight('reportCategoryIncidence', 230);">Category Incidence</a></td>
</tr>
<tr>
	<td width="100%" class="powerSearchReportName"><a href="javascript:showPopupAtHeight('reportCrossTabulation', 230);">Cross Tabulation</a></td>
</tr>
<tr>
	<td width="100%" class="powerSearchReportName"><a href="<webwork:url value="'menumineNatlAccountBenchmark.action'" />">National Account Benchmark</a></td>
</tr>
<tr>
	<td width="100%" class="powerSearchReportName"><a href="<webwork:url value="'menumineMarketSizeProjector.action'" />">Market Size Projector</a></td>
</tr>

</table>

</td>

</tr>

</table>

<div id="reportSpreadSheetOptions" class="powerSearchReportPopup">

<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

<webwork:form theme="'simple'" method="'post'" action="'menumineSpreadSheet.action'" name="'menuMineSpreadSheet'">
<h3>Spreadsheet Options</h3>

			<p>Sort By Field &amp; Direction <webwork:select theme="'simple'"
				name="'menuMineDisplayOptions.sortBy'"
				value="menuMineDisplayOptions.sortBy" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'false'"/>
			<webwork:select theme="'simple'"
				name="'menuMineDisplayOptions.sortType'"
				value="menuMineDisplayOptions.sortType" 
				list="menuMineDisplayOptions.sortByDirectionOptions" 
				multiple="'false'" 
				emptyOption="'false'"/></p>

		<p>Title
	   			
	   			<webwork:textfield  theme="'simple'" name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" />
</p>
		
		<p><webwork:submit theme="'simple'" name="'submitOptions'" value="'Display Spreadsheet'" /></p>
		
		
</webwork:form>

<p>Select data fields from the blue side bar and the additional fields menu to create your own custom spreadsheet.</p>

	
</div>


<div id="reportCategoryIncidence" class="powerSearchReportPopup">

<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

<h3>Category Incidence</h3>

<webwork:form theme="'simple'"method="'post'" action="'menumineCategoryIncidence.action'" name="'menuMineCatIncidence'">

		<p>Title: <webwork:textfield  theme="'simple'"	
	   			name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" /></p>


 			<p>Collapse Sector Detail:? <webwork:checkbox  theme="'simple'" name="'rollUp'" value="rollUp" fieldValue="'true'"/></p>

		<p>Year:
		<webwork:select theme="'simple'"
			name="'targetYear'"
			value="targetYearString" 
			list="#{
				
				'2011':'2011',
				'2010':'2010',
				'2009':'2009',
				'2008':'2008',
				'2007':'2007',
				'2006':'2006',
				'2005':'2005',
				'2004':'2004',
				'2003':'2003',
				'2002':'2002',
				'2001':'2001',
				'2000':'2000',
				'1999':'1999',
				'1998':'1998',
				'1997':'1997',
				'1996':'1996'
			}" 
			multiple="'false'" 
			emptyOption="'false'" /></p>

<p><webwork:submit theme="'simple'" name="'submitOptions'" value="'Display Category Incidence'" />	</p>

<p><webwork:submit  theme="'simple'" name="'submitOptions'" value="'View Sector Graph'" />	</p>

<p><webwork:submit  theme="'simple'" name="'submitOptionsItems'" value="'Display Items Per Chain Menuing'" />	
<p><webwork:submit  theme="'simple'" name="'submitOptionsItems'" value="'View Sector Graph'" />	

</webwork:form>

<p>Show <a href="<webwork:url value="'menumineCategoryIncidenceTrend.action'" />">Category Incidence Trend</a> table.

<p>Category incidence shows what percentage of Market Sectors and Market Segments use an item, ingredient or flavor.  Statistical table and graph options availble. Items per chain menuing literally shows the number of items per operation that are menuing the item.


</div>

<div id="reportMenuShareOptions" class="powerSearchReportPopup">

<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

<h3>Menu Share Options</h3>
<webwork:form theme="'simple'" method="'post'" action="'menumineStatisticalTable.action'" name="'menuMineStatisticalTable'">	

		<p>Group By Field
			<webwork:select theme="'simple'"
				name="'menuMineGraphOptions.graphByField'"
				value="menuMineGraphOptions.graphByField" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'false'" /></p>

		<p>Title
	   		<webwork:textfield  theme="'simple'" 
	   			name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" /></p>


<p>Roll Up | <a href="<webwork:url value="'menumineBuildRollUp.action'" />">Build Roll Up Manager</a>
			<webwork:if test="savedRollUps != null" >
   			<webwork:select theme="'simple'"
   					cssClass="'filterFieldsHistory'"
   					name="'menuMineGraphOptions.rollUpToLoadName'"
   					value="menuMineSessionContextWrapper.rollUpOptions.name"
   					list="savedRollUps" 
					listValue="longName"
 					listKey="name"
					headerKey="'--'"
   					headerValue="'-----No RollUp-----'"
   					onchange="'javascript:coordinateGroupByFieldWithSavedRollUp(document.menuMineStatisticalTable[\"menuMineGraphOptions.graphByField\"],document.menuMineStatisticalTable[\"menuMineGraphOptions.rollUpToLoadName\"]);'"/>
			</webwork:if>
</p>

<p>			<webwork:submit
				theme="'simple'" 
				id="'sub'" name="'submitOptions'" value="'Display Single Table'" /></p>

<p>			<webwork:submit
				theme="'simple'" 
				id="'sub'" name="'submitOptionsAll'" value="'Display All Current Fields'" /></p>

<p>			<webwork:submit  theme="'simple'" name="'submitPieGraph'" value="'View Pie Graph'" /></p>

<p>			<webwork:submit  theme="'simple'" name="'submitBarGraph'" value="'View Bar Graph'" /></p>


</webwork:form>

<p>Calculates a percentage for a single item relative to all items in a group -- thus if 100 of 1000 cheese items are Mozzarella then Mozzarella has a 10% menu share.  Statistical table and graph options availble.</p>

<p>Chain Trend and Cutting Edge Trend - on the single table view - are "Same Store" comparisons of menu
activity and flavor changes over a consistent set of 350 chains and 110
Cutting Edge restaurants in MenuMine in the years 2004 and 2009.  </p>

</div>



<div id="reportMeanPriceTrend" class="powerSearchReportPopup">

<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

<h3>Mean Price Trend Options</h3>
<webwork:form theme="'simple'" method="'post'" action="'menumineMeanPriceTrend.action'" name="'menuMineMeanPrice'">

			<p>Group By Field
			<webwork:select theme="'simple'"
				name="'menuMineGraphOptions.graphByField'"
				value="menuMineGraphOptions.graphByField" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'false'"
				/></p>

	   		<p>Title <webwork:textfield  theme="'simple'"
	   			name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" /></p>

			<p>Roll Up | <a href="<webwork:url value="'menumineBuildRollUp.action'" />">Build Roll Up Manager</a>
<webwork:if test="savedRollUps != null" >

   			<webwork:select theme="'simple'"
   					cssClass="'filterFieldsHistory'"
   					name="'menuMineGraphOptions.rollUpToLoadName'"
   					value="menuMineSessionContextWrapper.rollUpOptions.name"
   					list="savedRollUps" 
   					listValue="longName"
   					listKey="name"
   					headerKey="'--'"
   					headerValue="'-----No RollUp-----'"
   					onchange="'javascript:coordinateGroupByFieldWithSavedRollUp(document.menuMineStatisticalTable[\"menuMineGraphOptions.graphByField\"],document.menuMineStatisticalTable[\"menuMineGraphOptions.rollUpToLoadName\"]);'"/>
</webwork:if>
</p>

		<p><webwork:submit  theme="'simple'" name="'submitOptions'" value="'Mean Price Trend'" />

		<webwork:submit  theme="'simple'" name="'submitOptions'" value="'Trendline Graph'" /></p>
	
		<p><webwork:submit  theme="'simple'" name="'submitOptionsMedian'" value="'Median Price Trend'" />

		<webwork:submit  theme="'simple'" name="'submitOptionsMedian'" value="'Trendline Graph'" /></p>
	

</webwork:form>

<p>Mean price is calculated for each item displayed in the Menu Share table.  Median price, statistical table and graph options available. </p>



</div>




<div id="reportCrossTabulation" class="powerSearchReportPopup">

<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

<h3>Cross Tabulation Options</h3>
<webwork:form theme="'simple'" method="'post'" action="'menumineCrossTabulation.action'" name="'menuMineCrossTabulation'">
	
		<p>Title
	   		<webwork:textfield  theme="'simple'"	
	   			name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" /></p>

		<p>Column Field 
			<webwork:select theme="'simple'"
				name="'menuMineCrossTabulationOptions.horizontalField'"
				value="menuMineCrossTabulationOptions.horizontalField" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'true'"/></p>

<webwork:if test="savedRollUps != null" >

		<p>Column RollUp <webwork:select theme="'simple'"
				cssClass="'filterFieldsHistory'"
				name="'menuMineCrossTabulationOptions.horizontalRollUpName'"
				value="menuMineCrossTabulationOptions.horizontalRollUpName"
				list="savedRollUps" 
				listValue="longName"
				listKey="name"
				headerKey="'--'"
				headerValue="'-----No RollUp-----'"
				onchange="'javascript:coordinateGroupByFieldWithSavedRollUp(document.menuMineCrossTabulation[\"menuMineCrossTabulationOptions.horizontalField\"],document.menuMineCrossTabulation[\"menuMineCrossTabulationOptions.horizontalRollUpName\"]);'"/></p>

</webwork:if>

		<p>Row Field
			<webwork:select theme="'simple'"
				name="'menuMineCrossTabulationOptions.verticalField'"
				value="menuMineCrossTabulationOptions.verticalField" 
				listKey="ognlName" 
				listValue="friendlyName" 
				list="fieldOptions" 
				multiple="'false'" 
				emptyOption="'true'"/></p>


	
			
<webwork:if test="savedRollUps != null" >

		<p>Row RollUp
		
			<webwork:select theme="'simple'"
					cssClass="'filterFieldsHistory'"
					name="'menuMineCrossTabulationOptions.verticalRollUpName'"
					value="menuMineCrossTabulationOptions.verticalRollUpName"
					list="savedRollUps" 
					listValue="longName"
					listKey="name"
					headerKey="'--'"
					headerValue="'-----No RollUp-----'"
					onchange="'javascript:coordinateGroupByFieldWithSavedRollUp(document.menuMineCrossTabulation[\"menuMineCrossTabulationOptions.verticalField\"],document.menuMineCrossTabulation[\"menuMineCrossTabulationOptions.verticalRollUpName\"]);'"/></p>
	</webwork:if>
			
<p><webwork:submit  theme="'simple'" name="'submitOptions'" value="'Display Cross Tab'" /></p>

</webwork:form>

<p>You may relate any two data fields to determine the relative importance of one within the other.  Statistical table and graph options availble.</p>

</div>