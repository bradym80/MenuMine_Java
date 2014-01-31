<%@ taglib uri="webwork" prefix="webwork" %>
<%--<webwork:include page="_menuMineItemsPerChainMenuingOptions.jsp" />
--%>
<script type="text/javascript" language="javascript">
initOptions("itemsPerChainMenuingOptions");
</script>



		 <webwork:if test="menuMineDisplayOptions.displayType == 'Items Per Chain Menuing'"> 
	    		<webwork:include page="_menuMineItemsPerChainMenuingTable.jsp" />
		 </webwork:if>	
	     
	     
	      <webwork:if test="menuMineDisplayOptions.displayType == 'View Items Per Chain Menuing Sector Graph'"> 
	    		<webwork:include page="_menuMineItemsPerChainMenuingGraph.jsp" />
		 </webwork:if>	
		 
		 <%--
		 <webwork:if test="menuMineDisplayOptions.displayType == 'Download Items Per Chain Menuing As Excel'"> 
	    	<script type="text/javascript" language="javascript">
	    		javascript:openExcelItemsPerChain();    		
	    	</script> 
				Click if Excel sheet does not pop up:  
				<a href="<webwork:url value="'itemsPerChainMenuingExcel.xls'"/>">View Items/Chain Menuing as Excel</a><br/>
		</webwork:if>
		--%>

<%--
	</webwork:if>	
	<webwork:else>
		<webwork:if test="queryExists">	
			<table>
				<tr>
					<td align ="left" class="smallFont">Record Count: <webwork:property value="count" /> |
					<a href="<webwork:url value="'itemsPerChainMenuingExcel.xls'"/>">Export to Excel</a>
					</td>
				</tr><tr>
					<td class="smallFont">
						Drill down to less then <webwork:property value="reportSizeLimit"/> 
						records to view the Items Per Chain Menuing.
					</td>
				</tr>
			</table>
		</webwork:if>
	</webwork:else>
	--%>