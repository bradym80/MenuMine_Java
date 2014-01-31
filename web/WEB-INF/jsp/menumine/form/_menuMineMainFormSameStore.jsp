<%@ taglib uri="webwork" prefix="webwork" %>
<tr>
<td >
	
	<table cellpadding="0" cellspacing="0">
		<tr>
		
			<td class="headerselect" align="left" width="5%"> 
				<a href="#nowhere" onclick="javascript:toggle('sameStoreClassDiv');" >
						<img id="sameStoreClassDiv_image"  border="0" src="img/expand.gif" alt="expand" />
				</a>
			</td>
	
			<td  class="headerselect" align="left" width="5%"  >
    					<webwork:checkbox theme="'simple'" fieldValue="'true'" name="'fieldsToDisplay.yearPutInDatabase'" value="fieldsToDisplay.yearPutInDatabase"/>
    			</td>	
				 
    			<td  class="headerBGPricingRight" align="left" width="90%" >
    					<table width="100%" >
					<tr>
						<td class="menuFormFont" width="100%"  >
							Same Store
						</td>
						<td align="right" width="100%" >
							<a href="#nowhere" class="mainMenu" onclick="javascript:toggle('sameStoreHelp');" ><img   border="0" src="img/helpimg.gif" alt="help" /> </a>
						</td>
						<td width="1%" >
						
							<div id="sameStoreHelp" class="helpPopUp1" style="display:none;">
								<a href="#nowhere" class="helpLink" onclick="javascript:toggle('sameStoreHelp');" >Same Store isolates those operations that are in MenuMine for the time period indicated.<img   border="0" src="img/expand.gif" alt="expand" /> </a>
							</div>
						</td>
					</tr>
					</table>
			</td>			
    			
		</tr>
		</table>
	
	
	
	</td>
	</tr>
	

	<tr class="filterBG">
	<td class="headerBGPricingFilter" align="right">
		<div id="sameStoreClassDiv" style="display:none; ">
				<webwork:include page="_menuMineMainFormSameStoreDiv.jsp" />   
		</div>
	</td>
	</tr>