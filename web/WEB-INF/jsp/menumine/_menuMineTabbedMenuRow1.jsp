<%@ taglib uri="webwork" prefix="webwork" %>

<table cellspacing="0" cellpadding="0" border="0"  align="center">
	<tr>
			
		<td style="<webwork:property value="#displayStyle"/>"> 
			<a onmouseover="javascript:toggle('spreadsheetHelp');" 
			   onmouseout="javascript:toggle('spreadsheetHelp');" 
			    onclick="javascript:toggle('spreadsheetOptions');"  
			class="menuLink" ><webwork:if test="menuMineDisplayOptions.displayType == 'Display Spreadsheet' ||
				menuMineDisplayOptions.displayType == 'Download Excel'"><img align="bottom" border="0" src="img/tab-spreadsheet-active.png" alt="" /></webwork:if><webwork:else><img align="bottom" border="0" src="img/tab-spreadsheet.png" alt="" /></webwork:else></a></td>
				
		<td style="<webwork:property value="#displayStyle"/>"> 
			<a onmouseover="javascript:toggle('menuShareHelp');"  
			   onmouseout="javascript:toggle('menuShareHelp');"  
			    onclick="javascript:toggle('menushareOptions');"  
			class="menuLink" ><webwork:if test="menuMineDisplayOptions.displayType == 'Statistical Table' || menuMineDisplayOptions.displayType == 'Download Excel'"><img align="bottom" border="0" src="img/tab-menushare-active.png" alt="" /></webwork:if><webwork:else><img align="bottom" border="0" src="img/tab-menushare.png" alt="" /></webwork:else></a></td>
			
		<td style="<webwork:property value="#displayStyle"/>"> 
			<a onmouseover="javascript:toggle('medianPriceTrendHelp');" 
			   onmouseout="javascript:toggle('medianPriceTrendHelp');" 
			   onclick="javascript:toggle('medianPriceTrendOptions');" 
			class="menuLink" ><webwork:if test="menuMineDisplayOptions.displayType == 'Median Price Trend' || menuMineDisplayOptions.displayType == 'View Median Trendline'"><img align="bottom" border="0" src="img/tab-median-active.png" alt="" /></webwork:if><webwork:else><img align="bottom" border="0" src="img/tab-median.png" alt="" /></webwork:else></a></td>		 

		<td style="<webwork:property value="#displayStyle"/>"> 
			<a  onmouseover="javascript:toggle('meanPriceTrendHelp');" 
			   onmouseout="javascript:toggle('meanPriceTrendHelp');"
			   onclick="javascript:toggle('meanPriceTrendOptions');" 
			class="menuLink" ><webwork:if test="menuMineDisplayOptions.displayType == 'Mean Price Trend' || menuMineDisplayOptions.displayType == 'View Mean Trendline'"><img align="bottom" border="0" src="img/tab-mean-active.png" alt="" /></webwork:if><webwork:else><img align="bottom" border="0" src="img/tab-mean.png" alt="" /></webwork:else></a></td>				
			
	</tr>
</table>