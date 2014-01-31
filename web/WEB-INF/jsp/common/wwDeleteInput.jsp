<%@ taglib uri="webwork" prefix="webwork" %>
 

<html>
<head><title>Confirm Delete</title></head>
<body>

<h2>Confirm Delete</h2>

<p><webwork:property value="cmmsSessionContext.deleteContext.description" />

<p><webwork:property value="cmmsSessionContext.deleteContext.effect" />

<p>
<webwork:form theme="'simple'" action="'commonDelete.action'" method="'post'">

<webwork:submit theme="'simple'" name="'deleteConfirm'" value="'Yes, delete.'" />

<webwork:submit theme="'simple'" name="'deleteCancel'" value="'Cancel.'" />

</webwork:form>

</body>
</html>