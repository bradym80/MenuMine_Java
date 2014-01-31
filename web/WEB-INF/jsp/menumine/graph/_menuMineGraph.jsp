<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:if test="imagePath != null">
	<img src="<webwork:url value="imagePath" />" alt="MenuMine Graph" />
</webwork:if>
<webwork:else>
	<p>Failed to generate chart.</p>
</webwork:else>
<%--
<img src="viewGraph.menuminepng?target=<webwork:property value="timestamp" />" alt="Error Building Chart"/>  
-->
<%--
	<webwork:if test="submitOptions != null">
	</webwork:if>
	<webwork:else>
		<p>Select a field to Group By, then press the 'Display Graph' button
	</webwork:else>
--%>	 