<%@ taglib uri="webwork" prefix="webwork" %>


<table>
<tr><td align ="left" class="smallFont">Record Count: <webwork:property value="count" /></td></tr>	
</table>

<table>
<tr><td align ="left" class="smallFont">



<a  onclick="javascript:toggle('autoRollUpOptions');" 
			href="#nowhere">Auto Roll Up</a>
			<div id="autoRollUpOptions" class="helpPopUp1" style="display:none;">
			
			<a href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'5'" />
				</webwork:url>">
				Roll Up Very Aggressively
			</a>
			<br/>
			<a href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'4'" />
				</webwork:url>">
				Roll Up  Aggressively
			</a>
			<br/>
			<a href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'3'" />
				</webwork:url>">
				Roll Up Average
			</a>
			<br/>			
			<a href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'2'" />
				</webwork:url>">
				Roll Up Conservatively
			</a>			
			<br/>
			<a href="<webwork:url value="'autoRollUpBuilder.action'" >
						<webwork:param name="'rollUpIntencity'" value="'1'" />
				</webwork:url>">
				Roll Up Very Conservatively
			</a>			
			</div>	







</td></tr>	
</table>

<webwork:form theme="'simple'" method="'post'" action="'filterRollUp.action'" name="'menuMineRollUpFilter'">
<table width="100%"><tr><td>

	Filter Roll Up<webwork:textfield theme="'simple'"  name="'rollUpFilter'" value="filter" />
	<webwork:submit  theme="'simple'" name="'submitRollUpFilter'" value="'Filter'" />
</webwork:form>
</td>
<td>
	<a href="<webwork:url value="'filterRollUp.action'" >	
				<webwork:param name="'rollUpFilter'" value="''" />
				</webwork:url>">
				Unfilter
	</a>
</td>

<td>
<webwork:form theme="'simple'" method="'POST'" action="'addRollUp.action'" name="'menuMineRollUp'">
	
Roll Up As:<webwork:textfield theme="'simple'"  name="'rollUpParameters.rollUpLabel'" value="rollUpParameters.rollUpLabel" />
	<webwork:submit  theme="'simple'" name="'submitRollUp'" value="'Roll Up'" />
</td></tr></table>

<table border="1" class="results" >	
	<tr>
		<td class="resultHeader">&nbsp;</td>
		<th class="resultHeader"> &nbsp; </th>
		<th class="resultHeader"> Name </th>	
		<th class="resultHeader"> Percent Of Sample (%) </th>
		<th class="resultHeader"> Number in Sample </th>
		<%--
		<th class="resultHeader"> Size of Sample </th>
		<th class="resultHeader" >Median 2004</th>
		--%>
	</tr>
	
	<tr>
		<td class="results_cellB">
			<webwork:checkbox theme="'simple'"name="'selectAll'" onclick="'selectAllRollUpBuilder()'" fieldValue="'true'"/>
		</td>
		
		<td class="results_cellB">&nbsp;</td>
		<td class="results_cellB"><webwork:property value="statisticalTableResults.total.name"/></td>
		<td class="results_cellB">
		<webwork:text name="'decimal.one.places.format'">
			<webwork:param value="statisticalTableResults.total.percent"/>
		</webwork:text>
		</td>
		<td class="results_cellB"><webwork:property value="statisticalTableResults.total.numberInSample"/></td>
		<%--
		<td class="results_cellB"><webwork:property value="statisticalTableResults.total.sizeOfSample"/></td>

		<td class="results_cellB">
			<webwork:text name="'dollar.format'">
				<webwork:param value="statisticalTableResults.total.priceData.medianPrice2004"/>
			</webwork:text>
		</td>
		--%>
	</tr>
	

	


			
<webwork:iterator value="rows" status="mestatus">
	<webwork:if test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
		<webwork:set name="displayClass" value="'results_cellA'"/>
	</webwork:if>
	<webwork:else>
		<webwork:set name="displayClass" value="'results_cellB'"/>			
	</webwork:else>
	
	
	
	<tr>
	<td>
		<webwork:checkbox theme="'simple'"name="'rollUpParameters.terms'"  fieldValue="name"/>
	</td>
	<td class="<webwork:property value="#displayClass"/>"><webwork:property value="#mestatus.count"/> </td>

		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="name" /></td>
		<td class="<webwork:property value="#displayClass"/>">
		
		<webwork:text name="'decimal.one.places.format'">
			<webwork:param value="percent"/>
		</webwork:text>
		
		
		</td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="numberInSample" /></td>
		<%--
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="sizeOfSample" /></td>

		<td class="<webwork:property value="#displayClass"/>">
			<webwork:text name="'dollar.format'">
			<webwork:param value="priceData.medianPrice2004"/>
		</webwork:text>
		</td>		
		--%>
		

	</tr>
	
</webwork:iterator>


</table>
</webwork:form>