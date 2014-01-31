<%@ taglib uri="webwork" prefix="webwork"%>
<html>
<head>
<title>Market Size Projector</title>
</head>
<body>
<table width="100%"><tr><td align="center"  class="spreadsheetTitle">Market Size Projector</td></tr></table>

<webwork:form method="'post'" action="'menumineMarketSizeProjector.action'" theme="'simple'">

<table>
	<tr>
		<td>&nbsp;</td>
		<td>Servings Per Day</td>
		<td>Ounces Per Serving</td>
		<td>Menu Cycle</td>
	</tr>
	<tr>
		<td>Chains</td>
		<td><webwork:textfield name="'options.chainOptions.servingsPerDay'" value="options.chainOptions.servingsPerDay" theme="'simple'" /> </td>
		<td><webwork:textfield name="'options.chainOptions.ouncesPerServing'" value="options.chainOptions.ouncesPerServing" theme="'simple'" /></td>
		<td><webwork:textfield name="'options.chainOptions.menuCycle'" value="options.chainOptions.menuCycle" theme="'simple'" /></td>
	</tr>
	<tr>
		<td>Independents</td>
		<td><webwork:textfield name="'options.independentOptions.servingsPerDay'" value="options.independentOptions.servingsPerDay" theme="'simple'" /> </td>
		<td><webwork:textfield name="'options.independentOptions.ouncesPerServing'" value="options.independentOptions.ouncesPerServing" theme="'simple'" /></td>
		<td><webwork:textfield name="'options.independentOptions.menuCycle'" value="options.independentOptions.menuCycle" theme="'simple'" /></td>
	</tr>
	<tr>
		<td>Non-Commercial</td>
		<td><webwork:textfield name="'options.nonCommercialOptions.servingsPerDay'" value="options.nonCommercialOptions.servingsPerDay" theme="'simple'" /> </td>
		<td><webwork:textfield name="'options.nonCommercialOptions.ouncesPerServing'" value="options.nonCommercialOptions.ouncesPerServing" theme="'simple'" /></td>
		<td><webwork:textfield name="'options.nonCommercialOptions.menuCycle'" value="options.nonCommercialOptions.menuCycle" theme="'simple'" /></td>
	</tr>
</table>

<p>Results as: <input type="radio" name="options.resultMeasurement" value="weight" <webwork:if test="options.resultMeasurement == 'weight'">checked</webwork:if> />weight (results converted to pounds) <input type="radio" name="options.resultMeasurement" value="volume" <webwork:if test="options.resultMeasurement != 'weight'">checked</webwork:if>  />volume (results converted to gallons)</p>

<p><input type="submit" name="submitMarketSize" value="Generate Table" />

<webwork:set name="excelFile" value="'/menumineDisplayMarketSizeProjectorAsExcel.xls'"/>
<webwork:set name="isAll" value="'true'"/>
<webwork:set name="isTrend" value="'true'"/>
<webwork:set name="isCut" value="'true'"/>
<webwork:set name="isPie" value="'true'"/>
<webwork:set name="isBar" value="'true'"/>
<webwork:if test="chainStat.chainStateCount!=null">	
    <webwork:set name="isMap" value="'true'"/>
</webwork:if>
<webwork:else>
    <webwork:set name="isMap" value="'false'"/>
</webwork:else>	
<webwork:if test="marketSizeTable != null">
	<webwork:set name="isExcel" value="'true'"/>
	
	<input type="submit" name="submitMarketSizePie" value="Pie Chart" />
	
	<input type="submit" name="submitMarketSizeBar" value="Bar Chart" />

	<!--<br/><a href="<webwork:url value="'menumineDisplayMarketSizeProjectorAsExcel.xls'" />">Download current table as Excel</a>-->
	
</webwork:if>

</p>
</webwork:form>

<webwork:if test="marketSizeTable != null">


