<%@ taglib uri="webwork" prefix="webwork"%>



<div id="mainFormDiv" style="z-index:-1">




<h2>Data Set</h2>




<webwork:form theme="'simple'" method="'post'" action="postAction"
	name="'menuMine'">
	<table cellspacing="0" cellpadding="0" width="100%" border="0">
		<tr>
			<td valign="top" align="center" class="smallFont">
			<!--	<a href="#"	onclick="javascript:showPopupAtHeight('mainFormSummary',50);">Search Summary</a> | -->
				    <a href="javascript:showPopupAtHeight('mainFormQueryManager',50);">Save/Load Queries</a>
			<!--    <a href="javascript:showPopupAtHeight('helpWithSearch',50);">Help With Search</a><br />&nbsp; -->
			</td>
		</tr>
		<tr>
			<td class="smallFont"
				style="white-space: nowrap; background-color: #CCCCCC;" align="left"
				valign="top"><b>Query Manager</b></td>
		</tr>


		<webwork:set name="fieldCounter" value="1" />

		<webwork:iterator value="mineFields.mineGroups" status="mestatus">
			<webwork:if test="includeInMenu">
				<webwork:iterator value="mineFields">
					<webwork:if test="fieldsToDisplayValue">
						<tr>
							<td>
							<table cellpadding="0" cellspacing="0" width="100%">


								<webwork:include page="form/_menuMineMainFormGeneralField.jsp" />

								<webwork:set name="fieldCounter" value="#fieldCounter + 1" />

							</table>
							</td>
						</tr>
					</webwork:if>

				</webwork:iterator>
			</webwork:if>
		</webwork:iterator>


		<tr>
			<td valign="top" align="left"><webwork:submit
				cssClass="'filterButtonsTopSubmit'" theme="'simple'" name="'submit'"
				value="'Submit Query'" /> <webwork:submit
				cssClass="'filterButtonsTopReset'" theme="'simple'" name="'reset'"
				value="'RESET'" /></td>
		</tr>

		<tr>
			<td valign="top">
			<h2><a href="#"
				onclick="javascript:showPopupAtHeight('powerSearchAdditionalFields',30);">Additional
			Fields</a></h2>
			</td>
		</tr>
		
		<%--
		<tr>
			<td valign="top">
			<h2><a href="#"
				onclick="javascript:showPopupAtHeight('powerSearchQueryTemplates',30);">Query Templates</a></h2>
			</td>
		</tr>	
		--%>	




	</table>

	






	<div id="powerSearchAdditionalFields" class="powerSearchFieldPopup">

	<p class="popupClose"><a href="#"
		onclick="javascript:hideActivePopup();">close</a></p>
	<h3>Additional Fields</h3>


	<table border="0">
		<tr>

			<webwork:set name="isReadyToOpenTable" value="true" />
			<webwork:set name="isReadyToCloseTable" value="false" />
			
			<webwork:set name="groupsInColumnCount" value="0" />
			
			<webwork:iterator value="mineFields.mineGroups" status="mestatus">
				<webwork:if test="includeInMenu">
					<webwork:if test="#isReadyToOpenTable">
						<webwork:set name="isOpen" value="true" />
						<webwork:set name="groupsInColumnCount" value="0" />
						<webwork:set name="isReadyToOpenTable" value="false" />
						<td valign="top">
						<table width="192px" border="0">
					</webwork:if>

					<webwork:set name="groupsInColumnCount" value="(#groupsInColumnCount+1)" />
					
					<tr>
						<td colspan="2"><strong><webwork:property value="name" /></strong>
						</td>
					</tr>


					<webwork:iterator value="mineFields">
						<webwork:if test="!fieldsToDisplayValue">
							<tr>
								<td align="left" width="5%"><webwork:checkbox
									theme="'simple'" fieldValue="'true'"
									name="fieldsToDisplayName" value="fieldsToDisplayValue" /> <webwork:include
									page="form/_menuMineMainFormGeneralFieldHidden.jsp" /></td>
								<td><webwork:property value="friendlyName" /></td>

							</tr>
						</webwork:if>
					</webwork:iterator>



					<webwork:if test="forceNewColumn"> 
						<webwork:set name="isReadyToCloseTable" value="true" />
					</webwork:if>
					<webwork:elseif test="!forceExtraColumn && #groupsInColumnCount == 2  ">
						<webwork:set name="isReadyToCloseTable" value="true" />
					</webwork:elseif>
					<webwork:elseif test=" !forceExtraColumn && #groupsInColumnCount > 2 ">
						<webwork:set name="isReadyToCloseTable" value="true" />
					</webwork:elseif>
					
					<%--
					<p>Count <webwork:property value="#groupsInColumnCount" /> Extra <webwork:property value="forceExtraColumn" /> </p>--%>
					<webwork:if test="#isReadyToCloseTable">
						</table>
						</td>
						<webwork:set name="isReadyToOpenTable" value="true" />
						<webwork:set name="isReadyToCloseTable" value="false" />
						<webwork:set name="isOpen" value="false" />
					</webwork:if>
				</webwork:if>
			</webwork:iterator>
			<webwork:if test="#isOpen">
				</table>
				</td>
			</webwork:if>
	</tr>
	</table>
	
	
	</div>

</webwork:form></div>

<%--
<div id="powerSearchQueryTemplates" class="powerSearchFieldPopup">
<p class="popupClose"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>
<h3>Query Templates</h3>

			<p>
			<webwork:iterator value="menuMineSessionContextWrapper.queryTemplates"  >
				<webwork:property value="name" /> <a href="<webwork:url value="'menumineLoadTemplate.action'" ><webwork:param name="'target'" value="id" /></webwork:url>">Load</a><br/>
			</webwork:iterator>
			</p>

</div>
--%>

<div id="helpWithSearch" onmouseover="javascript:handlePopupMouseOver();">
	<p class="popupClose"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>
      <h3>Help With Search</h3>
<p>Welcome to the new MenuMine Power Search screen.  The format has changed, but you still have all of the same options.  You can see or modify Driller, Searcher, Eliminator and other criteria by simply rolling your mouse over the field name.  The same window you used before will popup just to the right.</p>

<p>MenuMine offers over 80 fields of data you can query and display.  To keep things easy, we don't show everything on the screen all the time. If you're interested in dry flavor enhancers, for example, switch to Ingredient Mine.  Desserts?  Switch to Dessert Mine.</p>

<p>Any given Mine will have 20-30 fields for you to use.  You will only see a few of those activated at a time.  To see the rest, roll your mouse over the "Additional Fields" link.  A subwindow will appear with fields not currently selected.  You can simply check the additional ones you want and click on "Submit Query".  You'll see it join the rest of the selected fields on the left.</p>

<p>When you add criteria to a field, that criteria continues to affect your query results even when you stop displaying the field as part of the results.</p>

<p>Filters are an additional way to manipulate your results, but only when viewing statistical tables or graphs.  Check a box to apply a filter.  Set filter specific parameters by rolling over a filter name and completing the form.</p>

</div>