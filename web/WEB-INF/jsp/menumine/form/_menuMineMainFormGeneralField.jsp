<%@ taglib uri="webwork" prefix="webwork" %>


	
	<webwork:set name="currentParam" value="currentMasterFoodFilterParameter"/>
	<webwork:set name="currentList" value="distinctQuery"/>
	
	<tr>
    	<td class="powerSearchFieldName">
    		<table width="100%" cellpadding="0" cellspacing="0"  >
    			<tr >
    				<td   align="left" width="5%"  >
    					<webwork:checkbox theme="'simple'" fieldValue="'true'" name="fieldsToDisplayName" value="fieldsToDisplayValue"/>
    				</td>	
						<td class="menuFormFont" width="80%"  >
							<a href="#" onclick="javascript:showPopupAtHeight('<webwork:property value="shortOgnlName" />Div', <webwork:property value="#fieldCounter * 20 + 100" />);" ><webwork:property value="friendlyName"/></a>
						</td>
						<td align="right" width="15%" >
							<%-- 2006-05-08 note this keeps the last selected graph type.  that's a feature. --%>
							<%--
							<a href="<webwork:url value="'/menumineGraph.action'" >
									<webwork:param name="'menuMineGraphOptions.graphByField'" value="shortOgnlName" />
									<webwork:param name="'menuMineGraphOptions.graphTitle'" value="friendlyName" />
									<webwork:param name="'submitOptions'" value="'Graph'" /></webwork:url>"> --%>

									<a href="<webwork:url value="'menumineStatisticalTable.action'"><webwork:param name="'menuMineGraphOptions.graphByField'" value="fieldEnum.ognlName" /></webwork:url>"><img border="0" height="16" width="16" src="img/table_go.png" alt="" onmouseout="UnTip()" onmouseover="Tip('Drill Down')"/></a>					
						</td>
			</tr>
		</table>
	</td>
	</tr>
	<tr>
	<td class="powerSearchFieldSummary">
		<webwork:property value="#currentParam.simpleSummary" />
	</td>
	</tr>
	
	<tr ><td width="193px">
		<div id="<webwork:property value="shortOgnlName"/>Div" class="powerSearchFieldPopup"  >
					<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

				<table width="192px"><tr><td><h3><webwork:property value="friendlyName"/></h3></td></tr></table>
				
				<webwork:if test="#currentList != null">
					<webwork:include page="_menuMineMainFormInAndOrNot.jsp" />
				</webwork:if>
				<webwork:else>
					<webwork:include page="_menuMineMainFormAndOrNot.jsp" />
				</webwork:else>

		</div>
	</td>
	</tr>
  