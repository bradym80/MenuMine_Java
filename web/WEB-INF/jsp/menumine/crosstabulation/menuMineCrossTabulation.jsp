<%@ taglib uri="webwork" prefix="webwork" %>
<%--<webwork:include page="_menuMineDisplayCrossTabulationOptions.jsp" />
--%>
<script type="text/javascript" language="javascript">
initOptions("crossTabOptions");
</script>
<webwork:if test="menuMineCrossTabulationOptions.fieldsSelected == true"> 



 	<webwork:if test="menuMineDisplayOptions.displayType == 'Download Cross Tab As Excel'"> 
	    	<script type="text/javascript" language="javascript">
	    		javascript:openExcelCrossTab();    		
	    	</script> 
			Click if Excel sheet does not pop up:  
			<a href="<webwork:url value="'crossTabExcel.xls'"/>">View Cross Tabulation as Excel</a><br/>
	</webwork:if>
	
	 <webwork:if test="menuMineDisplayOptions.displayType == 'Cross Tabulation'"> 
	    	   		<webwork:include page="_menuMineCrossTabulationTable.jsp" />
	 </webwork:if>		     
	    

  </webwork:if>	
  <%--
	<webwork:else>
		<webwork:if test="queryExists">	
			<table>
				<tr>
					<td align ="left" class="smallFont">Record Count: <webwork:property value="count" /></td>
				</tr><tr>
					<td class="smallFont">
						Drill down to less then <webwork:property value="reportSizeLimit"/> 
						records to view a Cross Tabulation.
					</td>
				</tr>
			</table>
		</webwork:if>
	</webwork:else>
	
</webwork:if> --%>