<%@ taglib uri="webwork" prefix="webwork" %>
<script type="text/javascript" language="javascript">
<!--
//We can only graph Benchmarks, So we deactivate the button for trends.
function toggleGraphButton(){
if(document.menuMineNABForm.benchmarkType.value=="benchmark")
{
document.menuMineNABForm.submitOptions[1].disabled=false;
}else{
document.menuMineNABForm.submitOptions[1].disabled=true;
}
}
-->
</script>


<h3>National Account Benchmark Options</h3>
<webwork:form theme="'simple'" method="'post'" action="'menumineNatlAccountBenchmark.action'" name="'menuMineNABForm'">
<table >	
	<tr>
	 	<td >Group By Field</td>
	 	<td >Type</td>
	 	<td >Title</td>

	</tr>
	<tr>
		<td >
			<webwork:select theme="'simple'"
					cssClass="'graphFields'"
					name="'menuMineGraphOptions.graphByField'"
					value="groupByField" 
					listKey="key"  
					listValue="value" 
					list="groupByFieldOptions"  
					multiple="'false'"  
					emptyOption="'false'"
					onchange="'document.menuMineNABForm.submitOptions[0].click();'"/>
		</td>
		<td >
				<webwork:select theme="'simple'"
					cssClass="'graphFields'"
					name="'benchmarkType'"
					value="benchmarkType" 
					list="#{'benchmark':'Benchmark','benchmark.trend':'Benchmark Trends'}" 
					multiple="'false'" 
					emptyOption="'false'"
					onchange="'javascript:toggleGraphButton()'"/>
					
		</td>
		<td >
				<webwork:textfield  theme="'simple'"
					cssClass="'graphFields'"	
					name="'menuMineDisplayOptions.title'" 
					value="menuMineDisplayOptions.title" />
		</td>
	</tr>
	<tr>
		<td >
			<webwork:submit  cssClass="'graphFields'" theme="'simple'" id="'sub'" name="'submitOptions'" value="'Display Table'" /></td>
		<td >
			<webwork:submit  cssClass="'graphFields'" theme="'simple'" name="'submitOptions'" value="'Graph'" />
		</td>
		<td ></td>	
		</td>

	</tr>
</table>

<table>
<tr>
	<td width="50%" class="nabOptionLabel" align="center">
		<h3>Target</h3>
	</td>
	<td width="50%" class="nabOptionLabel" align="center">
		<h3>Benchmark</h3>
	</td>
</tr>
<tr>
<td valign="top" align="center">
	<table   >
		<tr>
			<td>
				<webwork:select theme="'simple'"
					cssClass="'graphFields'"
					name="'nationalAccountBenchmarkWebOptions.targetSectors'"
					value="nationalAccountBenchmarkWebOptions.targetSectors" 
					list="nationalAccountBenchmarkWebOptions.targetSectorsOptions"
					listKey="name" 
					listValue="name" 
					size="'4'"
					multiple="'true'" 
					emptyOption="'false'"
					onchange="'javascript:updateTarget();'" />
			</td>
			
			<td rowspan="2">
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'nationalAccountBenchmarkWebOptions.targetChains'"
				value="nationalAccountBenchmarkWebOptions.targetChains" 
				list="nationalAccountBenchmarkWebOptions.targetChainsOptions" 
				listKey="name" 
				listValue="name" 				
				size="'12'"
				multiple="'true'" 
				emptyOption="'false'"
				/>
			</td>
			
		</tr>

		<tr>
			<td>
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'nationalAccountBenchmarkWebOptions.targetSegments'"
				value="nationalAccountBenchmarkWebOptions.targetSegments" 
				list="nationalAccountBenchmarkWebOptions.targetSegmentsOptions" 
				listKey="name" 
				listValue="name" 				
				size="'6'"
				multiple="'true'" 
				emptyOption="'false'"
				onchange="'javascript:updateTarget();'" 
				/>
			</td>
		</tr>

	</table>
</td>		
<!-- Benchmark Options -->	
<td valign="top" align="center">
	<table   align="center" >
		<tr>
			<td rowspan="2">
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'nationalAccountBenchmarkWebOptions.benchmarkChains'"
				value="nationalAccountBenchmarkWebOptions.benchmarkChains" 
				listKey="name" 
				listValue="name" 
				list="nationalAccountBenchmarkWebOptions.benchmarkChainsOptions" 
				size="'12'"
				multiple="'true'" 
				emptyOption="'false'"
				/>
			</td>
			<td>
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'nationalAccountBenchmarkWebOptions.benchmarkSectors'"
				value="nationalAccountBenchmarkWebOptions.benchmarkSectors" 
				listKey="name" 
				listValue="name" 
				list="nationalAccountBenchmarkWebOptions.benchmarkSectorsOptions"
				size="'4'"
				multiple="'true'" 
				emptyOption="'false'"
				onchange="'javascript:updateBenchmark();'" 
				/>
			</td>			
		</tr>
		<tr>
			<td>
				<webwork:select theme="'simple'"
				cssClass="'graphFields'"
				name="'nationalAccountBenchmarkWebOptions.benchmarkSegments'"
				value="nationalAccountBenchmarkWebOptions.benchmarkSegments" 
				list="nationalAccountBenchmarkWebOptions.benchmarkSegmentsOptions" 
				listKey="name" 
				listValue="name" 
				size="'6'"
				multiple="'true'" 
				emptyOption="'false'"
				onchange="'javascript:updateBenchmark();'" 
				/>
			</td>
		</tr>
	</table>
</td>
</tr>
</table>
</webwork:form>
<script type="text/javascript" language="javascript">
javascript:toggleGraphButton();
</script>
	