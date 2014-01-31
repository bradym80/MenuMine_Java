<%@ taglib uri="webwork" prefix="webwork"%>

<webwork:set name="isExcel" value="'true'"/>
<webwork:set name="excelFile" value="'/crossTabExcel.xls'"/>
<webwork:set name="isAll" value="'false'"/>
<webwork:set name="isTrend" value="'false'"/>
<webwork:set name="isCut" value="'false'"/>
<webwork:set name="isPie" value="'false'"/>
<webwork:set name="isBar" value="'false'"/>
<webwork:if test="chainStat.chainStateCount!=null">	
    <webwork:set name="isMap" value="'true'"/>
</webwork:if>
<webwork:else>
    <webwork:set name="isMap" value="'false'"/>
</webwork:else>

<table>
	<tr>
		<td align="left" class="smallFont">Record Count: <webwork:property
			value="count" /> <!--|
			<a href="<webwork:url value="'crossTabExcel.xls'"/>">Export to Excel</a>-->
			
			</td>
	</tr>
</table>
<table border="1" class="results"  width="100%">
	<tr>
		<td colspan="2">&nbsp;</td>
		<webwork:iterator value="crossTabulationResults.columnsWithRollUp"
			status="mestatus">
			<td colspan="2" class="resultHeader"><webwork:property value="name" /></td>
		</webwork:iterator>

		<td colspan="2" class="resultHeader">Total</td>
	</tr>

	<tr>
		<td colspan="2">&nbsp;</td>
		<webwork:iterator value="crossTabulationResults.columnsWithRollUp">
			<td class="resultHeader" align="center">#</td>
			<td class="resultHeader" align="center">%</td>
		</webwork:iterator>
		<td class="resultHeader" align="center">#</td>
		<td class="resultHeader" align="center">%</td>
	</tr>

	<webwork:iterator value="crossTabulationResults.rows" status="mestatus">
		<webwork:if test="#mestatus.modulus(3) == 0 ">
			<webwork:set name="displayClass" value="'results_cellA'" />
		</webwork:if>
		<webwork:else>
			<webwork:set name="displayClass" value="'results_cellB'" />
		</webwork:else>



		<tr>
			<td class="<webwork:property value="#displayClass"/>"><webwork:property
				value="#mestatus.count" /></td>
			<td class="<webwork:property value="#displayClass"/>"><webwork:property
				value="name" /></td>


			<webwork:iterator value="cellsWithRollUp">


				<td class="<webwork:property value="#displayClass"/>"><webwork:property
					value="count" /></td>
				<td class="<webwork:property value="#displayClass"/>"><webwork:text
					name="'decimal.one.places.format'">
					<webwork:param value="columnPercentage" />
				</webwork:text></td>

			</webwork:iterator>

			<td class="<webwork:property value="#displayClass"/>"><webwork:property
				value="count" /></td>
			<td class="<webwork:property value="#displayClass"/>"><webwork:text
				name="'decimal.one.places.format'">
				<webwork:param value="columnPercentage" />
			</webwork:text></td>



		</tr>
		<tr>

			<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
			<td class="<webwork:property value="#displayClass"/>" align="right">
			%</td>
			<webwork:iterator value="cellsWithRollUp">




				<td class="<webwork:property value="#displayClass"/>"><webwork:text
					name="'decimal.one.places.format'">
					<webwork:param value="rowPercentage" />
				</webwork:text></td>
				<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>

			</webwork:iterator>


			<td class="<webwork:property value="#displayClass"/>"><webwork:text
				name="'decimal.one.places.format'">
				<webwork:param value="rowPercentage" />
			</webwork:text></td>
			<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>

		</tr>

	</webwork:iterator>

	<tr>
		<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
		<td class="<webwork:property value="#displayClass"/>">Total</td>
		<webwork:iterator value="crossTabulationResults.columnsWithRollUp">
			<td class="<webwork:property value="#displayClass"/>"><webwork:property
				value="count" /></td>

			<td class="<webwork:property value="#displayClass"/>"><webwork:text
				name="'decimal.one.places.format'">
				<webwork:param value="columnPercentage" />
			</webwork:text></td>

		</webwork:iterator>

		<td class="<webwork:property value="#displayClass"/>"><webwork:property
			value="crossTabulationResults.total.count" /></td>
		<td class="<webwork:property value="#displayClass"/>"><webwork:text
			name="'decimal.one.places.format'">
			<webwork:param value="crossTabulationResults.total.columnPercentage" />
		</webwork:text></td>
	</tr>
	<tr>
		<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
		<td class="<webwork:property value="#displayClass"/>" align="right">%
		</td>


		<webwork:iterator value="crossTabulationResults.columnsWithRollUp">


			<td class="<webwork:property value="#displayClass"/>"><webwork:text
				name="'decimal.one.places.format'">
				<webwork:param value="rowPercentage" />
			</webwork:text></td>

			<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>

		</webwork:iterator>


		<td class="<webwork:property value="#displayClass"/>"><webwork:text
			name="'decimal.one.places.format'">
			<webwork:param value="crossTabulationResults.total.rowPercentage" />
		</webwork:text></td>
		<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
	</tr>



</table>
