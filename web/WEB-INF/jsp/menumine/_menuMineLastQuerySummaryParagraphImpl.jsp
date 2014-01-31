<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:if test= "lastQuerySummary.size() > 0" >

<table>
	 <tr>
	 	<td class="smallFont"> 
			<a href="#nowhere" onclick="javascript:toggle('querySummaryDiv');" >
				<img id="querySummaryDiv_image"  border="0" src="img/expand.gif" alt="expand" />
			</a>            
		</td>
		<td class="smallFont">
			Show Query Summary <webwork:property value="selectHistory"/>
		</td>
	</tr>
</table>				
<div id="querySummaryDiv" style="display:none; ">
							
<table><tr>
<webwork:iterator value="lastQuerySummary" status="mestatus">

	
		<td class="smallFont" valign="top">
			<label  style="font-size:11;font-weight:bold;" >
			<webwork:property value="field.friendlyName"/>
			</label>
			<br/>
	
			<b>AND: </b>
			<webwork:iterator value="selection">
				<br/><webwork:property value="top"/>
			</webwork:iterator>
			<webwork:iterator value="typeIn">
				<br/><webwork:property value="top"/>
			</webwork:iterator>
			<webwork:if test= "selection.size()== 0  && typeIn.size()== 0" >
				N/A
			</webwork:if>
			
			
			
			<br/>
			<b>OR: </b>
			<webwork:iterator value="orValues">
				<br/><webwork:property value="top"/>
			</webwork:iterator>
			<webwork:if test= "orValues.size()== 0" >
				N/A
			</webwork:if>
			
			<br/>
			<b>NOT : </b>
			<webwork:iterator value="notValues">
				<br/><webwork:property value="top"/>
			</webwork:iterator>
			<webwork:if test= "notValues.size()== 0" >
				N/A
			</webwork:if>
			
			<br/>
			<b>only populated records shown for this field: </b>
		
			<webwork:if test= "empty==null" >
				N/A
			</webwork:if>
			<webwork:else>
				<webwork:property value="empty"/>
			</webwork:else>
		</td>
		
		<webwork:if test= "#mestatus.modulus(5)  == 0" >
		</tr>
		<tr>
		</webwork:if>
	
</webwork:iterator>
</tr>

</table>

</div>

</webwork:if>