<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>

</head>

<body  >

<%--
<script type="text/javascript" language="javascript">
initOptions("menushareOptions");
</script>
--%>



 <webwork:if test="menuMineGraphOptions.graphByFieldSelected"> 


	<webwork:include page="_trendTableSideBySide.jsp" />

</webwork:if>



</body>
</html>




	