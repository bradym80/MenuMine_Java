<%@ taglib uri="webwork" prefix="webwork"%>

<html>
<head>
<title>Modify Saved Query</title>
</head>
<body>
<p>
<h2>Modify Saved Query</h2>

<webwork:form method="'post'" action="'savedQueryModify.action'">

				<webwork:textfield size="'100'" 
					label="'Name'"
					name="'targetQuery.name'"
					value="targetQuery.name" />
				
				<webwork:if test="menuMineSessionContextWrapper.adminRights">
					<webwork:select 
						label="'Group'"
						name="'targetQuery.groupName'"
						value="targetQuery.groupName" list="groups" listKey="name" listValue="name" />
				</webwork:if> 
				
				<webwork:select 
					label="'Permission'"
					name="'targetQuery.permission'"
					value="targetQuery.permission" list="#{1:'User', 2:'Group'}" /> 
					
				<webwork:submit name="'submitQuery'" value="'Save'" />	
				
				<webwork:submit name="'deleteQuery'" value="'Delete'" />
				
				<webwork:submit name="'cancelQuery'" value="'Cancel'" />
					
</webwork:form>


</body>
</html>
