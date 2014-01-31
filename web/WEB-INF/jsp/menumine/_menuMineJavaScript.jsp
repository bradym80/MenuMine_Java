<%@ taglib uri="webwork" prefix="webwork" %>
<script type="text/javascript" language="javascript" src="<webwork:url value="'/js/menumine-2006-04-04.js'" />"></script>

<script type="text/javascript" language="javascript" >
<!--
 
function coordinateGroupByFieldWithSavedRollUp(graphByField, rollUp)
{
	var rollToFieldMap = ["",<webwork:iterator value="savedRollUps" status="mestatus">
			<webwork:if test="#mestatus.count!=1">
			,
			</webwork:if>
			"<webwork:property value="targetFieldName"/>"
		</webwork:iterator>];

	
	graphByFieldName =rollToFieldMap[rollUp.selectedIndex];
	

		for(i = 0; i <graphByField.options.length; ++i )
		{
			
			if(graphByField.options[i].value==graphByFieldName)
			{
		 		graphByField.options[i].selected=true;
			}
		}
}
//-->
</script>