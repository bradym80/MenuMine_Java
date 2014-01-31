<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head><title>User Password</title></head>
<body>

<webwork:include page="_adminHeaderMenu.jsp"/> 

<h1>Change Password</h1>

	<webwork:form action="'userModifyPassword.action'">
													 
		<webwork:property value="userParameters.username"/>
		

		<webwork:password  label="'Password'" name="'userParameters.password'" value="userParameters.password" show="'true'"/>

		<webwork:password  label="'Password (Confirm)'" name="'userParameters.passwordConfirm'" value="userParameters.passwordConfirm" show="'true'"/>
	
	
		<webwork:submit name="'submit'" value="'Save'" />

		<webwork:submit name="'cancel'" value="'Cancel'" />
	</webwork:form>
		


</table>
</body>
</html>

