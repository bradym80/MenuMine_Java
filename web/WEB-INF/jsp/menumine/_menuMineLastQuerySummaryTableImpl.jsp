<%@ taglib uri="webwork" prefix="webwork" %>
<table>
<webwork:iterator value="lastQuerySummary" status="mestatus">

	<tr>
		<td>
			<webwork:property value="field.friendlyName"/>
		</td>
		<td>
			<webwork:property value="selection"/>
		</td>
		<td>
			<webwork:property value="typeIn"/>
		</td>
	</tr>
</webwork>


</table>