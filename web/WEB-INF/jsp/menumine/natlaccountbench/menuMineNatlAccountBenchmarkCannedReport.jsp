<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>

	<webwork:include page="_menuMineDisplayAccountBenchJavaScript.jsp" />
	
	
</head>
<body >
	<webwork:include page="_menuMineDisplayAccountBenchOptions.jsp" />

	<webwork:include page="../_menuMineTitle.jsp" />
	
	
	
	<table>
		<tr>
			<td align ="left" class="smallFont">Record Count: <webwork:property value="count" />
			</td>
		</tr>	
	</table>
	
	
	
	<webwork:if test="belowCountLimit == true"> 
	
		<webwork:if test="menuMineDisplayOptions.displayType == 'National Account Benchmark Table As Excel'"> 
	    	<script type="text/javascript" language="javascript">
	    		javascript:openExcelNABCannedReport();    		
	    	</script> 
			Click if Excel sheet does not pop up:  
			<a href="<webwork:url value="'menumineNatlAccountBenchmarkCannedReportExcel.xls'"/>">View Excel</a><br/>
		</webwork:if>
	<webwork:else>
	
	<webwork:iterator value="nationalAccountBenchmarkCannedReport.cans">
	
	<webwork:if test="nationalAccountBenchmarkCannedReport.cannedSchematic.includeBenchmark">
		<webwork:property value="field.friendlyName"/> Benchmark
		 <webwork:set name="nabTable" value="benchmark"/>
		 <webwork:include page="_menuMineDisplayAccountBench.jsp" />
		 
	</webwork:if >
	<webwork:if test="nationalAccountBenchmarkCannedReport.cannedSchematic.includeBenchmarkTrend">
		 <webwork:property value="field.friendlyName"/>Benchmark Trend
		 <webwork:set name="nabTrend" value="benchmarkTrend"/>
		 <webwork:include page="_menuMineDisplayAccountBenchTrend.jsp" />
	</webwork:if >
	<webwork:if test="nationalAccountBenchmarkCannedReport.cannedSchematic.includeBenchmarkGraph">
		<img src="natlAccountBenchmarkCannedGraph.menuminepng?target=<webwork:property value="field.ognlName" />" alt="Error Building Chart"/>  
	</webwork:if >
	
	
	</webwork:iterator>
	</webwork:else>
	
	</webwork:if>	
	<webwork:else>
			<table>
				<tr>
					<td class="largeFont">
						Limit to less then <webwork:property value="reportSizeLimit"/> 
						records to view a Menu Share.
					</td>
				</tr>
			</table>	
	</webwork:else>
<script type="text/javascript" language="javascript">
//javascript:updateTarget();
//javascript:updateBenchmark();
</script>
</body>
</html>