<%@ taglib uri="webwork" prefix="webwork" %>
<tr>
<td >
	<table  cellspacing="0" cellpadding="0" >	
 	<tr>
		<td class="headerselect"  width="5%"> 
			<a href="#nowhere" onclick="javascript:toggle('priceClassDiv');" >
						<img id="priceClassDiv_image"  border="0" src="img/expand.gif" alt="" />
					</a>
		</td>
	<td class="headerBGPricingRight" width="95%" align="left">
		<table cellspacing="0" cellpadding="0" >
		<tr>
			
			<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
				name="'fieldsToDisplay.price2005'" 
				value="fieldsToDisplay.price2005"/> 
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				2005
			</td>
			<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
				name="'fieldsToDisplay.price2004'" 
				value="fieldsToDisplay.price2004"/>
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				2004
			</td>
			<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
					name="'fieldsToDisplay.price2003'" 
					value="fieldsToDisplay.price2003"/>
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				2003
			</td>
    			
		</tr>
		</table>
	</td>
	</tr>
	<tr>
		<td class="headerselect" align="left" width="5%"> &nbsp; </td>
	<td class="headerBGPricingRight" width="95%" align="left">
		<table cellspacing="0" cellpadding="0" >
		<tr>
		
			<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
					name="'fieldsToDisplay.price2002'" 
					value="fieldsToDisplay.price2002"/>
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				2002
			</td>
			<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
				name="'fieldsToDisplay.price2001'" 
				value="fieldsToDisplay.price2001"/>
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				2001
			</td>
			<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
					name="'fieldsToDisplay.price2000'" 
					value="fieldsToDisplay.price2000"/>
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				2000
			</td>
    		
		</tr>
		</table>
	</td>
	</tr>
	<tr>
	<td class="headerselect" align="left" width="5%"> &nbsp; </td>
	<td class="headerBGPricingRight" width="95%" align="left">
		<table cellspacing="0" cellpadding="0" >
		<tr>
	
		<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
					name="'fieldsToDisplay.price1999'" 
					value="fieldsToDisplay.price1999"/>
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				1999
			</td>
			
			<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
					name="'fieldsToDisplay.price1998'" 
					value="fieldsToDisplay.price1998"/>
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				1998
			</td>
			
			<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
					name="'fieldsToDisplay.price1997'" 
					value="fieldsToDisplay.price1997"/>
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				1997
			</td>
			

    		
		</tr>
		</table>
	</td>
	</tr>
	<tr>
	<td class="headerselect" align="left" width="5%"> &nbsp; </td>
	<td class="headerBGPricingRight" width="95%" align="left">
		<table cellspacing="0" cellpadding="0" >
		<tr>
		
			
		<td class="headerselect" align="left" width="5%">
				<webwork:checkbox theme="'simple'" fieldValue="'true'" 
					name="'fieldsToDisplay.price1996'" 
					value="fieldsToDisplay.price1996"/>
			</td>
			<td class="headerBGPricingBold" align="left" width="27%">
				1996
			</td>	
			<td class="headerselect" align="left"  colspan="4"> &nbsp; </td>
    		
		
		</tr>
		</table>
	</td>
	</tr>
	
	</table>
	</td>
	</tr>
	

	
	
	<tr class="filterBG"><td class="headerBGPricingFilter" >
		<div id="priceClassDiv" style="display:none; ">
				<webwork:include page="_menuMineMainFormMenuPricingEmpty.jsp" />
		</div>
	</td>
	</tr>
	