<%@ taglib uri="webwork" prefix="webwork" %>
<%--<webwork:include page="_menuMineDisplayAveragePriceTrendOptions.jsp" />
--%>
<script type="text/javascript" language="javascript">
initOptions("medianPriceTrendOptions");
</script>
 <webwork:if test="menuMineGraphOptions.graphByFieldSelected">


	<webwork:if test="menuMineDisplayOptions.displayType == 'Median Price Trend'"> 
	    		<webwork:include page="_menuMineAveragePriceTrend.jsp" />
	</webwork:if>
		<%--
	<webwork:if test="menuMineDisplayOptions.displayType == 'Download Median Price Trend As Excel'"> 
	    	<script type="text/javascript" language="javascript">
	    		javascript:openExcelMedian();    		
	    	</script> 
			Click if Excel sheet does not pop up:  
			<a href="<webwork:url value="'medianTrendExcel.xls'"/>">View Median Trend as Excel</a><br/>
	</webwork:if>
	--%>
	
	<webwork:if test="menuMineDisplayOptions.displayType == 'View Median Trendline'"> 
		 <webwork:include page="_viewMedianPriceTrendLineGraph.jsp" />	                     
	</webwork:if>

	</webwork:if>	

<%--
	<webwork:else>
		<webwork:if test="queryExists">	
			<table>
				<tr>
					<td align ="left" class="smallFont">Record Count: <webwork:property value="count" /> | 
					<a href="<webwork:url value="'medianTrendExcel.xls'"/>">Export to Excel</a></td>
				</tr><tr>
					<td class="smallFont">
						Drill down to less then <webwork:property value="reportSizeLimit"/> 
						records to view a Median Price Trend.
					</td>
				</tr>
			</table>
		</webwork:if>
	</webwork:else>
</webwork:if>	
--%>