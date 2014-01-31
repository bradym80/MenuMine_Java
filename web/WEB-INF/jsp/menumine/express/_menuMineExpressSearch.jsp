<%@ taglib uri="webwork" prefix="webwork"  %>


<webwork:form theme="'simple'" method="'post'" action="'menumineExpressSearch.action'" name="'expressSearch'">
	<table cellpadding="0" cellspacing="0"  border="0" >

		<tr>
 			<td >
				 <webwork:textfield  theme="'simple'"
					size="50"
					 name="'searchString'" 
					 value="searchString" />
			<input type="hidden" name="expressDisplayType" value="opportunities" />

					 
			</td>
			<td align="left" valign="top">
				<webwork:submit  theme="'simple'" name="'submit'" value="'Search'" />
<!-- 06-19-08 MJB Removed stupid question mark
				<a href="#nowhere" class="mainMenu" onclick="javascript:toggle('expressHelp');" >
					<img border="0" src="img/helpimg.gif" alt="help" /> 
				</a>
				
				<div id="expressHelp" class="helpPopUp1" style="display:none;">
					<a href="#nowhere" class="helpLink" onclick="javascript:toggle('expressHelp');" >
					Express Search is used to get your query going quickly.  It attempts to find the 
					best field for each term entered.  
					<br/>
					
					Express Search <em>finds all terms</em> you type in such that chicken gravy returns all 
					menu items with gravy <em>and</em> chicken.  Please add quotes for exact phrases to 
					find specific word combinations such as ?chicken gravy? or ?Olive Garden? or ?mussels marinara?.  
					Express Search applies to the entire database unless user is in a specific database 
					such as Dessert or Ingredient or Beverage or Breakfast MenuMine.
					
					
					</a>
				</div>	-->
							</td>
		</tr>
		<tr>
			<td colspan="2">		 
				
			</td>
			
		</tr>
	</table>					 
</webwork:form>	 

<script type="text/javascript" language="JavaScript">
  <!--
	document.expressSearch.searchString.focus();
  // -->
</script>

