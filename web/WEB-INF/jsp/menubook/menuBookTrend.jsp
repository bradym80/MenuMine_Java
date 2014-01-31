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
			<td class="chainStatHeader" colspan="2">
				<webwork:property value="name"/>
			</td>
				<td class="chainStatHeader">
				<webwork:if test="medianPrice2011 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2011"/>
						</webwork:text>
				</webwork:if>
				<webwork:else>
					&nbsp
				</webwork:else>
				<td class="chainStatHeader">
				<webwork:if test="medianPrice2010 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2010"/>
						</webwork:text>
				</webwork:if>
				<webwork:else>
					&nbsp
				</webwork:else>
				<td class="chainStatHeader">
				<webwork:if test="medianPrice2009 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2009"/>
						</webwork:text>
				</webwork:if>
				<webwork:else>
					&nbsp
				</webwork:else>			
					</td>
			<td class="chainStatHeader">
				<webwork:if test="medianPrice2008 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2008"/>
						</webwork:text>
				</webwork:if>
				<webwork:else>
					&nbsp
				</webwork:else>			
					</td>
			<td class="chainStatHeader">
				<webwork:if test="medianPrice2007 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2007"/>
						</webwork:text>
				</webwork:if>
				<webwork:else>
					&nbsp
				</webwork:else>			
					</td>
			<td class="chainStatHeader">
				<webwork:if test="medianPrice2006 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2006"/>
						</webwork:text>
				</webwork:if>
				<webwork:else>
					&nbsp
				</webwork:else>			
					</td>
					<td class="chainStatHeader">
				<webwork:if test="medianPrice2005 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2005"/>
						</webwork:text>
				</webwork:if>
				<webwork:else>
					&nbsp
				</webwork:else>			
					</td>
					
					<td class="chainStatHeader">
				<webwork:if test="medianPrice2004 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2004"/>
						</webwork:text>
				</webwork:if>
				<webwork:else>
					&nbsp
				</webwork:else>
					</td>

					<td class="chainStatHeader">
					<webwork:if test="medianPrice2003 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2003"/>
						</webwork:text>
					</webwork:if>
					<webwork:else>
						 &nbsp
					</webwork:else>
					</td>

					<td class="chainStatHeader">
					<webwork:if test="medianPrice2002 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2002"/>
						</webwork:text>
					</webwork:if>
					<webwork:else>
						 &nbsp
					</webwork:else>
						</td>

					<td class="chainStatHeader">
					<webwork:if test="medianPrice2001 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2001"/>
						</webwork:text>
					</webwork:if>
					<webwork:else>
						 &nbsp
					</webwork:else>
					</td>

					<td class="chainStatHeader">
					<webwork:if test="medianPrice2000 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice2000"/>
						</webwork:text>
					</webwork:if>
					<webwork:else>
						 &nbsp
					</webwork:else>
						</td>

					<td class="chainStatHeader">
					<webwork:if test="medianPrice1999 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice1999"/>
						</webwork:text>
					</webwork:if>
					<webwork:else>
						 &nbsp
					</webwork:else>
						</td>

					<td class="chainStatHeader">
					<webwork:if test="medianPrice1998 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice1998"/>
						</webwork:text>
					</webwork:if>
					<webwork:else>
						 &nbsp
					</webwork:else>
						</td>


					<td class="chainStatHeader">
					<webwork:if test="medianPrice1997 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice1997"/>
						</webwork:text>
					</webwork:if>
					<webwork:else>
						 &nbsp
					</webwork:else>
						</td>


					<td class="chainStatHeader">
					<webwork:if test="medianPrice1996 != null">
						<webwork:text name="'dollar.format'">
							<webwork:param value="medianPrice1996"/>
						</webwork:text>
					</webwork:if>
					<webwork:else>
						 &nbsp
					</webwork:else>
						</td>
			</tr>
			
			<webwork:iterator value="menuItems" status="mistatus">
				<tr>
					<td class="results_cellA"><webwork:property value="#mistatus.count"/></td>
					<td class="results_cellA"><webwork:property value="menuItem"/></td>
					
					<webwork:if test="price2011 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2011"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>

					<webwork:if test="price2010 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2010"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>

					<webwork:if test="price2009 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2009"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					
					<webwork:if test="price2008 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2008"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					
					<webwork:if test="price2007 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2007"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>

					<webwork:if test="price2006 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2006"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>

					<webwork:if test="price2005 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2005"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					
					<webwork:if test="price2004 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2004"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="price2003 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2003"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="price2002 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2002"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="price2001 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2001"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="price2000 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price2000"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="price1999 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price1999"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="price1998 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price1998"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="price1997 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price1997"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					<webwork:if test="price1996 != null">
					<td class="results_cellA">
						<webwork:text name="'dollar.format'">
							<webwork:param value="price1996"/>
						</webwork:text>
					</td>
					</webwork:if>
					<webwork:else>
						<td class="results_cellA">
						 &nbsp
						</td>
					</webwork:else>
					
				</tr>
			</webwork:iterator>
		
	</webwork:iterator>

</table>

</body>
</html>