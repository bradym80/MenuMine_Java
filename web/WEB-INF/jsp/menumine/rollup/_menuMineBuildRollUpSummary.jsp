<%@ taglib uri="webwork" prefix="webwork" %>

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

<%-- Allow users to remove roll up entries--%>

 <a  class="smallFont" href="#nowhere" onclick="javascript:confirmReset('<webwork:url value="'resetRollUp.action'" />');" >
	Reset
</a>

<table  class="smallFont" >
<tr><th>Labels</th><th>Roll Up Terms</th></tr>



<webwork:iterator value="sortedSummary" status="mestatus">


	

<webwork:if test="#currentLabel != label">
		<webwork:set name="currentLabel" value="label"/>
		</span>
		</td>
		</tr>
<tr>

	<td valign="top">
		<webwork:property value="label"/>
		       <a href="#nowhere" onclick="javascript:confirmRemove('<webwork:url value="'removeRollUpByLabel.action'" > <webwork:param name="'target'" value="label" /> </webwork:url>'	);" >
						<br/>(remove all)
			</a>
		
			 <a href="#nowhere" onclick="javascript:confirmEliminate('<webwork:url value="'addFilterEliminatorFromRollUp.action'" > <webwork:param name="'target'" value="label" /> </webwork:url>');" >
						<br/>(eliminate all)
			</a>
		
		

	
	
	</td>
	<td  valign="top">
	
	
		<a href="#nowhere" onclick="javascript:toggle('<webwork:property value="label"/>Div');" >
			<img id="<webwork:property value="label"/>Div_image"  border="0" src="img/expand.gif" alt="expand" />  Toggle Terms
		</a> 
		<span id="<webwork:property value="label"/>Div" style="display:none; ">
	
	

		<webwork:property value="term"/> <a  href="<webwork:url value="'removeRollUp.action'" > <webwork:param name="'target'" value="term" /> </webwork:url>">
				(remove)<br/>
		</a>
	

	
</webwork:if>
<webwork:else>

		<webwork:property value="term"/> <a  href="<webwork:url value="'removeRollUp.action'" > <webwork:param name="'target'" value="term" /> </webwork:url>">
				(remove)<br/>
		</a>
	


</webwork:else>


</webwork:iterator>
</span>
</table>