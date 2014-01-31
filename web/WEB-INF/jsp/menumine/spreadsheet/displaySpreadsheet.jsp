<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>

	  
</head>
<body >
<webwork:set name="isExcel" value="'true'"/>
<webwork:set name="excelFile" value="'/viewExcel.xls'"/>
<webwork:set name="isAll" value="'true'"/>
<webwork:set name="isTrend" value="'true'"/>
<webwork:set name="isCut" value="'true'"/>
<webwork:set name="isPie" value="'true'"/>
<webwork:set name="isBar" value="'true'"/>
<webwork:if test="chainStat.chainStateCount!=null">	
    <webwork:set name="isMap" value="'true'"/>
</webwork:if>
<webwork:else>
    <webwork:set name="isMap" value="'false'"/>
</webwork:else>
<script type="text/javascript" language="javascript">
initOptions("spreadsheetOptions");
</script>

	<webwork:include page="../_menuMineTitle.jsp" />
	<p align="center">Select any single word in the table below to filter your Data Set.</p>
	<webwork:if test="menuMineSessionContextWrapper.firstQuerySent">
	
		<p class="smallFont">Record Count: <webwork:property value="count" /> 
	<!--	|	<a href="<webwork:url value="'viewExcel.xls'"/>">Export to Excel</a> -->
		|	<a target="_blank" href="<webwork:url value="'printableSpreadSheet.action'"/>">Full Screen / Printable</a>
		</p>
		
		 	
		 <webwork:include page="_menuMineDisplayResults.jsp" />
	   
	   </webwork:if>

</body>
</html>