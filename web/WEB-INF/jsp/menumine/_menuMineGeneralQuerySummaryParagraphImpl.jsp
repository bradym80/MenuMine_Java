<%@ taglib uri="webwork" prefix="webwork" %>

<webwork:if test= "#querySummary!= null && #querySummary.size() > 0" >

<table>
	 <tr>
	 	<td class="smallFont"> 
			<a href="#nowhere" onclick="javascript:toggle('Div<webwork:property value="name"/>');" >
				<img id="Div<webwork:property value="name"/>_image"  border="0" src="img/expand.gif" alt="" />
			</a>            
		</td>
		<td class="smallFont">
			Show Query Summary 
		</td>
	</tr>
</table>				
<div id="Div<webwork:property value="name"/>" style="display:none; ">
							
<table><tr>
<webwork:iterator value="#querySummary" status="mestatus">

	
		<td class="smallFont" valign="top">
			<label  style="font-size:11;font-weight:bold;" >
			<webwork:property value="field.friendlyName"/>
			</label>
			<br/>
	
			<b>Selections: </b>
			<webwork:iterator value="selection">
				<br/><webwork:property value="top"/>
			</webwork:iterator>
			<webwork:if test= "selection.size()== 0" >
				N/A
			</webwork:if>
			
			<br/>
			<b>Limiters: </b>
			<webwork:iterator value="typeIn">
				<br/><webwork:property value="top"/>
			</webwork:iterator>
			<webwork:if test= "typeIn.size()== 0" >
				N/A
			</webwork:if>
			
			<br/>
			<b>Expanders: </b>
			<webwork:iterator value="orValues">
				<br/><webwork:property value="top"/>
			</webwork:iterator>
			<webwork:if test= "orValues.size()== 0" >
				N/A
			</webwork:if>
			
			<br/>
			<b>Eliminators: </b>
			<webwork:iterator value="notValues">
				<br/><webwork:property value="top"/>
			</webwork:iterator>
			<webwork:if test= "notValues.size()== 0" >
				N/A
			</webwork:if>
			
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