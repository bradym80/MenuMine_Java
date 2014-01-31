<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
	<webwork:include page="_menuMineDisplayAccountBenchJavaScript.jsp" />
</head>
<body >
<webwork:set name="excelFile" value="'/menumineNatlAccountBenchmarkExcel.xls'"/>
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
<webwork:include page="_menuMineDisplayAccountBenchOptions.jsp" />
--%>
<script type="text/javascript" language="javascript">
initOptions(null);
</script>

	<webwork:include page="../_menuMineTitle.jsp" />
	
	
	
	<table>
		<tr>
			<td align ="left" class="smallFont">Record Count: <webwork:property value="count" />
			 <webwork:if test="nationalAccountBenchmarkTableResults != null">	
             	<webwork:set name="isExcel" value="'true'"/>
			
			<!--| <a href="<webwork:url value="'menumineNatlAccountBenchmarkExcel.xls'"/>">Export to Excel</a>-->
			</webwork:if>
            <webwork:else>
            	<webwork:set name="isExcel" value="'false'"/>
            </webwork:else>
			</td>
		</tr>	
	</table>
<webwork:if test="menuMineGraphOptions.graphByFieldSelected"> 

	<webwork:if test="menuMineDisplayOptions.displayType == 'National Account Benchmark Table Graph'"> 
	    <img src="<webwork:url value="imagePath" />" />
	</webwork:if>

		 <webwork:if test="nationalAccountBenchmarkTableResults != null">	
			 <webwork:set name="nabTable" value="nationalAccountBenchmarkTableResults"/>
			 <webwork:include page="_menuMineDisplayAccountBench.jsp" />
		</webwork:if>	



	   </webwork:if>	



<%--   
<script type="text/javascript" language="javascript">
//javascript:updateTarget();
//javascript:updateBenchmark();
</script>--%>
</body>
</html>