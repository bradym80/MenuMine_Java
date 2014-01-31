<%@ taglib uri="webwork" prefix="webwork" %>

		 <webwork:if test="menuMineDisplayOptions.displayType == 'Category Incidence'"> 
	    		<webwork:include page="_menuMineCategoryIncidenceTable.jsp" />
	     </webwork:if>	
	     <webwork:if test="menuMineDisplayOptions.displayType == 'View Category Incidence Sector Graph'"> 
	    		<webwork:include page="_menuMineCategoryIncidenceGraph.jsp" />
	     </webwork:if>	

