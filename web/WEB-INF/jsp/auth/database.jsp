<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head></head>
<body>

<webwork:include page="_adminHeaderMenu.jsp"/> 

<h2>Last Updated</h2>

<webwork:form theme="'simple'" name="'databaseUpdate'" action="'databaseUpdate.action'" method="'post'">
	Database Update Date: <webwork:textfield theme="'simple'" label="'Date'" name="'date'" value="date" />
	<webwork:submit theme="'simple'" value="'Update'" name="'submit'" />
</webwork:form>

</body>
</html>

