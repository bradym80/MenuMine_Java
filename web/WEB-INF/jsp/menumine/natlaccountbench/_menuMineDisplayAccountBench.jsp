<%@ taglib uri="webwork" prefix="webwork" %>



<table border="1" class="results" >	
					<tr>
						<th class="resultHeader">&nbsp;</th>
						<th class="resultHeader">Name</th>	
						<th class="resultHeader">Percent Target (%)
						<webwork:property value="nationalAccountBenchmarkTableResults.shareTableA.total.sizeOfSample"/>
						</th>
						<th class="resultHeader">Percent Benchmark (%)
						<webwork:property value="nationalAccountBenchmarkTableResults.shareTableB.total.sizeOfSample"/>
						</th>
						<th class="resultHeader">Index</th>
				
					</tr>
					
					
				<webwork:iterator value="#nabTable.rows" status="mestatus">
					<webwork:if test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
						<webwork:set name="displayClass" value="'results_cellA'"/>
					</webwork:if>
					<webwork:else>
						<webwork:set name="displayClass" value="'results_cellB'"/>			
					</webwork:else>
					
					
					
					<tr>
						<td class="<webwork:property value="#displayClass"/>"><webwork:property value="#mestatus.count"/> </td>
				
						<td class="<webwork:property value="#displayClass"/>"><webwork:property value="name" /></td>
						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.one.places.format'">
								<webwork:param value="percentOfTarget"/>
							</webwork:text>
						</td>
						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.one.places.format'">
								<webwork:param value="percentOfBenchmark"/>
							</webwork:text>
						</td>
						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.zero.places.format'">
								<webwork:param value="index"/>
							</webwork:text>
						</td>
						
					
				
					</tr>
					
				</webwork:iterator>
				
				
</table>




	
	