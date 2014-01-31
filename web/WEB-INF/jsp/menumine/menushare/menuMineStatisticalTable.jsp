<%@ taglib uri="webwork" prefix="webwork" %>

<head>
   <script src="js/prototype.js"></script>
   <script src="js/rico.js"></script>
 <!--  <script src="js/util.js"></script> -->

</head>

<body onload="javascript:bodyOnLoad()" >



<script type="text/javascript" language="javascript">
   onloads.push( registerAjaxStuff );
  onloads.push( getShareTable );

   function registerAjaxStuff() {
   
      ajaxEngine.registerRequest( 'menumineDisplayStatisticalTableAJAX', 'menumineDisplayStatisticalTableAJAX.ajax' );
      ajaxEngine.registerAjaxElement( 'shareTable' );
      
  
   }

   function getShareTable() {

 	 ajaxEngine.sendRequest( 'menumineDisplayStatisticalTableAJAX');  
	
   }
</script>
<script type="text/javascript" language="javascript">
initOptions("menushareOptions");
</script>

 <webwork:if test="menuMineGraphOptions.graphByFieldSelected"> 
  <webwork:if test="belowCountLimit == true"> 

	<webwork:if test="menuMineDisplayOptions.displayType == 'Statistical Table As Excel'"> 
	    	<script type="text/javascript" language="javascript">
	    		javascript:openExcelStatTable();    		
	    	</script> 
				Click if Excel sheet does not pop up:  
				<a href="<webwork:url value="'statisticalTableExcel.xls'"/>">View Statistical Table as Excel</a><br/>
	</webwork:if>
 
	 

<div  style="display:inline" id="shareTable">
<table  width="100%" align="center">
<tr>
<td align="center">
<img  border="0" src="img/loader.gif"/> 
</td>
</tr>
</table>
</div>

<%--
<webwork:include page="_menuMineStatisticalTableMain.jsp" />
--%>
	     	</webwork:if>	
	<webwork:else>
		<webwork:if test="queryExists">	
			<table>
				<tr>
					<td align ="left" class="smallFont">Record Count: <webwork:property value="count" /></td>
				</tr><tr>
					<td class="smallFont">
						Drill down to less then <webwork:property value="reportSizeLimit"/> 
						records to view a Menu Share.
					</td>
				</tr>
			</table>
		</webwork:if>
	</webwork:else>
</webwork:if>	

<body>

<script type="text/javascript" language="javascript">
//getShareTable();
</script>
	