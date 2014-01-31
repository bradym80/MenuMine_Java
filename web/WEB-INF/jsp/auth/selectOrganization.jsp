<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head></head>
<body>
<p>Organization

<table>
<webwork:iterator value="organizations">
	<tr>
		<td><webwork:property value="nameLong" /></td>
		
		<td><a href="<webwork:url value="'/selectOrganization.action'" >
					<webwork:param name="'target'" value="id" /></webwork:url>">Select</a></td>
	</tr>
</webwork:iterator>
</table>
</body>
</html>
