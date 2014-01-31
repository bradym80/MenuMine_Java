<%@ taglib uri="webwork" prefix="webwork" %>


<table cellpadding="0" cellspacing="0"   >
<webwork:form theme="'simple'"method="'POST'" action="'menumineExpressSearch.action'" name="'expressSearch'">

		<tr>
			<td class="mainHeader" colspan="2" ><img src="img/triangle-bullet.gif" width="5" height="9">Express Search!</td>
		</tr>
		<tr>
 			<td>
 				<webwork:hidden  theme="'simple'"
 					name="'mineTypeOverride'"
 				 	value="menuMineSessionContextWrapper.mineFields.mineType"	
 				 />
				
				<webwork:textfield  theme="'simple'"
					size="75"
					 name="'expressSearchQuery'" 
					 value="expressSearchQuery" />
			</td>
			<td>		 
				<webwork:submit  theme="'simple'" name="'submit'" value="'Search'" />
			</td>
			<td align="left">
				<a href="#nowhere" class="mainMenu" onclick="javascript:toggle('expressHelp');" >
					<img border="0" src="img/helpimg.gif" alt="help" /> 
				</a>
				
				<div id="expressHelp" class="helpPopUp1" style="display:none;">
					<a href="#nowhere" class="helpLink" onclick="javascript:toggle('expressHelp');" >
					
					Express Search <I>finds all terms</I> you type in such that chicken gravy returns all 
					menu items with gravy <U>and</U> chicken.  Please add quotes for exact phrases to 
					find specific word combinations such as “chicken gravy” or “Olive Garden” or “mussels marinara”.  
					Express Search applies to the entire database unless user is in a specific database 
					such as Dessert or Ingredient or Beverage or Breakfast MenuMine.
					
					</a>
				</div>	
			</td>
		</tr>
	
					 
</webwork:form>	 
</table>	



