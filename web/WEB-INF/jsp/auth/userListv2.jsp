<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>

<script>
<!--
function setCookie(name, value){
	document.cookie=name + "=" + escape(value);
}

function DelCookie(sName)
{
var element=document.getElementById(sName);

	if(element != null){
		
		document.cookie = sName + "=" + escape(sName.Value) + "; expires=Fri, 31 Dec 1999 23:59:59 GMT;";
	
	}

}


function expand(x, y){
	if(y != null)
	{
		y.src="img/collapse.gif";
	}
	
	if(x != null)
	{
		x.style.display='block';
	}
	
}
function collapse(x, y){

	if(x != null)
	{	
		x.style.display='none';
	}
	if(y != null)
	{	
		y.src="img/expand.gif";
	}
	
}
function expand2(x){
	//alert("should be expanding xx" + x + "xx");
	var element=document.getElementById(x);
	//document.write("element is null? " + x + "<br/>");
	var image=document.getElementById(x + "_image");
	//document.write("image is null? " +image + "<br/>");
	if(image != null &&  element != null)
	{
		expand(element,image);
	}
}

function toggle(x){

 	//resetCookies();
	//initialize()

	var element=document.getElementById(x);
	var image=document.getElementById(x + "_image");
	
	if (element.style.display=='block'){
		setCookie(x, '');
		collapse(element, image);
		}
		else {
		setCookie(x, 'true');
		expand(element, image);
		}
	toggleForm(x+"_form");
}
function toggleForm(x){
	
	var element=document.getElementById(x);
	var image=null;
	
	if (element.style.display=='block'){
		//setCookie(x, '');
		collapse(element, image);
	}
	else {
		//setCookie(x, 'true');
		expand(element, image);
	}
		
}


function initialize() {
//document.write("cookies: " + document.cookie);

	var cookies=document.cookie.split(";");
	//document.write("<br/>");		
	
	var elementId = null;
	
	
	for(var i=0; i<cookies.length; i++){
			a=cookies[i];
			aparts=a.split("=");
			//document.write("cookie " + i + " length is " + aparts.length);
			if (aparts.length > 1 && aparts[1] == '') {
				elementId = aparts[0];
				elementId = elementId.replace(" ","");
				
				toggle(elementId);
			}
			
	}
	
	
	
}
function resetCookies() {
//document.write("cookies: " + document.cookie);

	var cookies=document.cookie.split(";");
	//document.write("<br/>");		
	
	var elementId = null;
	
	for(var i=0; i<cookies.length; i++){
			a=cookies[i];
			aparts=a.split("=");
			//document.write("cookie " + i + " length is " + aparts.length);
			if (aparts.length > 1 && aparts[1] == '') {
				elementId = aparts[0];
				elementId = elementId.replace(" ","");
				
				//document.write(elementId);
				DelCookie(elementId);
				
			}
	}
	
	
}

//-->
</script>




</head>
<body>


<p>
<div id="add" style="display:block;">

<a href="#nowhere" onclick="javascript:toggle('add');" >
			Add User
		</a>

</div>&nbsp
		

<table border="0" cellspacing="0" cellpadding="0">
<!--
<tr>

<th>Username</th>
<th>Password</th>
<th>Email</th>
<th>Status</th>
<th>Expiration Date</th>
<th>Role</th>
<th>Actions</th>
</tr>
-->
<tr><td>
<table border="1"  cellspacing="0" cellpadding="0"><tr>
		<td align="center" width="175px">UserName</td>
		<td align="center" width="175px">Password</td>
		<td align="center" width="275px">Email</td>
		
		<td align="center" width="100px">Active</td>
		<td align="center" width="100px">Expiration Date </td>
		<td align="center" width="125px">Role Name</td>
	<td width="125px">
	Actions
	</td>
	</tr></table>
</td></tr>


