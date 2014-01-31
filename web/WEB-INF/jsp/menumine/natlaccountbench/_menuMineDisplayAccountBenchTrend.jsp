<%@ taglib uri="webwork" prefix="webwork" %>




<table border="1" class="results" >	
					<tr>
						<th class="resultHeader">&nbsp;</th>
						<th class="resultHeader">Name</th>	
						<th class="resultHeader" colspan="2">2008</th>

						<th class="resultHeader" colspan="2">2005</th>
						
						<th class="resultHeader" colspan="2">2002</th>						
						
						<th class="resultHeader"colspan="2">1999</th>												
				
					</tr>

					<tr>
						<th class="resultHeader">&nbsp;</th>
						<th class="resultHeader">&nbsp;</th>	
						<th class="resultHeader">Target (%)<br/>
						<webwork:property value="nationalAccountBenchmarkTrendTableResults.benchmarkRecent.shareTableA.total.sizeOfSample"/>
						</th>
						<th class="resultHeader">Benchmark (%)<br/>
						<webwork:property value="nationalAccountBenchmarkTrendTableResults.benchmarkRecent.shareTableB.total.sizeOfSample"/>
						</th>
						<th class="resultHeader">Target (%)<br/>
						<webwork:property value="nationalAccountBenchmarkTrendTableResults.benchmarkMiddle.shareTableA.total.sizeOfSample"/>
						</th>
						
						<th class="resultHeader">Benchmark (%)<br/>
						<webwork:property value="nationalAccountBenchmarkTrendTableResults.benchmarkMiddle.shareTableB.total.sizeOfSample"/>
						</th>
						<th class="resultHeader">Target (%)<br/>
						<webwork:property value="nationalAccountBenchmarkTrendTableResults.benchmarkOldest.shareTableA.total.sizeOfSample"/>
						</th>
						<th class="resultHeader">Benchmark (%)<br/>
						<webwork:property value="nationalAccountBenchmarkTrendTableResults.benchmarkOldest.shareTableB.total.sizeOfSample"/>
						</th>

						<th class="resultHeader">Target (%)<br/>
						<webwork:property value="nationalAccountBenchmarkTrendTableResults.benchmarkOldest.shareTableA.total.sizeOfSample"/>
						</th>
						<th class="resultHeader">Benchmark (%)<br/>
						<webwork:property value="nationalAccountBenchmarkTrendTableResults.benchmarkOldest.shareTableB.total.sizeOfSample"/>
						</th>
						
				
					</tr>
					
					
				<webwork:iterator value="#nabTrend.rows" status="mestatus">
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
								<webwork:param value="benchmarkRecent.percentOfTarget"/>
							</webwork:text>
						</td>
						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.one.places.format'">
								<webwork:param value="benchmarkRecent.percentOfBenchmark"/>
							</webwork:text>
						</td>
						
						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.one.places.format'">
								<webwork:param value="benchmarkMiddle.percentOfTarget"/>
							</webwork:text>
						</td>
						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.one.places.format'">
								<webwork:param value="benchmarkMiddle.percentOfBenchmark"/>
							</webwork:text>
						</td>
						
						
						
						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.one.places.format'">
								<webwork:param value="benchmarkOldest.percentOfTarget"/>
							</webwork:text>
						</td>
						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.one.places.format'">
								<webwork:param value="benchmarkOldest.percentOfBenchmark"/>
							</webwork:text>
						</td>

						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.one.places.format'">
								<webwork:param value="benchmarkOldest.percentOfTarget"/>
							</webwork:text>
						</td>
						<td class="<webwork:property value="#displayClass"/>">
							<webwork:text name="'decimal.one.places.format'">
								<webwork:param value="benchmarkOldest.percentOfBenchmark"/>
							</webwork:text>
						</td>
					
					
				
					</tr>
					
					<tr>
					<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
					<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
						
					<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
					<td class="<webwork:property value="#displayClass"/>">
							<b><webwork:text name="'decimal.zero.places.format'">
								<webwork:param value="benchmarkRecent.index"/>
							</webwork:text>
							</b>
						</td>
						
					<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
						<td class="<webwork:property value="#displayClass"/>">
							<b><webwork:text name="'decimal.zero.places.format'">
								<webwork:param value="benchmarkMiddle.index"/>
							</webwork:text>
							</b>
						</td>
						
					<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
						<td class="<webwork:property value="#displayClass"/>">
						<b>	<webwork:text name="'decimal.zero.places.format'">
								<webwork:param value="benchmarkOldest.index"/>
							</webwork:text>
						</b>	
						</td>

					<td class="<webwork:property value="#displayClass"/>">&nbsp;</td>
						<td class="<webwork:property value="#displayClass"/>">
						<b>	<webwork:text name="'decimal.zero.places.format'">
								<webwork:param value="benchmarkOldest.index"/>
							</webwork:text>
						</b>	
						</td>
					
					</tr>
					
					
					
				</webwork:iterator>
				
				
</table>

 

	