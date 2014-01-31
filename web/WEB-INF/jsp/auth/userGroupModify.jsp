<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>
</head>
<body>

<webwork:include page="_adminHeaderMenu.jsp"/> 

	<webwork:form action="'userGroupModify.action'">
													 
		<webwork:textfield label="'Name'" name="'userGroupParameters.name'" value="userGroupParameters.name" />

		<webwork:submit name="'submit'" value="'Save'" />
		<webwork:if test="userGroupParameters.id != null">
			<webwork:submit name="'delete'" value="'Delete'" />
		</webwork:if>
		<webwork:submit name="'cancel'" value="'Cancel'" />
	</webwork:form>
		


</table>
</body>
</html>

