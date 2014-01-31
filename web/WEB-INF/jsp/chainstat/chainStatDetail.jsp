<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
</head>



<body>
<table width="10%" align="left">
	<tr>
    	<td>
        	<webwork:set name="isExcel" value="'true'"/>
            <webwork:set name="excelFile" value="'/chainStatDetailExcel.xls'"/>
            <webwork:set name="isAll" value="'false'"/>
            <webwork:set name="isTrend" value="'false'"/>
            <webwork:set name="isCut" value="'false'"/>
            <webwork:set name="isPie" value="'false'"/>
            <webwork:set name="isBar" value="'false'"/>
            <webwork:if test="chainStat.chainStateCount!=null">	
           		<webwork:set name="isMap" value="'true'"/>
            </webwork:if>
            <webwork:else>
            	<webwork:set name="isMap" value="'false'"/>
            </webwork:else>
            <webwork:include page="../menumine/_3panelLinks.jsp" />
        </td>
	<!--	<td class="smallFont" align="left">
			<a href="<webwork:url value="'/chainStatList.action'" >
					<webwork:param name="'back'" value="'back'" /></webwork:url>">Back</a>
		</td>
		
		<td class="smallFont" align="left">
			<a href="<webwork:url value="'/chainStatDetailExcel.xls'" >
				<webwork:param name="'target'" value="target" />	</webwork:url>">Excel</a>
		</td>
		<webwork:if test="chainStat.chainStateCount!=null">	
		<td class="smallFont" align="left">
			<a href="<webwork:url value="'/chainMap.action'" >
				<webwork:param name="'target'" value="chainStat.operationName" />	</webwork:url>">Chain Map</a>
		</td>	
		</webwork:if>-->
	
	</tr>
	<tr><td class="smallFont" colspan="3">
		<a  onclick="javascript:toggle('chainStatHelp');" 
			href="#nowhere">What is Chain Stat?</a>
			<div id="chainStatHelp" class="helpPopUp1" style="display:none;">
			<a href="#nowhere" class="helpLink"  onclick="javascript:toggle('chainStatHelp');" >ChainStat contains corporate information on chains in the database. This information includes sales, corporate HQ address, number of units and geographic dispersion.
			</a>
		</div>	
	</td></tr>
	
</table>
<h2 align="center">Chain Stat</h2>

