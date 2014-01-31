<%@ taglib uri="webwork" prefix="webwork" %>
 

<html><head></head><body>





<h2>Password Help</h2>

<p>Please enter the email address associated with your username and password.

<p>&nbsp;

<webwork:form action="'passwordHelp.action'" method="'post'">

<webwork:textfield label="'Email address'" name="'targetEmail'" value="targetEmail" />

<webwork:submit name="'submitPasswordHelp'" value="'Send Me My Password'" />

</webwork:form>

</body>
</html>


