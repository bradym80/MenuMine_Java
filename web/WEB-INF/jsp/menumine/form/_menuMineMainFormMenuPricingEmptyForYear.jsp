<%@ taglib uri="webwork" prefix="webwork" %>
		<tr>
			<td width="5%">
				&nbsp;
			</td>
			<td class="headerselect">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" name="#currentParam.emptyName" value="#currentParam.empty"/>
				
			</td>
			<td  style="font-size: 9px;">
			<webwork:checkbox theme="'simple'" fieldValue="'true'" name="#currentParam.notEmptyName" value="#currentParam.notEmpty"/>
			</td>
			<td style="font-size: 13px;"><webwork:property value="#currentParam.friendlyName"/></td>
		</tr>