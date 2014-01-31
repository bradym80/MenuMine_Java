<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head></head>
<body>

<webwork:include page="_adminHeaderMenu.jsp"/> 

<h1>Groups</h1>
<p>

	<a href="<webwork:url value="'/userGroupModify.action'" >
	</webwork:url>">Add Group</a>
<p>

<table>
<webwork:iterator value="groups">
	<tr>
		
		<td><a href="<webwork:url value="'/userGroupModify.action'"  includeParams="'none'">
				<webwork:param name="'target'" value="id" /></webwork:url>"><webwork:property value="name" /></a></td>
		
		<%-- 2006-04-04 RSC Not using anymore.
		<td><a href="<webwork:url value="'/userGroupMembership.action'"  includeParams="'none'">
				<webwork:param name="'target'" value="id" /></webwork:url>">Membership</a></td>
		
		<td><a href="<webwork:url value="'/userGroupRights.action'"  includeParams="'none'">
				<webwork:param name="'target'" value="id" /></webwork:url>">Rights</a></td>
		--%>
	</tr>
	


</webwork:iterator>
</table>
</body>
</html>

