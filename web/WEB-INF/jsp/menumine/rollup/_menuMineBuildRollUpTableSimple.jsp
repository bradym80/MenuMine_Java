<%@ taglib uri="webwork" prefix="webwork"%>

<script type="text/javascript" language="javascript">
<!--
	function confirmEliminate(url){
		if(confirm("Are you sure you want to eliminate these results from the result set?"))
		{
		 location.replace(url)
		}
	}
	function confirmRemove(url){
		if(confirm("Are you sure you want to remove this label from the roll up?"))
		{
			location.replace(url)
		}
	}

		function confirmReset(url){
		if(confirm("Are you sure you want to reset this roll up?"))
		{
			location.replace(url)
		}
	}		
//-->
</script>


<table >
	<tr>
		<td valign="top" align="left" class="smallFont">Record Count: <webwork:property
			value="count" /> | <a class="smallFont"
			href="#nowhere"
			onclick="javascript:confirmReset('<webwork:url value="'resetRollUp.action'" />');">
		Reset </a> &nbsp; | &nbsp; <a
			onclick="javascript:toggle('autoRollUpOpt');" href="#nowhere">Auto
		Roll Up</a>
		<div id="autoRollUpOpt" class="helpPopUp2" style="display:none;">

		<a
			href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'5'" />
				</webwork:url>">
		Roll Up Very Aggressively </a> <br/>
		<a
			href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'4'" />
				</webwork:url>">
		Roll Up Aggressively </a> <br/>
		<a
			href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'3'" />
				</webwork:url>">
		Roll Up Average </a> <br/>
		<a
			href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'2'" />
				</webwork:url>">
		Roll Up Conservatively </a> <br/>
		<a
			href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'1'" />
				</webwork:url>">
		Roll Up Very Conservatively </a></div>

		|
			<a
			href="<webwork:url value="'filterRollUp.action'" >	
				<webwork:param name="'rollUpFilter'" value="''" />
				</webwork:url>">
		Unfilter</a>

		| 
		Filter Original List For Term: 


		</td>

		<td class="smallFont" valign="top"><webwork:form theme="'simple'" method="'POST'"
			action="'filterRollUp.action'" name="'menuMineRollUpFilter'">
	 <webwork:textfield theme="'simple'" name="'rollUpFilter'"
				value="filter" cssClass="'smallFont'" />
			<webwork:submit theme="'simple'" name="'submitRollUpFilter'"
				value="'Filter'" cssClass="'smallFont'" />
		</webwork:form></td>
		<td class="mediumFont"></td>
	</tr>
</table>


<table width="100%">
	<tr>


		<td class="mediumFont"><webwork:form theme="'simple'" method="'GET'"
			action="'addRollUp.action'" name="'menuMineRollUp'">
			<webwork:hidden theme="'simple'" name="'rollUpParameters.term'"
				value="''" />
Roll Up Checked Items As: <webwork:textfield theme="'simple'"
				name="'rollUpParameters.rollUpLabel'"
				value="rollUpParameters.rollUpLabel" />
			<webwork:submit theme="'simple'" name="'submitRollUp'"
				value="'Roll Up'" /></td>
	</tr>
</table>

<table border="1" class="results" width="100%">
	<tr>
		<td class="resultHeader">&nbsp;</td>
		<th class="resultHeader">&nbsp;</th>
		<th class="resultHeader">Name</th>
		<th class="resultHeader">Percent Of Sample (%)</th>
		<th class="resultHeader">Number in Sample</th>
		<th class="resultHeader">Actions</th>

	</tr>

	<tr>
		<td class="results_cellB"><webwork:checkbox theme="'simple'"
			name="'selectAll'" onclick="'selectAllRollUpBuilder()'"
			fieldValue="'true'" /></td>

		<td class="results_cellB">&nbsp;</td>
		<td class="results_cellB"><webwork:property
			value="statisticalTableResults.total.name" /></td>
		<td class="results_cellB"><webwork:text
			name="'decimal.one.places.format'">
			<webwork:param value="statisticalTableResults.total.percent" />
		</webwork:text></td>
		<td class="results_cellB"><webwork:property
			value="statisticalTableResults.total.numberInSample" /></td>
		<td class="results_cellB">&nbsp;</td>

	</tr>






	<webwork:iterator value="rollUpTable.rollUpElements" status="mestatus">
		<webwork:if
			test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
			<webwork:set name="displayClass" value="'results_cellA'" />
		</webwork:if>
		<webwork:else>
			<webwork:set name="displayClass" value="'results_cellB'" />
		</webwork:else>



		<tr>
			<td><webwork:checkbox theme="'simple'"
				name="'rollUpParameters.terms'"
				fieldValue="statisticalTableElement.name" /></td>
			<td class="<webwork:property value="#displayClass"/>"><webwork:property
				value="#mestatus.count" /></td>


			<td class="<webwork:property value="#displayClass"/>">

				<webwork:property value="statisticalTableElement.name" />
			</td>
			<td class="<webwork:property value="#displayClass"/>"><webwork:text
				name="'decimal.one.places.format'">
				<webwork:param value="statisticalTableElement.percent" />
			</webwork:text></td>
			<td class="<webwork:property value="#displayClass"/>"><webwork:property
				value="statisticalTableElement.numberInSample" /></td>

			<td class="<webwork:property value="#displayClass"/>"><a
				href="#nowhere"
				onclick="javascript:confirmEliminate('<webwork:url value="'addFilterEliminatorFromRollUp.action'" > <webwork:param name="'target'" value="statisticalTableElement.name" /> </webwork:url>');">
			(Eliminate From Results) </a> <webwork:if
				test="rollUpElements.size() >0">
				<a href="#nowhere"
					onclick="javascript:confirmRemove('<webwork:url value="'removeRollUpByLabel.action'" > <webwork:param name="'target'" value="statisticalTableElement.name" /> </webwork:url>'	);">
				(Remove from RollUp ) </a>

				<a href="#nowhere"
					onclick="javascript:toggle('<webwork:property value="statisticalTableElement.name"/>Div');">
				<img
					id="<webwork:property value="statisticalTableElement.name"/>Div_image"
					border="0" src="img/expand.gif" /> Toggle Terms </a>
			</webwork:if></td>





		</tr>
		<webwork:if test="rollUpElements.size() >0">
			<tr>
				<td></td>
				<td class="<webwork:property value="#displayClass"/>" colspan="5">
					<span
					id="<webwork:property value="statisticalTableElement.name"/>Div"
					style="display:none; ">
					<table width="100%" border="0">

						<webwork:iterator value="rollUpElements" status="mestatus">
							<webwork:if	test="#mestatus.modulus(3) == 1"><tr></webwork:if>
							<td valign="top" class="smallFont" width="33%">
								<webwork:if test="term != null">								
 								<webwork:property value="term" />
 								
 								<a href="<webwork:url value="'removeRollUpByLabelAndTerm.action'">
 											<webwork:param name="'targetLabel'" value="label"/>
 											<webwork:param name="'targetTerm'" value="term" />
 											</webwork:url>">Remove</a>
 								
								</webwork:if>&nbsp;
								
							</td>
							<webwork:if	test="#mestatus.modulus(3) == 0"></tr></webwork:if>
						</webwork:iterator>
					</table>
					</span>
				</td>
			</tr>
		</webwork:if>

		</webwork:iterator>
	</webwork:form>

</table>
