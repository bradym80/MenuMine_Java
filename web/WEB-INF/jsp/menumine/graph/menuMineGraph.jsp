<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:if test="imagePath != null">
	<img src="<webwork:url value="imagePath" />" alt="MenuMine Graph" />
</webwork:if>
<webwork:else>
	<p>Failed to generate chart.</p>
</webwork:else>
