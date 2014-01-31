<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head></head>
<body>

<webwork:include page="_adminHeaderMenu.jsp"/> 

<h1>
Group Member List
</h1>
<webwork:property value="context.userGroup.name" /> Members
<table border="1">
<tr><td>Username</td><td>Email</td><td>Action</td></tr>
	<webwork:iterator value="members">
	<tr>
		
		<td><webwork:property value="username" /></td>
		<td><webwork:property value="email" /></td>
				<td><a href="<webwork:url value="'/removeFromGroup.action'" includeParams="'none'">
					<webwork:param name="'removeTarget'" value="id" /></webwork:url>">Remove From Group</a></td>
	</tr>
	</webwork:iterator>

</table>
<p>
NonMembers
<table border="1">
<tr><td>Username</td><td>Email</td><td>Action</td></tr>
	<webwork:iterator value="nonMembers">
	<tr>
		
		<td><webwork:property value="username" /></td>
		<td><webwork:property value="email" /></td>
			<td><a href="<webwork:url value="'/addToGroup.action'"  includeParams="'none'">
					<webwork:param name="'addTarget'" value="id" /></webwork:url>">Add To Group</a></td>
	</tr>
	</webwork:iterator>

</table>

		


</table>
</body>
</html>

