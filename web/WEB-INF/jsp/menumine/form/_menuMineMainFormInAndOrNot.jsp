<%@ taglib uri="webwork" prefix="webwork" %>

<table>
	<tr>
	 <td style="font-size: 9px;">DATA FILTERS (separate by comma)</td>
	</tr>
		<tr>
			<td>
			<webwork:select theme="'simple'"
					cssClass="'filterFieldsPrimary'"
					name="#currentParam.inName"
					value="#currentParam.inValues" 
					list="#currentList" 
					size="'8'"
					multiple="'true'" 
					emptyOption="'false'"/>
			</td>
		</tr>
		<webwork:include page="_menuMineMainFormAndOrNotRow.jsp" />
		
				
		</table>