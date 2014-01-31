<%@ taglib uri="webwork" prefix="webwork"%>
<%-- 2006-05-04 RSC 
<table width="100%" cellspacing="0" cellpadding="0" border="0"  align="center">
	<tr><td width="25%"> &nbsp; </td>
	    <td width="50%" >
	    
	<table cellspacing="0" cellpadding="0" border="0" width="100%" align="center">
	<tr><td height="54" valign="bottom" align="right"><table cellspacing="0" cellpadding="0" border="0">


	<tr>
      	<td height="27">
      		<webwork:set name="displayStyle" value="'none;'"/>
      		<webwork:include page="_menuMineTabbedMenuRow1.jsp" />
      	</td>
	</tr>
	<tr>
      	<td height="27">
      		<webwork:set name="displayStyle" value="'background-image: url(img/background.png);background-position:right;background-repeat:no-repeat;border-bottom: thin solid #000000;'"/>
      		<webwork:include page="_menuMineTabbedMenuRow2.jsp" />
      	</td>
	</tr>
	</table>
</td>
	
    		<td  height="54" valign="bottom" align="left"><a class="menuLink" href="<webwork:url value="'/menumineNatlAccountBenchmark.action'" />"><webwork:if test="menuMineDisplayOptions.displayType == 'National Account Benchmark' || menuMineDisplayOptions.displayType == 'National Account Benchmark Table As Excel'"><img align="bottom" border="0" src="img/national-acct-bench-dblue.gif" alt="natl acct" /></webwork:if><webwork:else><img align="bottom" border="0" src="img/national-acct-bench-blue.gif" alt="natl acct" /></webwork:else></a></td>
			
	
    	
</tr>
</table>

</td>

	<td  width="25%" valign="top">&nbsp;
		<div id="spreadsheetHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink" onclick="javascript:toggle('spreadsheetHelp');" >Select data fields from the blue side bar at left and create your own spreadsheet
			</a>
		</div>
		<div id="menuShareHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink" onclick="javascript:toggle('menuShareHelp');" >Calculates a percentage for a single item relative to all items in a group -- thus if 100 of 1000 cheese items are Mozzarella then Mozzarella has a 10% menu share.  Statistical table and graph options availble.
			</a>
		</div>
		<div id="medianPriceTrendHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink" onclick="javascript:toggle('medianPriceTrendHelp');" >Median price is calculated for each item displayed in the Menu Share table.  Statistical table and graph options available. 
			</a>
		</div>
		<div id="meanPriceTrendHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink" onclick="javascript:toggle('meanPriceTrendHelp');" >Mean price is calculated for each item displayed in the Menu Share table.  Statistical table and graph options available. 
			</a>
		</div>	
		
		<div id="categoryIncidenceHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink" onclick="javascript:toggle('categoryIncidenceHelp');" >Category incidence shows what percentage of Market Sectors and Market Segments use an item, ingredient or flavor.  Statistical table and graph options availble.
			</a>
		</div>	
		<div id="itemsPerChainMenuingHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink" onclick="javascript:toggle('itemsPerChainMenuingHelp');" >This tab is a companion to Category Incidence. It literally shows the number of items per operation that are menuing the item.
			</a>
		</div>	
		<div id="crossTabHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink" onclick="javascript:toggle('crossTabHelp');" >You may relate any two data fields to determine the relative importance of one within the other.  Statistical table and graph options availble.
			</a>
		</div>	
		<div id="graphHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink" onclick="javascript:toggle('graphHelp');" >After creating a spreadsheet, users may select any single data field and have a pie chart or a bar chart created---basis is Menu Share statistic
			</a>
		</div>	
		<div id="nabHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink"  onclick="javascript:toggle('nabHelp');" >Benchmark allows the comparison of menu data on over twenty menu item characteristics. Sales presentation graphs are instantly available and suitable for pitches at chain headquarters.

			</a>
		</div>	
				
	</td>
</tr>



</table>
--%>
	<%-- 2006-05-04
	<webwork:if test="menuMineDisplayOptions.displayType != 'Reset'">
	--%>
		
			<%--
			<div id="menushareOptions" class="invisible">
				<webwork:include page="menushare/_menuMineDisplayStatisticalTableOptions.jsp" />
			</div>	
			<div id="spreadsheetOptions" class="invisible">
				<webwork:include page="spreadsheet/_menuMineDisplayResultsOptions.jsp" />
			</div>
			<div id="medianPriceTrendOptions" class="invisible">
				<webwork:include page="medianpricetrend/_menuMineDisplayAveragePriceTrendOptions.jsp" />		
			</div>
			<div id="meanPriceTrendOptions" class="invisible">
				<webwork:include page="meanpricetrend/_menuMineDisplayMeanPriceTrendOptions.jsp" />
			</div>
			<div id="categoryIncidenceOptions" class="invisible">
				<webwork:include page="categoryincidence/_menuMineCategoryIncidenceOptions.jsp" />
			</div>	
			<div id="itemsPerChainMenuingOptions" class="invisible">
				<webwork:include page="itemsperchainmenuing/_menuMineItemsPerChainMenuingOptions.jsp" />
			</div>	
			<div id="crossTabOptions" class="invisible">
				<webwork:include page="crosstabulation/_menuMineDisplayCrossTabulationOptions.jsp" />
			</div>	
			<div id="graphOptions" class="invisible">
				<webwork:include page="graph/_menuMineDisplayGraphOptions.jsp" />
			</div>	
			--%>
			<webwork:if test="specialFunction == 'NATLACCT'">
			<div id="generalOptions">
		 		<div id="nabOptions">
	 				<webwork:include page="natlaccountbench/_menuMineDisplayAccountBenchOptions.jsp" />
		 		</div>	
		 		</div>
			</webwork:if>		
			<webwork:if test="specialFunction == 'ROLLUP'">
			<div id="generalOptions">
		 		<div id="rollupOptions">
	 				<webwork:include page="rollup/_menuMineBuildRollUpOptions.jsp" />
		 		</div>	</div>
			</webwork:if>			
		</div>
		<%--2006-05-04 RSC
	</webwork:if>
	<webwork:else>
		<script type="text/javascript" language="javascript">
			toggleMainForm("mainFormDiv");
		</script>
	</webwork:else>--%>



