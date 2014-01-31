
<%@ taglib uri="webwork" prefix="webwork"%>

<div id="mainFormQueryManager" class="powerSearchFieldPopup">
	<p class="popupClose"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

			<h2>Query Manager</h2>

<!-- RSC 2006-01-20 -->


			<h3>Save Current Query As</h3>
			
<div align="center">
						<webwork:form theme="'simple'" method="'post'"
							action="'menumineSaveQuery.action'" name="'menuMineSaveQuery'"  >
							
						<p><webwork:textfield theme="'simple'"
							cssClass="'spreadsheetName'" name="'spreadsheetName'"
							value="spreadsheetName" /></p>

						<p><webwork:submit theme="'simple'" name="'submit'"
							value="'Save Current Query'" /></p>

						</webwork:form>
</div>
						
			<p>Saving will create a new saved query record.  Each saved
			query record must have a unique name.  Note: Saved queries do not include your current filter settings.</p>

			<h3>Saved Queries</h3>
			
			<p align="center"><a href="<webwork:url value="'savedQueryList.action'" includeParams="'none'"/>">Query Manager</a></p>
			
			<table>
				<tr>
					<th>Name</th>

					<th>&nbsp;</th>
				</tr>
			<webwork:iterator value="history">
				<tr>
					<td>
						<webwork:property value="name" />
						<webwork:if test="timestamp != null" >
							(<webwork:property value="timestamp" />)
						</webwork:if>
					
					</td>
					<td>
				<webwork:if test="name != '-----Session Saves-----' && name != '-----Permanent Saves-----'">
				<a href="<webwork:url value="'menumineLoadQuery.action'" >	
				
					<webwork:param name="'selectHistory'" value="name" />

				

				</webwork:url>">Load</a>
				</webwork:if>
				</td>

				</tr>
			</webwork:iterator>
			</table>



		</div>

