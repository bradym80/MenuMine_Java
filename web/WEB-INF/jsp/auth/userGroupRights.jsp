<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head></head>
<body>

<webwork:include page="_adminHeaderMenu.jsp"/> 

<h1>Group Rights List</h1>

<h2>Group: <webwork:property value="userModifyContext.userGroup.name" /></h2>


<p>
<webwork:property value="context.userGroup.name" /> Rights
<table>
<tr>
<td valign="top">

	<table border="1">
		<tr><td>Name</td><td>Action</td></tr>
			<webwork:iterator value="rights">
			<tr>
		
				<td><webwork:property value="rightCode" /></td>
		
				<td><a href="<webwork:url value="'/removeRightFromGroup.action'"  includeParams="'none'">
					<webwork:param name="'removeTarget'" value="id" /></webwork:url>">Remove From Group</a></td>
			</tr>
				</webwork:iterator>

			</table>
</td>

<td valign="top">
Other Rights
<table border="1">
<tr><td>Name</td><td>Action</td></tr>
	<webwork:iterator value="nonRights">
	<tr>
		
		<td><webwork:property value="actionName" /></td>
		
			<td><a href="<webwork:url value="'/addRightToGroup.action'"  includeParams="none">
					<webwork:param name="'addTarget'" value="actionName" /></webwork:url>">Add To Group</a></td>
	</tr>
	</webwork:iterator>

</table>

		


</table>

</td>
</tr>
</table>
</body>
</html>

