<%@ taglib uri="webwork" prefix="webwork" %>
 		 <%-- 
	     Nick 2005-4-4.  This jsp will find the correct display for the data.
	     Felt like a good idea when there were two display types, but is a bit ugly now.
	     Since hasn't rally caused any trouble, it has not been refactored yet.  
	     
	     I would like to make the menumine.jsp a decorator and have the includes 
	     as the "normal" pages.
	     --%>
	    <webwork:if test="menuMineDisplayOptions.displayType == 'Display Spreadsheet'"> 
	    	<webwork:include page="_menuMineDisplayResults.jsp" />
	     </webwork:if>	
	     
	     <%-- 
	      These all require the count to be limited.  If not we have and error 
	      message.
	     --%>
	    <webwork:if test="belowCountLimit == true"> 
	     
	     <webwork:if test="menuMineDisplayOptions.displayType == 'Statistical Table'"> 		
	    		<webwork:include page="_menuMineStatisticalTable.jsp" />
	     </webwork:if>	
	     
	     <webwork:if test="menuMineDisplayOptions.displayType == 'Build Roll Up'"> 		
	    		<webwork:include page="_menuMineBuildRollUpSimple.jsp" />
	     </webwork:if>	
	     
	    
	     
	     <webwork:if test="menuMineDisplayOptions.displayType == 'Cross Tabulation'"> 
	    	   		<webwork:include page="_menuMineCrossTabulationTable.jsp" />
	     </webwork:if>		     
	    
	     <webwork:if test="menuMineDisplayOptions.displayType == 'Category Incidence'"> 
	    		<webwork:include page="_menuMineCategoryIncidenceTable.jsp" />
	     </webwork:if>	
	     <webwork:if test="menuMineDisplayOptions.displayType == 'View Category Incidence Sector Graph'"> 
	    		<webwork:include page="_menuMineCategoryIncidenceGraph.jsp" />
	     </webwork:if>	
	    
	    
	    
	    
	      <webwork:if test="menuMineDisplayOptions.displayType == 'Items Per Chain Menuing'"> 
	    		<webwork:include page="_menuMineItemsPerChainMenuingTable.jsp" />
		 </webwork:if>	
	     
	     
	      <webwork:if test="menuMineDisplayOptions.displayType == 'View Items Per Chain Menuing Sector Graph'"> 
	    		<webwork:include page="_menuMineItemsPerChainMenuingGraph.jsp" />
		 </webwork:if>	
	     
	    
	     
		 <webwork:if test="menuMineDisplayOptions.displayType == 'Median Price Trend'"> 
	    		<webwork:include page="_menuMineAveragePriceTrend.jsp" />
	     </webwork:if>
	     
	     <webwork:if test="menuMineDisplayOptions.displayType == 'Mean Price Trend'"> 
	    		<webwork:include page="_menuMineMeanPriceTrend.jsp" />
	     </webwork:if>	
	     
		 <webwork:if test="menuMineDisplayOptions.displayType == 'Graph'"> 
	    				<webwork:include page="_menuMineGraph.jsp" />
	     </webwork:if>
	     <webwork:if test="menuMineDisplayOptions.displayType == 'Download Excel'"> 
	    	<script type="text/javascript" language="javascript">
	    		javascript:openExcel();    		
	    	</script> 
			Click if Excel sheet does not pop up:  
			<a href="<webwork:url value="'viewExcel.xls'"/>">View Excel</a><br/>
		</webwork:if>

	 	<webwork:if test="menuMineDisplayOptions.displayType == 'Statistical Table As Excel'"> 
	    	<script>
	    		javascript:openExcelStatTable();    		
	    	</script> 
				Click if Excel sheet does not pop up:  
				<a href="<webwork:url value="'statisticalTableExcel.xls'"/>">View Statistical Table as Excel</a><br/>
		</webwork:if>

		<webwork:if test="menuMineDisplayOptions.displayType == 'Download Category Incidence As Excel'"> 
	    	<script>
	    		javascript:openExcelTable("categoryIncidenceExcel.xls");    		
	    	</script> 
				Click if Excel sheet does not pop up:  
				<a href="<webwork:url value="'categoryIncidenceExcel.xls'"/>">View Category Incidence as Excel</a><br/>
		</webwork:if>	
															
		<webwork:if test="menuMineDisplayOptions.displayType == 'Download Items Per Chain Menuing As Excel'"> 
	    	<script>
	    		javascript:openExcelItemsPerChain();    		
	    	</script> 
				Click if Excel sheet does not pop up:  
				<a href="<webwork:url value="'itemsPerChainMenuingExcel.xls'"/>">View Items/Chain Menuing as Excel</a><br/>
		</webwork:if>
	
	 	<webwork:if test="menuMineDisplayOptions.displayType == 'Download Cross Tab As Excel'"> 
	    	<script>
	    		javascript:openExcelCrossTab();    		
	    	</script> 
			Click if Excel sheet does not pop up:  
			<a href="<webwork:url value="'crossTabExcel.xls'"/>">View Cross Tabulation as Excel</a><br/>
		</webwork:if>
		
		
	<webwork:if test="menuMineDisplayOptions.displayType == 'Download Mean Price Trend As Excel'"> 
	    	<script>
	    		javascript:openExcelMean();    		
	    	</script> 
			Click if Excel sheet does not pop up:  
			<a href="<webwork:url value="'meanTrendExcel.xls'"/>">View Mean Trend as Excel</a><br/>
	</webwork:if>

	<webwork:if test="menuMineDisplayOptions.displayType == 'Download Median Price Trend As Excel'"> 
	    	<script>
	    		javascript:openExcelMedian();    		
	    	</script> 
			Click if Excel sheet does not pop up:  
			<a href="<webwork:url value="'medianTrendExcel.xls'"/>">View Median Trend as Excel</a><br/>
	</webwork:if>

	<webwork:if test="menuMineDisplayOptions.displayType == 'View Median Trendline'"> 
		
		 <webwork:include page="_viewMedianPriceTrendLineGraph.jsp" />	
		                     
	</webwork:if>
	<webwork:if test="menuMineDisplayOptions.displayType == 'View Mean Trendline'"> 
	    <webwork:include page="_viewMeanPriceTrendLineGraph.jsp" />
	    
	</webwork:if>
		
	</webwork:if>	
	<webwork:else>
		<webwork:if test="queryExists">	
			<table>
				<tr>
					<td align ="left" class="smallFont">Record Count: <webwork:property value="count" /></td>
					<td class="smallFont">
						Drill down to less then <webwork:property value="reportSizeLimit"/> 
						records to view a Graph, Download as an Excel
						sheet or to view a Distribution Table.
					</td>
				</tr>
			</table>
		</webwork:if>
	</webwork:else>
	   <webwork:if test="queryExists">	
	    <webwork:if test="menuMineDisplayOptions.displayType == 'Error'"> 
	    	
	    	<p>Error Building Spreadsheet. <br/>Possible reasons:
			</p>
			<ol> 
				<li>You've selected too many display fields.  You must select between 1 and 7 fields. </li>  
			</ol>
	    	 
	     </webwork:if>
	    </webwork:if> 