<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
</head>



<body>
<table>
	<tr>
		<td class="smallFont" >
			<a  onclick="javascript:toggle('chainStatHelp');"    
			href="#nowhere">What is Chain Stat?</a>
			<div id="chainStatHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink"  onclick="javascript:toggle('chainStatHelp');" >ChainStat contains corporate information on chains in the database. This information includes sales, corporate HQ address, number of units and geographic dispersion.
			</a>
		</div>	
		</td>
	</tr>
</table>	
<p>&nbsp;</p>


<webwork:include page="_chainStatForm.jsp" />

<table width="100%">

<tr>
<th class="chainStatHeader" >&nbsp; </th>
<th class="chainStatHeader" colspan="2">Chain Name</th>
<th class="chainStatHeader">City</th>
<th class="chainStatHeader" >State</th>
<th class="chainStatHeader" >Web Site</th>
<th class="chainStatHeader" >Segment</th>
<th class="chainStatHeader" >Sector</th>


</tr>
	<webwork:iterator value="list" status="mestatus">
	
		<webwork:if test="#mestatus.modulus(10) <= 5 && #mestatus.modulus(10) != 0">
			<webwork:set name="displayClass" value="'results_cellA'"/>
		</webwork:if>
		<webwork:else>
			<webwork:set name="displayClass" value="'results_cellB'"/>			
		</webwork:else>
	
	<tr>
		<td class="<webwork:property value="#displayClass"/>"><webwork:property value="#mestatus.count"/> </td>
		 
		
		<td class="<webwork:property value="#displayClass"/>">
			<a href="<webwork:url value="'/chainStatDetail.action'" >
					<webwork:param name="'target'" value="id" /></webwork:url>"><webwork:property value="operationName"/> </a>
					
			
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:if test="chainStateCount!=null">		
			<a   href="<webwork:url value="'/chainMap.action'" >
					<webwork:param name="'target'" value="operationName" /></webwork:url>" class="javascriptLink">
				<img src="img/map2.gif" border="0" alt="Display Chain Map"/></a>
			</webwork:if>
			&nbsp;
			
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:property value="hqCity"/> 
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:property value="hqState"/> 
		</td>
		<td class="<webwork:property value="#displayClass"/>">
			   <a href="http://<webwork:property value="webSite"/>"><webwork:property value="webSite"/></a>  

		</td>
		<td class="<webwork:property value="#displayClass"/>">
			<webwork:property value="segment"/> 
		</td>
				<td class="<webwork:property value="#displayClass"/>">
			<webwork:property value="sectorName"/> 
		</td>	
	</tr>
	</webwork:iterator>
</table>


</body>
</html>