<%@ taglib uri="webwork" prefix="webwork" %>

<table >
<tr>
	<td ><h3>Roll Up Options</h3></td>
	<td ><h3>Switch to Saved</h3></td>
	<td ><h3>Save Current As</h3></td>
</tr>	
<tr>
<td>
Current group by:
<STRONG><webwork:property value="menuMineGraphOptions.graphByFieldEnum.friendlyName"/></STRONG></td>
<td >


		<webwork:form theme="'simple'" method="'POST'" 
			action="'selectSavedRollUp.action'" name="'menuMineLoadRollUp'">
 		<webwork:select theme="'simple'"
 					cssClass="'filterFieldsHistory'"
 					name="'selectRollUpName'"
 					value=""
 					list="savedRollUps" 
 					listValue="longName"
 					listKey="name"
 					headerKey="'-----ROLL UP SAVES-----'"
 					headerValue="'-----ROLL UP SAVES-----'"
 					/>
					<%--onchange="'document.menuMineLoadRollUp.submit();'"--%>
 		<webwork:submit  theme="'simple'" name="'submitSave'" value="'Go'" />
		</webwork:form>


</td>
<td >
		<webwork:form theme="'simple'" method="'POST'" 
			action="'saveRollUp.action'" name="'menuMineSavedRollUp'">
		Roll Up Name <webwork:textfield theme="'simple'"  name="'saveName'" value="menuMineSessionContextWrapper.rollUpOptions.name" cssClass="'mediumFont'" />
		
		<webwork:if test="menuMineSessionContextWrapper.adminRights">
			<webwork:select theme="'simple'"
						name="'groupName'" 
						value="menuMineSessionContextWrapper.rollUpOptions.groupName" 
						list="groups" 
						listKey="name" 
						listValue="name" 
						cssClass="'mediumFont'" />
			</webwork:if>
		
		<webwork:submit  theme="'simple'" name="'submitSave'" value="'Save As'" cssClass="'mediumFont'" />
		
		<webwork:if test="menuMineSessionContextWrapper.rollUpOptions.id != null">
		<webwork:submit  theme="'simple'" name="'submitUpdate'" value="'Save'" cssClass="'mediumFont'" />
		</webwork:if>
		
	</webwork:form>
		<webwork:if test="menuMineSessionContextWrapper.rollUpOptions.id">
			 <input type="Button" value="Delete"  onclick="javascript:confirmDelete('<webwork:url value="'deleteRollUp.action'" >
						<webwork:param name="'submitDelete'" value="'Delete'" />
					</webwork:url>'	);" /> 

		</webwork:if>
		</td>
		
	</tr>
</table>