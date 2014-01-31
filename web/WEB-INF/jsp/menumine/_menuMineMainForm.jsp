<%@ taglib uri="webwork" prefix="webwork"%>
<table>

	<tr>
		<td width="%100">

		<div id="mainFormDiv" style="display:block; ">







		<table cellspacing="0" cellpadding="0">
			<tr>
				<td align="center" class="spreadsheetTitle"><webwork:property
					value="mineFields.name" /></td>
			</tr>
				<tr>
					<td><!-- RSC 2006-01-20 -->
			<webwork:form theme="'simple'" method="'post'"
				action="'menumine.action'" name="'menuMineHist'"  >
		<webwork:select theme="'simple'"
					cssClass="'filterFieldsHistory'"
					name="'selectHistory'"
					value=""
					list="history" 
					listValue="name"
					listKey="name"
					headerKey="'-----QUERY SAVES-----'"
					headerValue="'-----QUERY SAVES-----'"
					onchange="'document.forms[0].submit();'"/>
			</webwork:form>
					</td>
				</tr>
			</table>

			<webwork:form theme="'simple'" method="'post'" action="postAction"
				name="'menuMine'">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>
					<table>
						<tr>
							<td><webwork:textfield theme="'simple'"
								cssClass="'spreadsheetName'" name="'spreadsheetName'"
								value="spreadsheetName" /></td>
							<td><webwork:submit theme="'simple'" name="'submit'"
							value="'Save'" /></td>
						</tr>
					</table>
					</td>
				</tr>

				<tr>
					<td valign="top" align="left"><webwork:submit
						cssClass="'filterButtonsTopSubmit'" theme="'simple'"
						name="'submit'" value="'Submit Query'" /> <webwork:submit
						cssClass="'filterButtonsTopReset'" theme="'simple'" name="'reset'"
						value="'RESET'" /></td>

				</tr>
				<tr>
					<td class="smallFont"
						style="white-space: nowrap; background-color: #CCCCCC;"
						align="left" valign="top"><b>Show These Results</b></td>
				</tr>



				<webwork:iterator value="mineFields.mineGroups" status="mestatus">
					<webwork:if test="includeInMenu">
						<tr>
							<td>
							<table cellpadding="0" cellspacing="0" width="100%"
								class="headerBGProduct">
								<tr>
									<td valign="top" bgcolor="<webwork:property value="bgcolor"/>"
										rowspan="<webwork:property value="mineFields.size()*2+3"/>"
										class="headerselect" width="1"><img
										src="<webwork:property value="image"/>" alt="" /></td>

								</tr>

								<webwork:iterator value="mineFields">

									<webwork:include page="form/_menuMineMainFormGeneralField.jsp" />

								</webwork:iterator>


							</table>
							</td>
						</tr>
					</webwork:if>
				</webwork:iterator>


				<tr>
					<td>
					<table cellpadding="0" cellspacing="0" width="100%"
						class="headerBGPricing">
						<tr>
							<td valign="top" bgcolor="#6699CC" rowspan="10"
								class="headerselect" width="1"><img
								src="img/menumine-pricing.gif" alt="pricing" /></td>
						</tr>
						<webwork:include page="form/_menuMineMainFormMenuPricing.jsp" />
						<webwork:include page="form/_menuMineMainFormSameStore.jsp" />



























					</table>
					</td>
				</tr>


				<tr>
					<td valign="top" align="left">< webwork:submit
					cssClass="'filterButtons'" theme="'simple'" name="'submit'"
					value="'Submit Query'" /></td>
				</tr>



			

		</table>
		</webwork:form>
		</div>
		</td>
	</tr>
</table>
