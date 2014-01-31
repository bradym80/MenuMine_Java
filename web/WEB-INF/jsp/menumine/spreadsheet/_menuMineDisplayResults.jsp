<%@ taglib uri="webwork" prefix="webwork" %>



<table border="1" class="results" width="100%" >
	<tr>
		<th  class="resultHeader">&nbsp;  </th>
		<th class="resultHeader">
			<webwork:property value="resultHeader.value1.friendlyName" />
			
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value1.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"	>
					 <img border="0" height="12" width="12"src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value1.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"	>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value1.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value1.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	
	
	<webwork:if test="resultHeader.value2 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value2.friendlyName" />
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value2.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"	>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value2.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"		>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value2.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value2.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
			
			
			
		</th>
	</webwork:if>
	<webwork:if test="resultHeader.value3 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value3.friendlyName" />
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value3.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"		>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value3.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"			>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value3.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value3.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>
	<webwork:if test="resultHeader.value4 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value4.friendlyName" />
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value4.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value4.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value4.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value4.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>
	<webwork:if test="resultHeader.value5 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value5.friendlyName" />
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value5.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value5.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value5.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value5.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>
	<webwork:if test="resultHeader.value6 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value6.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value6.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value6.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value6.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value6.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width='12' src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>
		<webwork:if test="resultHeader.value7 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value7.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value7.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value7.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value7.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value7.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>
	

	<webwork:if test="resultHeader.value8 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value8.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value8.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value8.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value8.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value8.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>
	
	<webwork:if test="resultHeader.value9 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value9.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value9.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value9.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value9.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value9.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>	

	<webwork:if test="resultHeader.value10 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value10.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value10.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value10.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value10.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value10.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>

	<webwork:if test="resultHeader.value11 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value11.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value11.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value11.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value11.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value11.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>


	<webwork:if test="resultHeader.value12 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value12.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value12.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value12.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value12.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value12.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>


	<webwork:if test="resultHeader.value13 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value13.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value13.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value13.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value13.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value13.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')" />
			</a>
		</th>
	</webwork:if>


	<webwork:if test="resultHeader.value14 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value14.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value14.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value14.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value14.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value14.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')"/>
			</a>
		</th>
	</webwork:if>


	<webwork:if test="resultHeader.value15 != null">
		<th class="resultHeader">
			<webwork:property value="resultHeader.value15.friendlyName" />
					<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value15.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'DESC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_down.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineSpreadSheet.action'" >
					<webwork:param name="'menuMineDisplayOptions.sortBy'" value="resultHeader.value15.ognlName" />
					<webwork:param name="'menuMineDisplayOptions.sortType'" value="'ASC'" />
					<webwork:param name="'submitOptions'" value="'Display Spreadsheet'" /></webwork:url>"
					class="javascriptLink"					>
					 <img border="0" height="12" width="12" src="img/arrow_up.png" alt="" />
			</a>
			<a href="<webwork:url value="'/menumineGraph.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="resultHeader.value15.ognlName" />
					<webwork:param name="'menuMineGraphOptions.graphTitle'" value="resultHeader.value15.friendlyName" />
					<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>">
					 <img border="0" height="12" width="12" src="img/pie-chart.png" alt="" onmouseout="UnTip()" onmouseover="Tip('View Pie Chart')" />
			</a>
		</th>
	</webwork:if>
	
	</tr>
<webwork:iterator value="wrappedResults" status="mestatus">
	
	<webwork:if test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
		<webwork:set name="displayClass" value="'results_cellA'"/>
	</webwork:if>
	<webwork:else>
		<webwork:set name="displayClass" value="'results_cellB'"/>			
	</webwork:else>
	
	<tr>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="#mestatus.count"/> </td>
	<webwork:if test="resultHeader.value1 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value1" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value2 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value2" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value3 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value3" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value4 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value4" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value5 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value5" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value6 != null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value6" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value7!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value7" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value8!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value8" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value9!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value9" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value10!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value10" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value11!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value11" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value12!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value12" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value13!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value13" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value14!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value14" /></td>
	</webwork:if>
	<webwork:if test="resultHeader.value15!= null">
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="value15" /></td>
	</webwork:if>

	</tr>
</webwork:iterator>
</table>

