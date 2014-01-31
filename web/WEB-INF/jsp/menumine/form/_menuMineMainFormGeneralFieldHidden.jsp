<%@ taglib uri="webwork" prefix="webwork" %>


	
	<webwork:set name="currentParam" value="currentMasterFoodFilterParameter"/>
	<webwork:set name="currentList" value="distinctQuery"/>
	
	<webwork:if test="!#currentParam.filterParameter.filterEmpty">
		<div id="<webwork:property value="shortOgnlName"/>Div" style="display:none; ">

				<webwork:if test="#currentList != null">
					<webwork:include page="_menuMineMainFormInAndOrNot.jsp" />
				</webwork:if>
				<webwork:else>
					<webwork:include page="_menuMineMainFormAndOrNot.jsp" />
				</webwork:else>

		</div>
	</webwork:if>

  