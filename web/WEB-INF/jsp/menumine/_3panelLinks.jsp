<%@ taglib uri="webwork" prefix="webwork"%>

<div id="yupyup" >
  <table cellspacing="0" cellpadding="0" width="200">
    <tr>
      <td><h2>Data View Options</h2></td>
    </tr>
    <tr>
      <td class="smallFont" align="center">&nbsp;</td>
    </tr>
    <tr>
      <td><table cellpadding="0" cellspacing="0" width="100%">
          <tr>
            <td><webwork:if test="#isExcel == 'true'"> <a href="<webwork:property value="#excelFile"/>"> 
            	<img src="img/export-to-excel.png" border="0" onmouseover="Tip('Export Data to Excel document')" onmouseout="UnTip()"/></a> </webwork:if>
              <webwork:else> <img style="opacity: .25;  filter: alpha(opacity=25); -moz-opacity: 0.25; " src="img/export-to-excel.png" border="0" onmouseover="Tip('Export Data to Excel document<br/>(Not Available)')" onmouseout="UnTip()"/> </webwork:else>
            </td>
            <td>
            	<webwork:if test="#isAll == 'true'"> 
                	<a href="<webwork:url value="'menumineStatisticalTableV2.action'" />">
            		<img src="img/show_all.gif" border="0" onmouseover="Tip('View All Fields')" onmouseout="UnTip()"/></a> 
                </webwork:if>
              	<webwork:else> 
                	<img style="opacity: .25;  filter: alpha(opacity=25); -moz-opacity: 0.25; " src="img/show_all.gif" border="0" onmouseover="Tip('View All Fields<br/>(Not Available)')" onmouseout="UnTip()"/> 
                </webwork:else>
            </td>
            <td>
            	<webwork:if test="#isTrend == 'true'"> <a href="<webwork:url value="'menumineChainTrend.action'"/>">
            	<img src="img/display-chain-trend.gif" border="0" onmouseover="Tip('View Chain Trend')" onmouseout="UnTip()"/></a> </webwork:if>
              <webwork:else> <img style="opacity: .25;  filter: alpha(opacity=25); -moz-opacity: 0.25; " src="img/display-chain-trend.gif" border="0" onmouseover="Tip('View Chain Trend <br/>(Not Available)')" onmouseout="UnTip()"/> </webwork:else>
              </td>
            <td>
            	<webwork:if test="#isCut == 'true'">  <a href="<webwork:url value="'menumineCuttingEdgeTrend.action'"/>">
            	<img src="img/display-cutting-edge-trend.gif" border="0" onmouseover="Tip('View Cutting Edge Trend')" onmouseout="UnTip()"/></a> </webwork:if>
              <webwork:else> <img style="opacity: .25;  filter: alpha(opacity=25); -moz-opacity: 0.25; " src="img/display-cutting-edge-trend.gif" border="0" onmouseover="Tip('View Cutting Edge Trend<br/>(Not Available)')" onmouseout="UnTip()"/> </webwork:else>
             </td>
            <td>
            	<webwork:if test="#isPie == 'true'"> <a href="<webwork:url value="'menumineStatisticalTable.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="statisticalTableResults.fieldEnum.ognlName" />
					<webwork:param name="'submitPieGraph'" value="'View Pie'" /></webwork:url>">
            	<img src="img/pie-chart.png" border="0" onmouseover="Tip('View Pie Chart')" onmouseout="UnTip()"/></a> </webwork:if>
              <webwork:else> <img style="opacity: .25;  filter: alpha(opacity=25); -moz-opacity: 0.25; " src="img/pie-chart.png" border="0" onmouseover="Tip('View Pie Chart<br/>(Not Available)')" onmouseout="UnTip()"/> </webwork:else>
              </td>
            <td>
            	<webwork:if test="#isBar == 'true'"> <a href="<webwork:url value="'menumineStatisticalTable.action'" >
					<webwork:param name="'menuMineGraphOptions.graphByField'" value="statisticalTableResults.fieldEnum.ognlName" />
					<webwork:param name="'submitBarGraph'" value="'View Bar'" /></webwork:url>">
            	<img src="img/bar-graph.png" border="0" onmouseover="Tip('View Bar Chart')" onmouseout="UnTip()"/></a> </webwork:if>
              <webwork:else> <img style="opacity: .25;  filter: alpha(opacity=25); -moz-opacity: 0.25; " src="img/bar-graph.png" border="0" onmouseover="Tip('View Bar Chart<br/>(Not Available)')" onmouseout="UnTip()"/> </webwork:else>
              </td>
            <!-- 2009-07-09 MJB cant get chainmap to work outside of menubook. deleting link on sidebar.
			<td>
            <webwork:if test="#isMap == 'true'"> <a href="<webwork:url value="'/chainMap.action'" >
              <webwork:param name="'target'" value="chainStat.operationName" />
              </webwork:url>">
            	<img src="img/map2.gif" border="0" onmouseover="Tip('View Chain Map')" onmouseout="UnTip()"/></a> </webwork:if>
              <webwork:else> <img style="opacity: .25;  filter: alpha(opacity=25); -moz-opacity: 0.25; " src="img/map2.gif" border="0" onmouseover="Tip('View Chain Map<br/>(Not Available)')" onmouseout="UnTip()"/> </webwork:else>
              </td> -->
          </tr>
        </table></td>
    </tr>
  </table>
</div>
