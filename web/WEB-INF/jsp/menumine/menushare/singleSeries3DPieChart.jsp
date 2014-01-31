<%@ taglib uri="webwork" prefix="webwork" %>
<%--
<graph caption='<webwork:property value="menuMineSessionContextWrapper.lastShareTable.fieldEnum.friendlyName" /> A' bgColor='ffffff' decimalPrecision='0' 
	showPercentageValues='1' showNames='0' numberPrefix='' showValues='0' 
	showPercentageInLabel='0' pieYScale='45' pieBorderAlpha='40' pieFillAlpha='100' 
	pieSliceDepth='25' pieRadius='150'>
--%>
<graph caption='<webwork:property value="currentTable.fieldEnum.friendlyName" />' 
	yaxisname='' xaxisname='' showAlternateVGridColor='1' alternateVGridAlpha='10' 
	alternateVGridColor='AFD8F8' numDivLines='6' decimalPrecision='0' 
	canvasBorderThickness='1' canvasBorderColor='114B78' baseFontColor='114B78' 
	hoverCapBorderColor='114B78' hoverCapBgColor='E7EFF6'>
	<webwork:iterator value="currentTable.rows" status="mestatus">
	    		<set value='<webwork:property value="numberInSample" />' 
				name='<webwork:property value="nameWordClickableShort" />' 
				hoverText='<webwork:property value="nameWordClickable" />'
				color='<webwork:property value="nextColor" />'/>
	</webwork:iterator>
</graph>