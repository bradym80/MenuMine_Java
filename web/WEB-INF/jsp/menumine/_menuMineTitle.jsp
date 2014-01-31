<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:if test="menuMineSessionContextWrapper.errorContext.hasErrors()">
<table>
	<webwork:iterator value="menuMineSessionContextWrapper.errorContext.errors" status="mestatus">
	<tr>
		<td>
		  <font color="red"> <webwork:property value="message"/> </font>
		</td>
	</tr>
	</webwork:iterator>
</table>
</webwork:if>
		 
<webwork:if test="menuMineDisplayOptions.title != null">
	<table width="100%"><tr><td align="center"  class="spreadsheetTitle"><webwork:property value="menuMineDisplayOptions.displayType" />: <webwork:property value="menuMineDisplayOptions.title" /></td></tr></table>
</webwork:if>


