<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
</head>
<body>
	<webwork:include page="_menuBookTrendHeader.jsp" />
	<table width="100%" >
		<tr>
			<td align="center">	
				<img src="menuBookTrendGraph.menuminepng?timestamp=<webwork:property value="timestamp" />" alt="Error Building Chart"/>  
			</td>
		</tr>
	</table>

</body>
</html>