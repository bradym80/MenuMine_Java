<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
</head>

<body>
<p>&nbsp;</p>


	
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
<td valign="top" width="15%">
 <table width="100%"  border="0" cellpadding="0" cellspacing="0" class="ProfilerTable">
        <tr>
          <td class="ProfilerHeader">Profiles </td>
        </tr>
	<tr>
          <td><a class="ProfilerBody" href="<webwork:url value="'flavorProfiler.action'"/>">Flavor Profiler</a></td>
        </tr>
	<tr>
          <td><a class="ProfilerBody" href="<webwork:url value="'proteinProfiler.action'"/>">Protein Profiler</a></td>
        </tr>
	 <tr>
          <td><a class="ProfilerBody" href="<webwork:url value="'carboProfiler.action'"/>">Carbo Profiler</a></td>
        </tr>
	 <tr>
          <td><a class="ProfilerBody" href="<webwork:url value="'veggieProfiler.action'"/>">Veggie Profiler</a></td>
        </tr>
	 <tr>
          <td><a class="ProfilerBody" href="<webwork:url value="'dessertProfiler.action'"/>">Dessert Profiler</a></td>
        </tr>
	 <tr>
          <td><a class="ProfilerBody" href="<webwork:url value="'healthyProfiler.action'"/>">Healthy Profiler</a></td>
        </tr>
	 <tr>
          <td><a class="ProfilerBody" href="<webwork:url value="'marketProfiler.action'"/>">Market Profiler</a></td>
        </tr>
 </table>
</td>
<td align="center" width="70%">	
	
	<table align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td  style="font-family:Optima, Lucida, MgOpen Cosmetica, Lucida Sans Unicode, sans-serif; font-size:32px;font-weight:bold;padding:0px;spacing:0px;vertical-align:top;"><webwork:property value="profilerTitle"/></td>
		<td valign="bottom" style="font-family:Optima, Lucida, MgOpen Cosmetica, Lucida Sans Unicode, sans-serif; font-size:8px;">Powered By FlavorTrak &#174;</td>
	</tr>
	</table>
	
	<table align="center">
	<tr>
		<td align="center">
			<webwork:include page="_profilerForm.jsp" />
		</td>
		
	</tr>
	<tr>
		<td align="center">
	<webwork:if test="profileAvailable">
	
		<webwork:include page="_profilerTabs.jsp" />

		<webwork:if test="displayType == 'Applications'">
			<webwork:include page="_profilerApplication.jsp" />
		</webwork:if>	

		<webwork:if test="displayType == 'Operator Share'">
			<webwork:include page="_profilerOperatorShare.jsp" />
		</webwork:if>	
	
		<webwork:if test="displayType == 'Segment Share'">
			<webwork:include page="_profilerSegmentShare.jsp" />
		</webwork:if>	
	
		<webwork:if test="displayType == 'Sector Share'">
			<webwork:include page="_profilerSectorShare.jsp" />
		</webwork:if>
		
		<webwork:if test="displayType == 'Application Chart'">
			<webwork:include page="_profilerApplicationChart.jsp" />
		</webwork:if>
		
			
	</webwork:if>	
	</td>
	</tr>
	</table>
	
</td>
<td valign="top" width="15%">&nbsp;</td>
</tr>
</table>	
</body>
</html>