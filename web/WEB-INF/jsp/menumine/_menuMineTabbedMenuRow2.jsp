<%@ taglib uri="webwork" prefix="webwork" %>

<table cellspacing="0" cellpadding="0" border="0"  align="center">
	<tr>
			
		<td style="<webwork:property value="#displayStyle"/>"> 
			<a  onmouseover="javascript:toggle('categoryIncidenceHelp');" 
			   onmouseout="javascript:toggle('categoryIncidenceHelp');"
			    onclick="javascript:toggle('categoryIncidenceOptions');"
			class="menuLink" ><webwork:if test="menuMineDisplayOptions.displayType.indexOf('Category Incidence') >-1 "><img align="bottom" border="0" src="img/tab-category-active.png" alt="" /></webwork:if><webwork:else><img align="bottom"  border="0" src="img/tab-category.png" alt="" /></webwork:else></a></td>

		<td  style="<webwork:property value="#displayStyle"/>"> 
			<a onmouseover="javascript:toggle('itemsPerChainMenuingHelp');" 
			   onmouseout="javascript:toggle('itemsPerChainMenuingHelp');"  
			   onclick="javascript:toggle('itemsPerChainMenuingOptions');"
			class="menuLink"><webwork:if test="menuMineDisplayOptions.displayType.indexOf('Items Per Chain Menuing') >-1"> <img  align="bottom" border="0" src="img/tab-items-active.png" alt="" /></webwork:if><webwork:else><img align="bottom" border="0"  src="img/tab-items.png" alt="" /></webwork:else></a></td>	
					
		<td  style="<webwork:property value="#displayStyle"/>"> 
			<a  onmouseover="javascript:toggle('crossTabHelp');" 
			   onmouseout="javascript:toggle('crossTabHelp');"  
			   onclick="javascript:toggle('crossTabOptions');"
			class="menuLink" ><webwork:if test="menuMineDisplayOptions.displayType.indexOf('Cross Tab') >-1"><img align="bottom" border="0" src="img/tab-cross-active.png" alt="" /></webwork:if><webwork:else><img align="bottom" border="0" src="img/tab-cross.png" alt="" /></webwork:else></a></td>		
			
		<td  style="<webwork:property value="#displayStyle"/>"> 
			<a onmouseover="javascript:toggle('graphHelp');" 
			   onmouseout="javascript:toggle('graphHelp');" 
			    onclick="javascript:toggle('graphOptions');"
			  class="menuLink" ><webwork:if test="menuMineDisplayOptions.displayType == 'Graph'"><img align="bottom" border="0" src="img/tab-graph-active.png" alt="" /></webwork:if><webwork:else><img align="bottom"  border="0" src="img/tab-graph.png" alt="" /></webwork:else></a></td>		

	</tr>
	
	</table>