<%@ taglib uri="webwork" prefix="webwork" %>

<p class="smallFont">
| <a class="menuLink" href="<webwork:url value="'/menuBookTrend.action'" />">Full Trend</a>
| <a class="menuLink" href="<webwork:url value="'/menuBookTrendMenuPart.action'" />">Menu Part Roll Up</a>
| <a class="menuLink" href="<webwork:url value="'/menuBookTrendGraphBuilder.action'" />">Graph</a>		
| <a class="menuLink" href="<webwork:url value="'/menuBookTrendExcel.xls'" />">Excel</a>		
| <a  onclick="javascript:toggle('menuBookTrendHelp');" 
			href="#nowhere">What are MenuBook Trends?</a>
			<div id="menuBookTrendHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink"  onclick="javascript:toggle('menuBookTrendHelp');" >MenuBook Trends expand on MenuBook by showing the price and availability of the items on the menu going back to 1996, the first year the data was collected for a particular operator.

			</a>
		</div>	

<br/>
<h3 align="center">MenuBook<sup>TM</sup> Trend: <webwork:property value="menuBook.chain.operationName"/> </h3>
<h4  align="center">Sector:  <webwork:property value="menuBook.chain.sectorName"/> &nbsp&nbsp&nbsp&nbsp&nbsp
Segment:  <webwork:property value="menuBook.chain.segment"/><h4>