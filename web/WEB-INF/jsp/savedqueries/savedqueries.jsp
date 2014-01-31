<%@ taglib uri="webwork" prefix="webwork"%>

<html>
<head>
</head>
<body>
<p>
<h2>Saved Query List</h2>

<webwork:if test="menuMineSessionContextWrapper.menuMineSessionContext.authenticatedUser.user.roleName == 'ADMIN'">
	<p><a href="<webwork:url value="'savedQueryTemplateList.action'" />">Saved Query Template List</a></p>
</webwork:if>
	<table width="100%" border="1" class="results">
		<tr>
			<th class="resultHeader">Name</th>
			<th class="resultHeader">Date</th>
			<th class="resultHeader">User Name</th>
			<th class="resultHeader">Group</th>
			<th class="resultHeader">Permission</th>
			<th></th>

		</tr>
		<webwork:iterator value="savedQueries" status="mestatus">
			<tr class="resultHeader">
				<td><webwork:property value="name" /></td>
				<td><webwork:property value="timestamp" /></td>				
				<td><webwork:property value="userName" /></td>
				<td><webwork:property value="groupName" /></td>
				<td>
					<webwork:if test="permissions == 1">
						User
					</webwork:if>
					<webwork:else>
						Group
					</webwork:else>
				</td>
				<td>
					<a href="<webwork:url value="'savedQueryModify.action'"><webwork:param name="'target'" value="id" /></webwork:url>">Modify</a>
					<a onclick="return confirm('Are you sure?');" href="<webwork:url value="'savedQueryModify.action'"><webwork:param name="'target'" value="id" /><webwork:param name="'deleteQuery'" value="'del'" /></webwork:url>">Delete</a>

<webwork:if test="menuMineSessionContextWrapper.menuMineSessionContext.authenticatedUser.user.roleName == 'ADMIN'">
<a href="<webwork:url value="'convertToTemplate.action'"><webwork:param name="'target'" value="id" /></webwork:url>">Convert to Template</a>

</webwork:if>

				</td>
			</tr>

		</webwork:iterator>

	</table>

</body>
</html>
