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


<table>
	<tr>
		<td align="left" class="smallFont">Record Count: <webwork:property
			value="count" /></td>
	</tr>
</table>

<table>
	<tr>
		<td align="left" class="smallFont"><a class="smallFont"
			href="#nowhere"
			onclick="javascript:confirmReset('<webwork:url value="'resetRollUp.action'" />');">
		Reset </a> &nbsp; | &nbsp; <a
			onclick="javascript:toggle('autoRollUpOptions');" href="#nowhere">Auto
		Roll Up</a>
		<div id="autoRollUpOptions" class="helpPopUp1" style="display:none;">

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







		</td>
	</tr>
</table>


<table width="100%">
	<tr>
		<td><webwork:form theme="'simple'" method="'POST'"
			action="'filterRollUp.action'" name="'menuMineRollUpFilter'">
	Filter Roll Up<webwork:textfield theme="'simple'" name="'rollUpFilter'"
				value="filter" />
			<webwork:submit theme="'simple'" name="'submitRollUpFilter'"
				value="'Filter'" />
		</webwork:form></td>
		<td><a
			href="<webwork:url value="'filterRollUp.action'" >	
				<webwork:param name="'rollUpFilter'" value="''" />
				</webwork:url>">
		Unfilter </a></td>

		<td><webwork:form theme="'simple'" method="'GET'"
			action="'addRollUp.action'" name="'menuMineRollUp'">
			<webwork:hidden theme="'simple'" name="'rollUpParameters.term'"
				value="''" />
Roll Up As:<webwork:textfield theme="'simple'"
				name="'rollUpParameters.rollUpLabel'"
				value="rollUpParameters.rollUpLabel" />
			<webwork:submit theme="'simple'" name="'submitRollUp'"
				value="'Roll Up'" /></td>
	</tr>
</table>

<table border="1" class="results">
	<tr>
		<td class="resultHeader">&nbsp;</td>
		<th class="resultHeader">&nbsp;</th>
		<th class="resultHeader">Name</th>
		<th class="resultHeader">Percent Of Sample (%)</th>
		<th class="resultHeader">Number in Sample</th>
		<th class="resultHeader">Actions</th>
		<%--
		<th class="resultHeader"> Size of Sample </th>
		<th class="resultHeader" >Median 2004</th>
		--%>
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
		<%--
		<td class="results_cellB"><webwork:property value="statisticalTableResults.total.sizeOfSample"/></td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
				<webwork:param value="statisticalTableResults.total.priceData.medianPrice2004"/>
			</webwork:text>
		</td>
		--%>
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
				<webwork:if test="rollUpElements.size() ==0">

				<div
					id="<webwork:property value="statisticalTableElement.name"/>NaturalAddDropZone"
					style="overflow:auto" class="customDropZone"><span
					id='<webwork:property value="statisticalTableElement.name" />NaturalDrag'
					class='nameSpan' style='border:1px solid #ffffee;display:block'><webwork:property
					value="statisticalTableElement.name" /></span> <script
					language="JavaScript" type="text/javascript">
				<!--
				dndMgr.registerDraggable( new CustomDraggable($('<webwork:property value="statisticalTableElement.name" />NaturalDrag'), '<webwork:property value="statisticalTableElement.name" />') );
				//-->
				</script></div>

				<script language="JavaScript" type="text/javascript">
		<!--
			dndMgr.registerDropZone( new CustomDropzoneAddToRollUp('<webwork:property value="statisticalTableElement.name"/>NaturalAddDropZone', null, '<webwork:property value="statisticalTableElement.name"/>') );
		//-->
		</script>


				<%--<ul id="<webwork:property value="statisticalTableElement.name"/>" class="sortable boxy" style="margin-left: 1em;">
				<li> <webwork:property value="statisticalTableElement.name" /> </li>
			</ul>
			--%>
			</webwork:if> <webwork:else>
				<webwork:property value="statisticalTableElement.name" />
			</webwork:else></td>
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


			<%--
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="statisticalTableElement.sizeOfSample" /></td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2004"/>
		</webwork:text>
		</td>		
		--%>


		</tr>
		<webwork:if test="rollUpElements.size() >0">
			<tr>
				<td></td>
				<td class="<webwork:property value="#displayClass"/>" colspan="5"><span
					id="<webwork:property value="statisticalTableElement.name"/>Div"
					style="display:none; ">

				<table>
					<tr>

						<td><span
							id="<webwork:property value="statisticalTableElement.name"/>AddDropZoneHeader"
							style="padding:2px 0px" class="catHeader">Add To Roll Up</span>


						<div
							id="<webwork:property value="statisticalTableElement.name"/>AddDropZone"
							style="width:200px;height:100px;overflow:auto"
							class="customDropZone"><webwork:iterator value="rollUpElements"
							status="mestatus">
							<%--We need to have enough checkboxes so when we drag x objects we have enough checkboxes to handle each 
				object draged
				
			--%>
							<webwork:checkbox theme="'simple'"
								name="'rollUpParameters.terms'" fieldValue="term.name"
								cssStyle="'display:none'" />

							<span id='<webwork:property value="term"/>Drag' class='nameSpan'
								style='border:1px solid #ffffee;display:block'><webwork:property
								value="term" /></span>

							<script language="JavaScript" type="text/javascript">
				<!--
				dndMgr.registerDraggable( new CustomDraggable($('<webwork:property value="term"/>Drag'), '<webwork:property value="term"/>') );
				//-->
				</script>

							<%--
			<a  href="<webwork:url value="'removeRollUp.action'" > <webwork:param name="'target'" value="term" /> </webwork:url>">
				(remove)
			</a>
			--%>
						</webwork:iterator></div>

						<script language="JavaScript" type="text/javascript">
				<!--
				 dndMgr.registerDropZone( new CustomDropzoneAddToRollUp('<webwork:property value="statisticalTableElement.name"/>AddDropZone', '<webwork:property value="statisticalTableElement.name"/>AddDropZoneHeader', '<webwork:property value="statisticalTableElement.name"/>') );
				//-->
				</script></td>
						<td><span
							id="<webwork:property value="statisticalTableElement.name"/>RemoveDropZoneHeader"
							style="padding:2px 0px" class="catHeader">Remove From Roll Up</span>

						<div
							id="<webwork:property value="statisticalTableElement.name"/>RemoveDropZone"
							style="width:200px;height:100px;overflow:auto"
							class="customDropZone"></div>

						<script language="JavaScript" type="text/javascript">
				<!--
				 dndMgr.registerDropZone( new CustomDropzoneRemoveFromRollUp('<webwork:property value="statisticalTableElement.name"/>RemoveDropZone', '<webwork:property value="statisticalTableElement.name"/>RemoveDropZoneHeader') );
				//-->
				</script></td>


						<%--<td>
			   <span id="<webwork:property value="statisticalTableElement.name"/>AddDropZone"  style="padding:2px 0px" class="catHeader">h-m</span>
			   <div style="width:200px" class="roundMe" >
			  	 <div id="<webwork:property value="statisticalTableElement.name"/>AddDropZone2" style="height:100px;overflow:auto" class="customDropZone">
				 </div>
			   </div>
		</td>
		--%>
					</tr>
				</table>


				</span></td>
			</tr>
		</webwork:if>

	</webwork:iterator>
	</webwork:form>

</table>
