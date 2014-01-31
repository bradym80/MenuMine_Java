<%@ taglib uri="webwork" prefix="webwork"%>

<webwork:form action="'menumineApplyFilters.action'" method="'post'" theme="'simple'">

<webwork:if test="menuMineDisplayOptions.filterable">
	<div id="filters" >
</webwork:if>
<webwork:else>
	<div id="filters" style="display: none;">	
</webwork:else>
			<table cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<td><h2>Query Result Filters</h2></td>
				</tr>
				<tr>
					<td class="smallFont" align="center">Filters affect MenuShare results.</td>
				</tr>				
				<tr>
					<td class="smallFont"
						style="white-space: nowrap; background-color: #CCCCCC;"
						align="left" valign="top"><b>Apply These Filters (In Order)</b></td>
				</tr>

						<tr>
							<td>
							<table cellpadding="0" cellspacing="0" width="100%">

<tr>
	<td width="5%"><webwork:checkbox theme="'simple'" fieldValue="'true'" name="'filterSettings.filterKeywordRow'" value="menuMineGraphOptions.filterKeywordRow"/></td>
	<td width="95%" class="powerSearchFilterName"><a href="#" onclick="javascript:showPopupAtHeight('filterKeywordRow', <webwork:property value="(#fieldCounter+1) * 20 + 210" />);">Eliminate By Keyword</a></td>
</tr>
								
<tr>
	<td width="5%"><webwork:checkbox theme="'simple'" fieldValue="'true'" name="'filterSettings.filterCommonTerms'" value="menuMineGraphOptions.filterCommonTerms"/></td>
	<td width="95%" class="powerSearchFilterName"><a href="#" onclick="javascript:showPopupAtHeight('filterCommonTerms', <webwork:property value="(#fieldCounter+2) * 20 + 210" />);">Remove Common Term(s)</a></td>
</tr>

<tr>
	<td width="5%"><webwork:checkbox theme="'simple'" fieldValue="'true'" name="'filterSettings.filterConsolidateByTerms'" value="menuMineGraphOptions.filterConsolidateByTerms"/></td>
	<td width="95%" class="powerSearchFilterName"><a href="#" onclick="javascript:showPopupAtHeight('filterConsolidateByTerms', <webwork:property value="(#fieldCounter+3) * 20 + 210" />);">Consolidate By Term(s)</a></td>
</tr>
								
<tr>
	<td width="5%"><webwork:checkbox theme="'simple'" fieldValue="'true'" name="'filterSettings.filterNone'" value="menuMineGraphOptions.filterNone"/></td>
	<td width="95%" class="powerSearchFilterName"><a href="#" onclick="javascript:showPopupAtHeight('filterNone', <webwork:property value="(#fieldCounter+4) * 20 + 210" />);">Empty Records</a></td>
</tr>

<tr>
	<td width="5%"><webwork:checkbox theme="'simple'" fieldValue="'true'" name="'filterSettings.filterCombination'" value="menuMineGraphOptions.filterCombination"/></td>
	<td width="95%" class="powerSearchFilterName"><a href="#" onclick="javascript:showPopupAtHeight('filterCombination', <webwork:property value="(#fieldCounter+5) * 20 + 210" />);">Combination Records</a></td>
</tr>

<tr>
	<td width="5%"><webwork:checkbox theme="'simple'" fieldValue="'true'" name="'filterSettings.filterLowPass'" value="menuMineGraphOptions.filterBelowPercentage"/></td>
	<td width="95%" class="powerSearchFilterName"><a href="#" onclick="javascript:showPopupAtHeight('filterLowPass', <webwork:property value="(#fieldCounter+6) * 20 + 210" />);">Low Pass</a></td>
</tr>

<tr>
	<td width="5%"><webwork:checkbox theme="'simple'" fieldValue="'true'" name="'filterSettings.filterHighPass'" value="menuMineGraphOptions.filterAbovePercentage"/></td>
	<td width="95%" class="powerSearchFilterName"><a href="#" onclick="javascript:showPopupAtHeight('filterHighPass', <webwork:property value="(#fieldCounter+7) * 20 + 210" />);">High Pass</a></td>
</tr>





							</table>
							</td>
						</tr>

<tr>
	<td>
<webwork:submit theme="'simple'" name="'submitOptions'"	value="'Apply Selected Filters'" /> 	
	</td>
</tr>
</table> 




<div id="filterNone" class="powerSearchFilterPopup">

	<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

	<h3>None Filter</h3>

	<p>When activated, eliminates records without data.</p>

</div>


<div id="filterCombination" class="powerSearchFilterPopup">

	<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

	<h3>Combination Filter</h3>

<p><input type="radio" name="menuMineGraphOptions.filterCombinationEliminate" value="false" <webwork:if test="!menuMineGraphOptions.filterCombinationEliminate">checked="checked"</webwork:if> />
			summarize 
<input type="radio" name="menuMineGraphOptions.filterCombinationEliminate" value="true" <webwork:if test="menuMineGraphOptions.filterCombinationEliminate">checked="checked"</webwork:if> />
			eliminate 
<br/>Summary Label: 
<webwork:textfield  theme="'simple'" size="'20'"
	   			name="'menuMineGraphOptions.filterCombinationLabel'" 
			    value="menuMineGraphOptions.filterCombinationLabel" /></p>

	<p>Summarizes or eliminates records with more than one item in them (e.g., "beef/pork/turkey").</p>

</div>


<div id="filterLowPass" class="powerSearchFilterPopup">

	<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

	<h3>Low Pass Filter</h3>



	<p>Threshold:
			 <webwork:textfield  theme="'simple'" size="'5'"
	   			name="'menuMineGraphOptions.filterBelowPercentageValue'" 
			    value="menuMineGraphOptions.filterBelowPercentageValue" /> %
			

		<br/>

<input type="radio" name="menuMineGraphOptions.filterBelowPercentageEliminate" value="false" <webwork:if test="!menuMineGraphOptions.filterBelowPercentageEliminate">checked="checked"</webwork:if> />
			summarize 
<input type="radio" name="menuMineGraphOptions.filterBelowPercentageEliminate" value="true" <webwork:if test="menuMineGraphOptions.filterBelowPercentageEliminate">checked="checked"</webwork:if> />
			eliminate 

<br/>Summary Label: 
<webwork:textfield  theme="'simple'" size="'20'"
	   			name="'menuMineGraphOptions.filterBelowPercentageLabel'" 
			    value="menuMineGraphOptions.filterBelowPercentageLabel" />
			</p>

<p>The Low Pass Filter either summarizes or removes records that comprise less than the specified
percentage of query results.</p>

</div>

<div id="filterHighPass" class="powerSearchFilterPopup">

	<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

<h3>High Pass Filter</h3>



<p>Threshold:
			 <webwork:textfield  theme="'simple'" size="'5'"
	   			name="'menuMineGraphOptions.filterAbovePercentageValue'" 
			    value="menuMineGraphOptions.filterAbovePercentageValue" /> %
			
			<br/>
<input type="radio" name="menuMineGraphOptions.filterAbovePercentageEliminate" value="false" <webwork:if test="!menuMineGraphOptions.filterAbovePercentageEliminate">checked="checked"</webwork:if> />
			summarize 
<input type="radio" name="menuMineGraphOptions.filterAbovePercentageEliminate" value="true" <webwork:if test="menuMineGraphOptions.filterAbovePercentageEliminate">checked="checked"</webwork:if> />
			eliminate
			<br/>

<br/>Summary Label: 
<webwork:textfield  theme="'simple'" size="'20'"
	   			name="'menuMineGraphOptions.filterAbovePercentageLabel'" 
			    value="menuMineGraphOptions.filterAbovePercentageLabel" /></p>

      <p>The High Pass Filter either summarizes or removes records that comprise more than the specified
      percentage of the query results.</p>			

</div>



<div id="filterCommonTerms" class="powerSearchFilterPopup">

	<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

	<h3>Remove Common Term(s) Filter</h3>

<p>Term(s):<br/>
<webwork:textarea  theme="'simple'" rows="'3'" cols="'30'"	   			
	name="'menuMineGraphOptions.filterCommonTermsList'" 
			    value="menuMineGraphOptions.filterCommonTermsList" /></p>
			    
	<p>Eliminate these words from results and combines any duplicately named rows from the new results.  
For example, if your results include "Sirloin Steak" and "Ribeye Steak", this filter will change these to simply "Sirloin" and "Ribeye".</p>

</div>

<div id="filterConsolidateByTerms" class="powerSearchFilterPopup">

	<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

	<h3>Consolidate By Term(s) Filter</h3>

<p>Term(s):<br/>
<webwork:textarea  theme="'simple'" rows="'3'" cols="'30'"	   			name="'menuMineGraphOptions.filterConsolidateByTermsList'" 
			    value="menuMineGraphOptions.filterConsolidateByTermsList" /></p>
			    
<p>Enter a comma separated list of terms you wish to consolidate records by.  For example, if you enter "honey mustard, vinaigrette"
MenuShare will consolidate all records with the terms "honey" or "mustard" to one row, all records containing the term "vinaigrette" to
another row and will leave the rest of the results untouched.  <strong>Note:</strong> Rows are consolidated in the same order you 
enter terms.  So, if you enter "honey" then "vinaigrette", a combination "honey/vinaigrette" record will accrue to "honey" and not to vinaigrette.</p>

</div>

<div id="filterKeywordRow" class="powerSearchFilterPopup">

	<p class="smallFont" align="right"><a href="#" onclick="javascript:hideActivePopup();">close</a></p>

	<h3>Eliminate By Keyword</h3>

<p>Term(s):<br/>
<webwork:textarea  theme="'simple'" rows="'3'" cols="'30'"
	   			name="'menuMineGraphOptions.filterKeywordRowTermsList'" 
			    value="menuMineGraphOptions.filterKeywordRowTermsList" />

			<br/>
<input type="radio" name="menuMineGraphOptions.filterKeywordRowEliminate" value="false" <webwork:if test="!menuMineGraphOptions.filterKeywordRowEliminate">checked="checked"</webwork:if> />
			summarize 
<input type="radio" name="menuMineGraphOptions.filterKeywordRowEliminate" value="true" <webwork:if test="menuMineGraphOptions.filterKeywordRowEliminate">checked="checked"</webwork:if> />
			eliminate
			<br/>

<br/>Summary Label: 
<webwork:textfield  theme="'simple'" size="'20'"
	   			name="'menuMineGraphOptions.filterKeywordRowLabel'" 
			    value="menuMineGraphOptions.filterKeywordRowLabel" /></p>
			    			    
	<p>Rows containing any of the keywords you enter, in any position, will be summarized or eliminated.</p>

</div>

</div>

</webwork:form>