<tr>
<td>
	<div id="add_form" style="display:none;">
		<webwork:form theme="'simple'" method="'POST'" action="'userModifyFromList.action'" name="'menuMine'">
		<table border="1"  cellspacing="0" cellpadding="0">
			<tr>
				<webwork:hidden theme="'simple'" name="'userParameters.id'" value="id" />
				<td width="175px">
					<webwork:textfield theme="'simple'" label="'Username'" name="'userParameters.username'" value="userParameters.username" />
				</td>
				<td width="175px">
					<webwork:textfield  theme="'simple'" label="'Password'" name="'userParameters.password'" value="userParameters.password" />
				<td width="275px">
					<webwork:textfield  theme="'simple'"  size="'40'" label="'Email Address'" name="'userParameters.email'" value="userParameters.email" />
				</td>
				<td width="100px">
					<webwork:select  theme="'simple'" label="'Active'" name="'userParameters.inactive'" value="userParameters.inactive" list="#{false:'Active', true:'Inactive'}"   emptyOption="'true'"/>
				</td>
				<td width="100px">
					<webwork:textfield  theme="'simple'" size="'9'" label="'Expiration Date'" name="'userParameters.expirationDate'" value="userParameters.expirationDate" />	
				</td>
				<td width="125px">
					<webwork:select  theme="'simple'" label="'User Role'" 
						name="'userParameters.roleName'" 
						value="userParameters.roleName" 
						list="userRoles" 
						listKey="name" 
						listValue="friendlyName" />
				</td>
				<td width="125px">
					<webwork:submit  theme="'simple'" name="'submit'" value="'Save'" />
					<a href="#nowhere" onclick="javascript:toggle('add');" >
						<!--
						<img id="<webwork:property value="#mestatus.count"/>_image"  border="0" src="img/expand.gif" alt="expand" />
						-->
						Cancel
					</a>
				</td>
			</tr>
		</table>
		</webwork:form>
		</div>

</td>
</tr>


<webwork:action name="'userList'" id="list">
</webwork:action>
<webwork:iterator value="#list.users" status="mestatus">

<tr>
	<td>
		<div id="<webwork:property value="#mestatus.count"/>" style="display:block;">
	
	<table border="1"  cellspacing="0" cellpadding="0"><tr>
		<td width="175px"><webwork:property value="username" />
		</td>
		<td width="175px"><webwork:property value="password" />&nbsp;</td>
		<td width="275px"><webwork:property value="email" />&nbsp;</td>
		
		<td  width="100px">
			<webwork:if test="inactive">
				Inactive
			</webwork:if >
			<webwork:else >
				Active
			</webwork:else >&nbsp
		</td>
		<td  width="100px"><webwork:property value="expirationDate" />&nbsp;</td>
		<td width="125px"><webwork:property value="roleName" />&nbsp;</td>
	
	
	
	
	<td width="125px">
	<a href="#nowhere" onclick="javascript:toggle('<webwork:property value="#mestatus.count"/>');" >
						<!--
						<img id="<webwork:property value="#mestatus.count"/>_image"  border="0" src="img/expand.gif" alt="expand" />
						-->
						Edit
					</a>
		<!--			
	<a href="<webwork:url value="'/userModifyPassword.action'" >
				<webwork:param name="'target'" value="id" /></webwork:url>">Change Password</a></td>
	-->
	</td>
	</tr></table>
	</div>
	<div id="<webwork:property value="#mestatus.count"/>_form" style="display:none;">
		<webwork:form theme="'simple'"method="'POST'" action="'userModifyFromList.action'" name="'menuMine'">
		<table border="1"  cellspacing="0" cellpadding="0">
			<tr>
				<webwork:hidden theme="'simple'" name="'userParameters.id'" value="id" />
				<td width="175px">
					<webwork:textfield theme="'simple'" label="'Username'" name="'userParameters.username'" value="username" />
				</td>
				<td width="175px">
					<webwork:textfield  theme="'simple'" label="'Password'" name="'userParameters.password'" value="password" />
				<td width="275px">
					<webwork:textfield  theme="'simple'"  size="'40'" label="'Email Address'" name="'userParameters.email'" value="email" />
				</td>
				<td width="100px">
					<webwork:select  theme="'simple'" label="'Active'" name="'userParameters.inactive'" value="inactive" list="#{false:'Active', true:'Inactive'}"   emptyOption="'true'"/>
				</td>
				<td width="100px">
					<webwork:textfield  theme="'simple'"  size="'9'"  label="'Expiration Date'" name="'userParameters.expirationDate'" value="expirationDate" />	
				</td>
				<td width="125px">
					<webwork:select  theme="'simple'" label="'User Role'" 
						name="'userParameters.roleName'" 
						value="roleName" 
						list="userRoles" 
						listKey="name" 
						listValue="friendlyName" />
				</td>
				<td width="125px">
					<webwork:submit  theme="'simple'" name="'submit'" value="'Save'" />
					<a href="#nowhere" onclick="javascript:toggle('<webwork:property value="#mestatus.count"/>');" >
						<!--
						<img id="<webwork:property value="#mestatus.count"/>_image"  border="0" src="img/expand.gif"/>
						-->
						Cancel
					</a>
				</td>
			</tr>
		</table>
		</webwork:form>
	</div>
	</td>
</tr>
	

</webwork:iterator>



</table>

<webwork:if test="hasErrors()">
<script>
initialize();
</script>
</webwork:if>
<webwork:else>
<script>
 resetCookies();
 </script>
</webwork:else>



</body>
</html>