<%@ taglib uri="webwork" prefix="webwork"%>

<html>
<head>
</head>
<body>
<p>
<h2>Query Templates List</h2>

<p><a href="<webwork:url value="'savedQueryList.action'" />">Saved Query List</a></p>

	<table width="100%" border="1" class="results">
		<tr>
			<th class="resultHeader">Template Group</th>
			<th class="resultHeader">Name</th>
			<th class="resultHeader">Mine</th>
			<th class="resultHeader">Date</th>
			<th></th>
		</tr>
		<webwork:iterator value="savedQueries" status="mestatus">
			<tr class="resultHeader">
				<td><webwork:property value="templateGroup" /></td>
				<td><webwork:property value="name" /></td>
				<td><webwork:property value="mineType" /></td>
				<td><webwork:property value="timestamp" /></td>				
				<td>
					<a href="<webwork:url value="'savedQueryTemplateModify.action'"><webwork:param name="'target'" value="id" /></webwork:url>">Modify</a>
					<a onclick="return confirm('Are you sure?');" href="<webwork:url value="'savedQueryTemplateDelete.action'"><webwork:param name="'target'" value="id" /><webwork:param name="'deleteQuery'" value="'del'" /></webwork:url>">Delete</a>
					
				</td>
			</tr>

		</webwork:iterator>

	</table>

</body>
</html>
