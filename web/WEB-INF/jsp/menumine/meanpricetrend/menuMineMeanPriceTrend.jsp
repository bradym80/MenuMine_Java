<%@ taglib uri="webwork" prefix="webwork" %>
<%--<webwork:include page="_menuMineDisplayMeanPriceTrendOptions.jsp" />
--%>
<script type="text/javascript" language="javascript">
initOptions("meanPriceTrendOptions");
</script>

 <webwork:if test="menuMineGraphOptions.graphByFieldSelected">


	<webwork:if test="menuMineDisplayOptions.displayType == 'Mean Price Trend'"> 
	    		<webwork:include page="_menuMineMeanPriceTrend.jsp" />
	</webwork:if>	


	<webwork:if test="menuMineDisplayOptions.displayType == 'View Mean Trendline'"> 
	    <webwork:include page="_viewMeanPriceTrendLineGraph.jsp" />
	    
	</webwork:if>

</webwork:if>
