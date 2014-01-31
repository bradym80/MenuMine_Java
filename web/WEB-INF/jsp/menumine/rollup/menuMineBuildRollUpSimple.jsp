<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>


 <script type="text/javascript" language="javascript">
	<!--
		function confirmDelete(url){
			if(confirm("Are you sure you want to delete this roll up?"))
			{
			 location.replace(url)
			}
		}
	//-->
 </script>
</head>
<body  >
<table width="100%" >
<tr><td>



<webwork:include page="../_menuMineTitle.jsp" />


	






	<webwork:if test="menuMineSessionContextWrapper.lastGraphOptions.graphByFieldEnum != null">

		<tr>
			<td valign="top" colspan="2">
			<webwork:include page="_menuMineBuildRollUpTableSimple.jsp" /> 
			</td>
			
		</tr>
		
	</webwork:if>
	<webwork:else>
		No Group By Field Selected.
	</webwork:else>

</td> 
</tr>
	
</table>


</body>
</html>