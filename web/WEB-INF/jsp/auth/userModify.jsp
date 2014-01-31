<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>
<title>User Modify</title>
<script type="text/javascript" src="<webwork:url value="'/js/gen_validatorv2.js'" />"></script>  

<script type="text/javascript" language="javascript">

function getRandomString(fieldName) {

	var element = document.getElementById(fieldName);

	if (element == null) {
		alert("couldn't find" + fieldName);
		return '';
	}



var choice = "123456789abcdefghkmnopqrstuvwxyzABCDEFGHIJKMNPQRSTUVWXTZ";
var size_of_password = 8;
var password = '';
for (var i=0; i<size_of_password; i++) {
  var rnd = Math.floor(Math.random() * choice.length);
  password += choice.substring(rnd,rnd+1);
}

	element.value = password;
}

</script>


</head>
<body>
<webwork:include page="_adminHeaderMenu.jsp"/> 

<table width="100%">

<tr>
<td width="50%" valign="top">

<h2>User Add/Modify</h2>

<p>Important: remember to <a href="<webwork:url value="'userGroupList.action'" />">add the user group</a> before creating a new user.

	<webwork:form name="'userModify'" action="'userModify.action'">

		<webwork:select label="'Company'" 
			name="'userParameters.company'" 
			value="userParameters.company"													 
			list="userGroups"
			listKey="name"
			listValue="name"
			emptyOption="'true'" />

		<webwork:textfield label="'First Name'" name="'userParameters.firstName'" value="userParameters.firstName" />

		<webwork:textfield label="'Last Name'" name="'userParameters.lastName'" value="userParameters.lastName" />

		<webwork:textfield label="'Username'" name="'userParameters.username'" value="userParameters.username" />

		<webwork:textfield  label="'Password'" name="'userParameters.password'" value="userParameters.password" />

		<webwork:textfield label="'Email Address'" name="'userParameters.email'" value="userParameters.email" />
	
		<webwork:textfield label="'Expiration Date'" name="'userParameters.expirationDate'" value="userParameters.expirationDate" />
	
		<webwork:textfield label="'Street (1)'" name="'userParameters.street1'" 
			value="userParameters.street1" />

		<webwork:textfield label="'Street (2)'" name="'userParameters.street2'" 
			value="userParameters.street2" />

		<webwork:textfield label="'City'" name="'userParameters.city'" 
			value="userParameters.city" />

		<webwork:textfield label="'State'" name="'userParameters.state'" 
			value="userParameters.state" />

		<webwork:textfield label="'Zip'" name="'userParameters.zip'" 
			value="userParameters.zip" />

		<webwork:textfield label="'Phone'" name="'userParameters.phone'" 
			value="userParameters.phone" />

	
		<webwork:select label="'User Role'" 
			name="'userParameters.roleName'" 
			value="userParameters.roleName" 
			list="userRoles" 
			listKey="name" 
			listValue="friendlyName" />
			
		<webwork:select label="'Active'" name="'userParameters.inactive'" value="userParameters.inactive" list="#{false:'Yes', true:'No'}"   emptyOption="'true'"/>
	
		<webwork:textarea label="'Comments'" name="'userParameters.comments'" value="userParameters.comments" rows="'10'" cols="'40'"/>
		
	
		<webwork:submit name="'submit'" value="'Save'" />
		<webwork:if test="userParameters.id != null">
		<webwork:submit name="'delete'" value="'Delete'" />
		</webwork:if>
		<webwork:submit name="'cancel'" value="'Cancel'" />
	</webwork:form>

<SCRIPT language="JavaScript">
var frmvalidator  = new Validator("userModify");
frmvalidator.addValidation("userParameters.username","req","Please enter a username (no spaces).");
frmvalidator.addValidation("userParameters.username","alnum");
frmvalidator.addValidation("userParameters.email","req","Please enter your email address");
frmvalidator.addValidation("userParameters.email","email");
frmvalidator.addValidation("userParameters.expirationDate", "req");
</script>		

<p><a href="#" onclick="javascript:getRandomString('userModify_userParameters.password');">Generate random password.</a></p>
<p>(Don't like the password it generated?  Click the link again for another.)</p>

</td>
<td width="50%">

<h3>Preferences</h3>

<table>
<tr>
	<th>Key</th>
	<th>Value</th>
</tr>
<webwork:iterator value="userPreferences">
	<tr>
		<td><webwork:property value="key" /></td>
		<td><webwork:property value="value" /></td>
	</tr>
</webwork:iterator>
</table>
	



<h3>Recent Logins</h3>

<table>
<tr>
	<th>Timestamp</th>
	<th>Type</th>
</tr>
<webwork:iterator value="userLoginHistory">
	<tr>
		<td><webwork:property value="timestamp" /></td>
		<td><webwork:property value="type" /></td>
	</tr>
</webwork:iterator>
</table>

</td>
</tr>

</table>
</body>
</html>

