<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>
</head>
<body>
	<webwork:include page="_menuBookTrendHeader.jsp" />

<table border="1" width="100%" class="results" >
	<tr><th class="results_cellA">&nbsp;</th> 
			<th class="results_cellA">Item Name</th> 
			<th class="results_cellA"> Price 2011</th>
			<th class="results_cellA"> Price 2010</th>
			<th class="results_cellA"> Price 2009</th>
			<th class="results_cellA"> Price 2008</th>
			<th class="results_cellA"> Price 2007</th>
			<th class="results_cellA"> Price 2006</th>
			<th class="results_cellA"> Price 2005</th>			 
			<th class="results_cellA"> Price 2004</th>
			<th class="results_cellA"> Price 2003</th>
			<th class="results_cellA"> Price 2002</th>
			<th class="results_cellA"> Price 2001</th>
			<th class="results_cellA"> Price 2000</th>
			<th class="results_cellA"> Price 1999</th>
			<th class="results_cellA"> Price 1998</th>
			<th class="results_cellA"> Price 1997</th>
			<th class="results_cellA"> Price 1996</th> 
			</tr>
	
	<webwork:iterator value="menuBook.menuParts" status="mpstatus">
	
			
			<tr>
			<td class="chainStatHeader" colspan="2"><webwork:property value="name"/></td>
			
			<webwork:if test="medianPrice2011 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2011"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>

			<webwork:if test="medianPrice2010 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2010"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>

			<webwork:if test="medianPrice2009 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2009"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>

			<webwork:if test="medianPrice2008 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2008"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					
			<webwork:if test="medianPrice2007 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2007"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>

			<webwork:if test="medianPrice2006 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2006"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					
			<webwork:if test="medianPrice2005 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2005"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>					
			
			<webwork:if test="medianPrice2004 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2004"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="medianPrice2003 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2003"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="medianPrice2002 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2002"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="medianPrice2001 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2001"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="medianPrice2000 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2000"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="medianPrice1999 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice1999"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="medianPrice1998 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice1998"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="medianPrice1997 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice1997"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="medianPrice1996 != 0.0">
					<td class="chainStatHeader">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice1996"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="chainStatHeader">
						 &nbsp
						</td>
					</webwork:else>
			</tr>
			
			
		
	</webwork:iterator>

</table>

</body>
</html>