<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head></head>
<body>
<table  align="left">
  <tr>
   <!-- <td class="smallFont" align="left"><a href="<webwork:url value="'/menuBookExcel.xls'" >
      </webwork:url>
      ">Excel</a> 
      
      </td>-->
      
      <td>
        	<webwork:set name="isExcel" value="'true'"/>
            <webwork:set name="excelFile" value="'/menuBookExcel.xls'"/>
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
        </tr>
        <tr>
    <td class="smallFont" ><a  onclick="javascript:toggle('menuBookHelp');" 
			href="#nowhere">What is MenuBook?</a>
      <div id="menuBookHelp" class="helpPopUp1" style="display:none;"> <a href="#nowhere" class="helpLink"  onclick="javascript:toggle('menuBookHelp');" >MenuBook allows you to see every current item available from a particular chain all on one screen for the latest year. Both the name of the item and the price is listed. </a> </div></td>
  </tr>
</table>
<br/>
<h3>MenuBook<sup>TM</sup>:
  <webwork:property value="menuBook.chain.operationName"/>
</h3>
<h4>
Sector:
<webwork:property value="menuBook.chain.sectorName"/>
&nbsp&nbsp&nbsp&nbsp&nbsp
Segment:
<webwork:property value="menuBook.chain.segment"/>
<h4>
<table >
  <tr>
    <webwork:iterator value="menuBook.menuParts" status="mpstatus">
    <td valign="top" ><table border="1" width="100%">
        <tr>
          <td class="chainStatHeader" colspan="2"><webwork:property value="name"/></td>
        </tr>
        <tr>
          <!-- JDL 04-29-08 Removed columes bug #37 -->
          <!-- <th class="results_cellA">&nbsp;</th>-->
          <th class="results_cellA" align="left">Name</th>
          <!-- <th class="results_cellA">Type </th>-->
          <th class="results_cellA"> Price</th>
        </tr>
        <webwork:iterator value="menuItems" status="mistatus">
          <tr>
            <!-- JDL 04-29-08 Removed columes bug #37 -->
            <!--	<td class="results_cellA"><webwork:property value="#mistatus.count"/></td>-->
            <td class="results_cellA"><webwork:property value="menuItem"/></td>
            <!--	<td class="results_cellA"><webwork:property value="menuItemType"/></td>-->
            <td class="results_cellA"><webwork:text name="'dollar.format'">
            <!--  MJB 11-12-2009 use 2009 -->
			<!--  MJB 10-6-10 use 2010 -->
                <webwork:param value="price2011"/>
              </webwork:text>
            </td>
          </tr>
        </webwork:iterator>
      </table></td>
    <webwork:if test="#mpstatus.modulus(3) == 0">
  </tr>
  <tr>
    </webwork:if>
    </webwork:iterator>
  </tr>
</table>
<!--<webwork:if test="menuBook.menuParts.size == 0">
  <script language="javascript">alert("2011 Prices are
not available for this Operator, Please see MenuBook Trends")</script>
</webwork:if> -->
</body>
</html>
