<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head></head>
<body>

<webwork:include page="_adminHeaderMenu.jsp"/> 

<h2>Users</h2>


<webwork:form  theme="'simple'" action="'userList.action'" method="'post'" name="'users'" id="'users'">

<table>
	<tr>
		<th></th>
		<th>Status</th>
		<th>Role</th>
		<th>Email Like</th>
		<th>Company Like</th>	
		<th>Sort By</th>	
		<th>&nbsp;</th>
	</tr>
	<tr>
		<td>

	<a href="<webwork:url value="'/userModify.action'" >
	</webwork:url>">Add New User</a>
	</td>
	
		<td>
		 <webwork:select theme="'simple'"
			name="'userListContext.params.userStatus'"
			value="userListContext.params.userStatus" 
			list="{'current','expired'}" 
			size="'1'"
			multiple="'false'" 
			emptyOption="'true'"/>
</td>
		<td>
		 <webwork:select theme="'simple'"
			name="'userListContext.params.roleName'"
			value="userListContext.params.roleName" 
			list="userRoles" 
			listKey="name"
			listValue="friendlyName"
			size="'1'"
			multiple="'false'" 
			emptyOption="'true'"/>
		</td>
		<td><webwork:textfield theme="'simple'" name="'userListContext.params.emailLike'" value="userListContext.params.emailLike" size="'20'" /></td>
		<td><webwork:textfield theme="'simple'" name="'userListContext.params.companyLike'" value="userListContext.params.companyLike" size="'20'" /></td>
		<td>
		 <webwork:select theme="'simple'"
			name="'userListContext.params.sortBy'"
			value="userListContext.params.sortBy" 
			list="#{'username':'Username','expirationDate':'Expiration Date','company':'Company','roleName':'Role'}" 
			size="'1'"
			multiple="'false'" 
			emptyOption="'false'"/>		
		</td>
		<td><webwork:submit theme="'simple'" name="'submit'" value="'Search'" /></td>
	</tr>
</table>

</webwork:form>

<table width="100%">
<tr>
<th>Username</th>
<th>Password</th>
<th>Email</th>
<th>Company</th>
<th>Phone</th>
<th>Expiration Date</th>
<th>Role Name</th>
<th>Actions</th>
</tr>

<webwork:iterator value="users">
	<tr>
		
		<td><a href="<webwork:url value="'/userModify.action'" includeParams="'none'" >
				<webwork:param name="'target'" value="id" /></webwork:url>"><webwork:property value="username" /></a></td>
		<td><webwork:property value="password" /></td>
		<td><webwork:property value="email" /></td>
		<td><webwork:property value="company" /></td>
		<td><webwork:property value="phone" /></td>		
		<td><webwork:property value="expirationDate" /></td>
		<td><webwork:property value="roleName" /></td>		

	<td><a href="<webwork:url value="'/userModifyPassword.action'" includeParams="'none'">
				<webwork:param name="'target'" value="id" /></webwork:url>">Change Password</a></td>
	
	</tr>
	


</webwork:iterator>
</table>


</body>
</html>