<table>
	<tr>
		<th>Name</th>
		<th>Operators</th>
		<th>Menu Item</th>
		<th>Category Incidence</th>
		<th>Units in Universe</th>
		<th>Servings Per Day (est)</th>
		<th>Ounces Per Serving (est)</th>
		<th>Menu Cycle</th>
		<th>Projected Market (<webwork:property value="options.resultLabel" />)</th>
		<th>Volume Share</th>
	</tr>
		<tr>
			<td class="incidenceSector">Grand Totals</td>
			<td class="incidenceSector"><webwork:property value="marketSizeTable.totals.numberOfChainsInSector" />
			</td>
			<td class="incidenceSector"><webwork:property
				value="marketSizeTable.totals.numberOfChainsMenuingItems" /></td>
			<td class="incidenceSector"><webwork:text
				name="'percent.one.places.format'">
				<webwork:param value="marketSizeTable.totals.categoryIncidence" />
			</webwork:text></td>
				<td class="incidenceSector"><webwork:property value="marketSizeTable.totals.unitsInUniverse" /></td>
				<td class="incidenceSector"></td>
				<td class="incidenceSector"></td>
				<td class="incidenceSector"></td>
				<td class="incidenceSector"><webwork:text
				name="'decimal.zero.places.format'">
				<webwork:param value="marketSizeTable.totals.projectedMarketSize" />
				</webwork:text></td>
				<td class="incidenceSector">(<webwork:property value="options.resultLabel" />)
				</td>
		</tr>
	<webwork:set name="displayClass" value="'results_cellB'" />
	<webwork:iterator value="marketSizeTable.incidenceSectors"
		status="mestatus">

		<webwork:iterator value="incidenceSegments" status="mestatus">

			<tr>
				<td class="results_cellB"><webwork:property value="name" /></td>
				<td class="results_cellB"><webwork:property value="numberOfChains" />
				</td>
				<td class="results_cellB"><webwork:property
					value="numberOfChainsMenuingItems" /></td>
				<td class="results_cellB"><webwork:text
					name="'decimal.one.places.format'">
					<webwork:param value="categoryIncidence" />
				</webwork:text></td>
				<td class="results_cellB"><webwork:property value="unitsInUniverse" /></td>
				<td class="results_cellB"><webwork:property value="servingsPerDay" /></td>
				<td class="results_cellB"><webwork:property value="ouncesPerServing" /></td>
				<td class="results_cellB"><webwork:property value="menuCycle" /></td>
				<td class="results_cellB"><webwork:text
				name="'decimal.zero.places.format'">
				<webwork:param value="projectedMarketSize" />
				</webwork:text></td>
				<td class="results_cellB"><webwork:text
				name="'percent.one.places.format'">
				<webwork:param value="overallShare" />
				</webwork:text></td>



			</tr>
		</webwork:iterator>

		<tr>
			<td class="incidenceSector"><webwork:property value="name" /></td>
			<td class="incidenceSector"><webwork:property value="numberOfChains" />
			</td>
			<td class="incidenceSector"><webwork:property
				value="numberOfChainsMenuingItems" /></td>
			<td class="incidenceSector"><webwork:text
				name="'decimal.one.places.format'">
				<webwork:param value="categoryIncidence" />
			</webwork:text></td>
				<td class="incidenceSector"><webwork:property value="unitsInUniverse" /></td>
				<td class="incidenceSector"></td>
				<td class="incidenceSector"></td>
				<td class="incidenceSector"></td>
				<td class="incidenceSector"><webwork:text
				name="'decimal.zero.places.format'">
				<webwork:param value="projectedMarketSize" />
				</webwork:text></td>
				<td class="incidenceSector"><webwork:text
				name="'percent.one.places.format'">
				<webwork:param value="overallShare" />
				</webwork:text>
				</td>
		</tr>
	</webwork:iterator>
		<tr>
			<td class="incidenceSector">Grand Totals</td>
			<td class="incidenceSector"><webwork:property value="marketSizeTable.totals.numberOfChainsInSector" />
			</td>
			<td class="incidenceSector"><webwork:property
				value="marketSizeTable.totals.numberOfChainsMenuingItems" /></td>
			<td class="incidenceSector"><webwork:text
				name="'percent.one.places.format'">
				<webwork:param value="marketSizeTable.totals.categoryIncidence" />
			</webwork:text></td>
				<td class="incidenceSector"><webwork:property value="marketSizeTable.totals.unitsInUniverse" /></td>
				<td class="incidenceSector"></td>
				<td class="incidenceSector"></td>
				<td class="incidenceSector"></td>
				<td class="incidenceSector"><webwork:text
				name="'decimal.zero.places.format'">
				<webwork:param value="marketSizeTable.totals.projectedMarketSize" />
				</webwork:text></td>
				<td class="incidenceSector">(<webwork:property value="options.resultLabel" />)
				</td>
		</tr>


</table>
</webwork:if>

<p><u>Determine Market Size of Any Item:</u> MenuMine may be used to calculate a Market Size Projection for any food ingredient or menu item.  Results are projected on the basis of annual pounds used by each market segment. The MenuMine sample base is representative of the US Foodservice marketplace.  Category incidence data is a calculated percentage based on actual menu data.  A few ingredients, such as deep frying oil or butter may be used in item preparation and not always listed on the menu.  However, for these items, indirect methods may be substituted, including using the category incidence statistic for all deep fried foods.  </p>

<p><u>Three Estimates Needed:</u>  To make a Market Size Projection, you will be required to provide three estimates, as follows: 1) average servings per day of an ingredient,  2) ounces per average serving,  3) estimated menu cycle for institutions.  MenuMine automatically does the math.  If your projection is too high, modify your input.  MSP may be used for flavor variations also, whereby an estimate is made for an aggregate category, such as gravy, and then for each component flavor such as chicken gravy, beef gravy and turkey gravy.  </p>

<p><u>Meals Per Day:</u>  Restaurant Chains, on average, serve 300 to 600 meals per day, while Independent Restaurants serve about 250 to 350 meals per day.  Institutions including schools and colleges, B&I and healthcare serve in the range of 500 to 1500 meals per day.  In the process of estimating servings per day of a specific item, it is important to recognize that most operations are going to have an average of 50 to 75 items on the menu. The estimate you provide of Servings Per Day of a Specified Item should be conservative and should not exceed the average meals per day specified above.  For institutions, it may be best not to estimate more than 500 servings per day since many institutions have 5 to 10 or more menu selections offered daily.</p>

<p><u>Ounces Per Serving:</u>  Your estimate of Ounces Per Serving varies by product category.  For protein items, an estimate of 3 to 5 ounces per serving may be best, but if but if you are filtering your data to include only Quarter Pound Burgers, use 4 ounces exactly.  Center of Plate steaks such as Ribeye and Strip Steaks may call for an estimate of 8 to 10 ounces.  For Dipping Sauces, an estimate of 1 or 2 ounces may be best.  For condiments such as Ketchup or Mustard or Mayonnaise an estimate of 1 ounce or 1.5 ounces may work.  For Ingredients with low volumes such as Seasonings users may enter two decimal point estimates such as .35 ounces or .15 ounces etc.  For Breadings and Batters estimates of serving size will depend on the product (chicken, country fried steak, fish or veggie) and the batter/breading type, but should be in the range of .25 to 1.5 ounces, possibly more.  To make the most educated estimate, it may be best to consult a chef or technical staff.</p>

</body>

</html>