<table align="center">
	<tr>
	<td colspan="4">
		<table width="100%">
			<tr>
				<td class="chainStatHeader" align="center" width="50%">Segment</td>
				<td class="chainStatHeader" align="center" width="50%">Sector</td>
			</tr>
			
			<tr>
				<td class="chainStatResult" align="center" width="50%"><webwork:property value="chainStat.segment" /></td>
				<td class="chainStatResult" align="center" width="50%"><webwork:property value="chainStat.sectorName" /></td>
			</tr>
		</table>
	</td>
	
	</tr>
	<tr>
		<td class="chainStatHeader">Chain</td>
		<td class="chainStatHeader" colspan="2">Street Address</td>
		<td class="chainStatHeader">City</td>
	</tr>
	<tr>
		<td class="chainStatResult"><webwork:property value="chainStat.operationName" /></td>
		<td class="chainStatResult" colspan="2"><webwork:property value="chainStat.hqAddress" /></td>
		<td class="chainStatResult"><webwork:property value="chainStat.hqCity" /></td>
	</tr>
	<tr>
		<td class="chainStatHeader">State</td>
		<td class="chainStatHeader">Phone</td>
		<td class="chainStatHeader">Fax</td>
		<td class="chainStatHeader">Web Site</td>
	</tr>
	<tr>
		<td class="chainStatResult"><webwork:property value="chainStat.hqState" /></td>
		<td class="chainStatResult"><webwork:property value="chainStat.phone" /></td>
		<td class="chainStatResult"><webwork:property value="chainStat.fax" /></td>
		<td class="chainStatResult">
		   <a href="http://<webwork:property value="chainStat.webSite"/>"><webwork:property value="chainStat.webSite"/></a>  
		</td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td class="chainStatHeader">Zip:</td>
					<td class="chainStatResult"> <webwork:property value="chainStat.hqZip" /></td>
				</tr>
			</table>
		<td>
	</tr>

	<tr>
	<td colspan="4">
		<table width ="100%">
		<tr>
		<td align="center" colspan="2" width="50%">
			<table>
				<tr>
				<td class="chainStatHeader" colspan="2"  align="center"># Operating Units</td>
				</tr>
				<tr>
					<td class="chainStatHeader" align="center">2007</td>
					<td class="chainStatHeader" align="center">2008</td>
				</tr>
				<tr>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.units2007" /></td>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.units2008" /></td>
				</tr>
				</tr>
				<tr>
				<td class="chainStatHeader" align="center" colspan="2">Industry Rank</td>
				</tr>
				<tr>
					<td class="chainStatHeader" align="center">2007</td>
					<td class="chainStatHeader" align="center">2008</td>
				</tr>
				<tr>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.indusRankUnits07" /></td>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.indusRankUnits08" /></td>
				</tr>
				
				<tr>
				<td class="chainStatHeader" colspan="2" align="center">Segment Rank</td>
				</tr>
				<tr>
					<td class="chainStatHeader" align="center">2007</td>
					<td class="chainStatHeader" align="center">2008</td>
				</tr>
				<tr>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.segRankUnits07" /></td>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.segRankUnits08" /></td>
				</tr>
			</table>

			</td>
			<td align="center"  colspan="2" width="50%">
				<table>
				<tr>
				<td class="chainStatHeader" colspan="2" align="center">Sales, MM</td>
				</tr>
				<tr>
					<td class="chainStatHeader" align="center">2007</td>
					<td class="chainStatHeader" align="center">2008</td>
				</tr>
				<tr>
					<td class="chainStatResult" align="center">$<webwork:property value="chainStat.sales2007" /></td>
					<td class="chainStatResult" align="center">$<webwork:property value="chainStat.sales2008" /></td>
				</tr>
				<tr>
				<td class="chainStatHeader" colspan="2" align="center">Industry Rank</td>
				</tr>
				<tr>
					<td class="chainStatHeader" align="center">2007</td>
					<td class="chainStatHeader" align="center">2008</td>
				</tr>
				<tr>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.indusRankDoll07" /></td>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.indusRankDoll08" /></td>
				</tr>
				
				<tr>
				<td class="chainStatHeader" colspan="2" align="center">Segment Rank</td>
				</tr>
				<tr>
					<td class="chainStatHeader" align="center">2007</td>
					<td class="chainStatHeader" align="center">2008</td>
				</tr>
				<tr>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.segRankDoll07" /></td>
					<td class="chainStatResult" align="center"><webwork:property value="chainStat.segRankDoll08" /></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		</td>
	</tr>
	
	<tr>
	<td colspan="4">
		<table width="100%">
			<tr>
				<td class="chainStatHeader">Parent</td>
				<td class="chainStatHeader">Address</td>
				<td class="chainStatHeader">City</td>
				<td class="chainStatHeader">State</td>
				<td class="chainStatHeader">Zip</td>
			</tr>
			<tr>
				<td class="chainStatResult"><webwork:property value="chainStat.parentCo" /></td>
				<td class="chainStatResult"><webwork:property value="chainStat.parentAddress" /></td>
				<td class="chainStatResult"><webwork:property value="chainStat.parentCity" /></td>
				<td class="chainStatResult"><webwork:property value="chainStat.parentState" /></td>
				<td class="chainStatResult"><webwork:property value="chainStat.parentZip" /></td>
			</tr>
		</table>
	</td>
	</tr>
	
	
</table>

<webwork:if test="menuMineSessionContextWrapper.adminRights">

<!--  2006-02-07 RSC _menuRss.jsp was here. -->

<webwork:include page="_menuCam.jsp" />
</webwork:if>

</body>
</html>