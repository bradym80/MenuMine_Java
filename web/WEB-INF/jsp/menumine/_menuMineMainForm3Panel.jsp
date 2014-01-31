<%@page import="org.apache.commons.logging.Log,org.apache.commons.logging.LogFactory" %>
<%@ taglib uri="webwork" prefix="webwork"%>


<div id="mainForm">

		<h1><webwork:property value="mineFields.name" /></h1>




	<webwork:include page="_3panelPowerSearch.jsp" /> 

		<div id="mainFormSummary" class="powerSearchFieldPopup" >
			<p class="popupClose"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>
			<h2>Query Summary</h2>

			<!--<webwork:include page="_menuMineLastQuerySummaryLeftMenuImpl.jsp" />	-->
	
		</div>

		

	
	<webwork:include page="_3panelLinks.jsp" />
	
	<webwork:include page="_3panelReportTypes.jsp" />
	
	<webwork:include page="_3panelDataFilters.jsp" />
	
	<webwork:include page="_3panelQueryManager.jsp" /> 
    
    <webwork:include page="_3panelInstructions.jsp" />
	
    <webwork:include page="_menuMineLastQuerySummaryLeftMenuImpl.jsp" />
    
   
</div>
