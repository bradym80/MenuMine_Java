<%@ taglib uri="webwork" prefix="webwork"%>

<html>
<head>
<title>Modify Saved Query Template</title>
</head>
<body>
<p>
<h2>Modify Saved Query Template</h2>

<webwork:form method="'post'" action="'savedQueryTemplateModify.action'">

				<webwork:textfield size="'100'" 
					label="'Name'"
					name="'targetQuery.name'"
					value="targetQuery.name" />
					
				<webwork:textfield size="'100'" 
					label="'Template Group'"
					name="'targetQuery.templateGroup'"
					value="targetQuery.templateGroup" />
				
					
				<webwork:submit name="'submitQuery'" value="'Save'" />	
				
				<webwork:submit name="'cancelQuery'" value="'Cancel'" />
					
</webwork:form>


</body>
</html>
