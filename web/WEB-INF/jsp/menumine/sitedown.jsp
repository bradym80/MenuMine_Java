<%@ taglib uri="webwork" prefix="webwork" %>
 
 <%@ page import="com.fsrin.menumine.common.util.FileIOUtility" %>
 
<html>
<head>
	<title>MenuMine Site Down</title>
</head>
<body>
<center>
	<br><br>
	<h2>
		<%
		String error = FileIOUtility.getErrorMessage();
		%>
		<%= error %>
	</h2>
	<br><br>
</center>
</body>
</html>