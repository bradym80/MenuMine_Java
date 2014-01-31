<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>	
</head>
<body >
<webwork:action name="'listCannedSchematic'" id="list">
</webwork:action>

<table align="center" class="menuOptions" width="100%"  >	
<tr>
	<td >
			<a class="largeFont" href="<webwork:url value="'menumineNatlAccountBenchmark.action'" />">
				Back to National Account Benchmark
			</a>
	</td>
	<td>
			<webwork:form  method="'POST'" theme="'simple'" action="'selectCannedSchematic.action'" name="'selectCannedSchematic'">
				Load Canned Schematic: <webwork:select theme="'simple'" name="'target'"  value="targetInstance.id" list="#list.list" listKey="id" listValue="name" emptyOption="'true'" 
				onchange="'document.selectCannedSchematic.submit();'"/>
				<%--
				<webwork:submit  theme="'simple'" name="'submit'" value="'Load'" />
				--%>
			</webwork:form>
		</td>
		<td>
			<a href="<webwork:url value="'newCannedSchematic.action'" >
			</webwork:url>">New Canned Schematic</a>
		</td>
</tr>
</table>

<webwork:if test="menuMineSessionContextWrapper.errorContext.hasErrors()">
<table>
	<webwork:iterator value="menuMineSessionContextWrapper.errorContext.errors" status="mestatus">
	<tr>
		<td>
		  <font color="red"> <webwork:property value="message"/> </font>
		</td>
	</tr>
	</webwork:iterator>
</table>
</webwork:if>





<webwork:if test="targetInstance != null">
	<font class="largeFont">
	<webwork:form  method="'POST'" theme="'simple'" action="'editCannedSchematic.action'" name="'menuMineRollUpFilter'">
	 	Name:<webwork:textfield theme="'simple'" name="'targetInstance.name'" value="targetInstance.name" />
		<br/>

		Include Benchmark: <webwork:checkbox theme="'simple'"  name="'webParameters.includeBenchmark'" value="targetInstance.includeBenchmark" fieldValue="'true'"/>
		Include Benchmark Trend: <webwork:checkbox theme="'simple'"  name="'webParameters.includeBenchmarkTrend'" value="targetInstance.includeBenchmarkTrend" fieldValue="'true'"/>
	
		Include Benchmark Graph: <webwork:checkbox theme="'simple'" name="'webParameters.includeBenchmarkGraph'" value="targetInstance.includeBenchmarkGraph" fieldValue="'true'"/>
	
		
		<br/>
	
		<webwork:checkboxlist  theme="'simple'" name="'targetInstance.fieldKeys'"  list="menuMineSessionContextWrapper.mineFields.allFields" listKey="ognlName" listValue="friendlyName" />
		<webwork:submit  theme="'simple'" name="'submitRollUp'" value="'Save'" />
	</webwork:form>
	</font>
</webwork:if >	
</body>
</html>