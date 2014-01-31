<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
</head>



<body>



<form  action="/menumine/menumine.action" method="post" name="menuMine" id="menuMine">
<input type='hidden' name="fieldsToDisplay.genMenuPart" value="true"/>
<input type='hidden' name="masterFoodFilterParameters.genMenuPart.inValues" value="Appetizer"/>


<input type='hidden' name="fieldsToDisplay.cookMeth" value="true"/>
<input type='hidden' name="fieldsToDisplay.basicProtein" value="true"/>

<input type='hidden' name="masterFoodFilterParameters.basicProtein.inValues" value="Beef"/>

<input type='hidden' name="masterFoodFilterParameters.chainFilterParameters.sectorName.inValues" value="Casual Chain Sector"/>

<input type='hidden' name="fieldsToDisplay.sauceCondDressMarMM" value="true"/>


<input type='hidden' name="menuMineDisplayOptions.sortBy" value="cookMeth"/>
<input type='hidden' name="menuMineDisplayOptions.sortType" value="DESC"/>

<input type='hidden' name="menuMineDisplayOptions.displayType" value="Display Spreadsheet"/>

</form>

<table width="100%">
	<tr>
		<td align="left">
				<img src="img/redAppleLogo_75.gif">
		</td>
	
		<td>	
			Please wait while the Sample Spreadsheet loads . . .
		</td>
	</tr>
<table>

<script type="text/javascript" language="javascript">
javascript:document.forms['menuMine'].submit();
</script>

</body>
</html>