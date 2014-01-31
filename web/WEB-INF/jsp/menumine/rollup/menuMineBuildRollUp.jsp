<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>


  <link href="css/draganddrop.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/javascript" src="js/prototype.js"></script>
<script language="JavaScript" type="text/javascript" src="js/rico.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ricoDragAndDropCustomDraggable.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ricoDragAndDropCustomDropzoneAddToRollUp.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ricoDragAndDropCustomDropzoneRemoveFromRollUp.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ricoDragAndDropCustomDropzone.js"></script>

 <script type="text/javascript" language="javascript">
     function __debug(str) {
        new Insertion.Bottom( $('debug'), str + "</br>" );
        $('debug').scrollTop = 99999;
     }

      var onloads = new Array();
      function bodyOnLoad() {
         new Effect.Round( null, 'roundNormal' );
         new Effect.Round( null, 'roundCompact', {compact:true} );
         for ( var i = 0 ; i < onloads.length ; i++ )
            onloads[i]();
      }
   </script>

<%--
<script language="JavaScript" type="text/javascript" src="js/coordinates.js"></script>
<script language="JavaScript" type="text/javascript" src="js/drag.js"></script>
<script language="JavaScript" type="text/javascript" src="js/dragdrop.js"></script>
--%>

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
<body onload="javascript:bodyOnLoad()" >
   <span id="dynamicDebugPanel"></span>

  
   
   <script type="text/javascript" language="javascript">
   var saveHeight;
   var showing = true;
</script>


</div>



<table>
<tr><td>



<%--
<span class="header">CUSTOM DROPZONE EXAMPLE&nbsp;</span>

<br/><br/>
<div id="exampleContainer" style="background-color:#E0DDB5">

<table cellspacing="5"><tr>

<td valign="top">
   <span class="catHeader" style="margin-top:0px">name-list</span>
   <div class="listBox" id="nameList" style="background-color:white;width:250px;height:180px;overflow:auto">
      <script>writeNameSpans()</script>
   </div>
   <script>createDraggables()</script>

</td>


</tr></table>
</div>

<table cellspacing="3" cellpadding="3"><tr>

   <td>
      <span id="dz1" style="padding:2px 0px" class="catHeader">a-g</span>
      <div style="width:200px" class="roundMe" >
         <div id="dropZone1" style="height:100px;overflow:auto" class="customDropZone">
         </div>

      </div>
   </td>

   <td>
      <span id="dz2"  style="padding:2px 0px" class="catHeader">h-m</span>
      <div style="width:200px" class="roundMe" >
         <div id="dropZone2" style="height:100px;overflow:auto" class="customDropZone">
         </div>
      </div>

   </td>

   <td>
      <span id="dz3"  style="padding:2px 0px" class="catHeader">n-z</span>
      <div style="width:200px" class="roundMe" >
         <div id="dropZone3" style="height:100px;overflow:auto" class="customDropZone">
         </div>
      </div>
   </td>

</tr></table>
   
  --%> 
  
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
 

<table class="menuOptions" width="100%" >
<tr><td>Roll Up Options:</td></tr>
<tr>
<td>
<webwork:property value="menuMineGraphOptions.graphByFieldEnum.friendlyName"/>
</td>

	<webwork:form theme="'simple'" method="'POST'" action="'selectSavedRollUp.action'" name="'menuMineLoadRollUp'">

		<td>
		<webwork:select theme="'simple'"
					cssClass="'filterFieldsHistory'"
					name="'selectRollUpName'"
					value=""
					list="savedRollUps" 
					listValue="longName"
					listKey="name"
					headerKey="'-----ROLL UP SAVES-----'"
					headerValue="'-----ROLL UP SAVES-----'"
					onchange="'document.menuMineLoadRollUp.submit();'"/>
		<webwork:submit  theme="'simple'" name="'submitSave'" value="'Go'" />
		
		</td>
		</webwork:form>
		<webwork:form theme="'simple'" method="'POST'" action="'saveRollUp.action'" name="'menuMineSavedRollUp'">

		<td>
		Roll Up Name <webwork:textfield theme="'simple'"  name="'saveName'" value="menuMineSessionContextWrapper.rollUpOptions.name" />
		
		<webwork:if test="menuMineSessionContextWrapper.adminRights">
			<webwork:select theme="'simple'"
						name="'groupName'" 
						value="menuMineSessionContextWrapper.rollUpOptions.groupName" 
						list="groups" 
						listKey="name" 
						listValue="name" />
			</webwork:if>
		
		<webwork:submit  theme="'simple'" name="'submitSave'" value="'Save As'" />
		
		<webwork:if test="menuMineSessionContextWrapper.rollUpOptions.id != null">
		<webwork:submit  theme="'simple'" name="'submitUpdate'" value="'Save'" />
		</webwork:if>
		
	</webwork:form>
		<webwork:if test="menuMineSessionContextWrapper.rollUpOptions.id">
			 <input type="Button" value="Delete"  onclick="javascript:confirmDelete('<webwork:url value="'deleteRollUp.action'" >
						<webwork:param name="'submitDelete'" value="'Delete'" />
					</webwork:url>'	);" /> 
			 <%--
			 <a href="#nowhere" onclick="javascript:confirmDelete('<webwork:url value="'deleteRollUp.action'" >
						<webwork:param name="'submitDelete'" value="'Delete'" />
					</webwork:url>'	);" >
						Delete
			</a>
			--%>
			<%--
			<webwork:form theme="'simple'" method="'POST'" action="'deleteRollUp.action'" name="'menuMineSavedRollUp'">
				<webwork:submit  theme="'simple'" name="'submitDelete'" value="'Delete'" onclick="javascript:confirmDelete('<webwork:url value="'deleteRollUp.action'" >
						<webwork:param name="'submitDelete'" value="'Delete'" />
					</webwork:url>'	);" />
			</webwork:form>
			--%>
		</webwork:if>
		</td>
		
	</tr>
</table>
<webwork:if test="menuMineSessionContextWrapper.errorContext.hasErrors()">
<table>
	<webwork:iterator value="menuMineSessionContextWrapper.errorContext.errors" status="mestatus">
	<tr>
		<td>
		  <font color="red"> <webwork:property value="message"/> </font>
		</td>
	</tr>
	</webwork:iterator>
</table>
</webwork:if>

<webwork:include page="../_menuMineTitle.jsp" />

<table>
<tr>
<td>
&nbsp;
</td>
<td>
<table>
	
</table>

</td> 
</tr>



	<webwork:if test="menuMineSessionContextWrapper.lastGraphOptions.graphByFieldEnum != null">
		<%--
		<tr>
			<td valign="top">
				<webwork:include page="_menuMineBuildRollUpSummary.jsp" />
			</td>
			<td valign="top">
				<webwork:include page="_menuMineBuildRollUpForm.jsp" />
			</td>
		</tr>
		--%>
		<tr>
			<td valign="top" colspan="2">
			<webwork:include page="_menuMineBuildRollUpTable.jsp" /> 
			</td>
			
		</tr>
		
	</webwork:if>
	<webwork:else>
		No Group By Field Selected.
	</webwork:else>
	
</table>

 <script type="text/javascript" language="javascript">
  // dndMgr.registerDropZone( new CustomDropzone('dropZone1', 'dz1', ['a','g']) );
 //  dndMgr.registerDropZone( new CustomDropzone('dropZone2', 'dz2', ['h','m']) );
 //  dndMgr.registerDropZone( new CustomDropzone('dropZone3', 'dz3', ['n','z']) );

  // Rico.Corner.round('exampleContainer');
 
  // new Effect.Round( 'div', 'roundMe', {color:'#c6c3de'});
   CustomDraggable.removeOnDrop = true; 

   

</script>
</body>
</html><%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>




<link href="http://openrico.org/rico/css/rico.css" rel="stylesheet" type="text/css">
  <link href="http://openrico.org/rico/css/ricoTests.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/javascript" src="js/prototype.js"></script>
<script language="JavaScript" type="text/javascript" src="js/rico.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ricoDragAndDropCustomDraggable.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ricoDragAndDropCustomDropzoneAddToRollUp.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ricoDragAndDropCustomDropzoneRemoveFromRollUp.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ricoDragAndDropCustomDropzone.js"></script>

 <script type="text/javascript" language="javascript">
     function __debug(str) {
        new Insertion.Bottom( $('debug'), str + "</br>" );
        $('debug').scrollTop = 99999;
     }

      var onloads = new Array();
      function bodyOnLoad() {
         new Effect.Round( null, 'roundNormal' );
         new Effect.Round( null, 'roundCompact', {compact:true} );
         for ( var i = 0 ; i < onloads.length ; i++ )
            onloads[i]();
      }
   </script>

<%--
<script language="JavaScript" type="text/javascript" src="js/coordinates.js"></script>
<script language="JavaScript" type="text/javascript" src="js/drag.js"></script>
<script language="JavaScript" type="text/javascript" src="js/dragdrop.js"></script>
--%>

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
<body onload="javascript:bodyOnLoad()" >
   <span id="dynamicDebugPanel"></span>

  
   
   <script type="text/javascript" language="javascript">
   var saveHeight;
   var showing = true;
</script>


</div>



<table>
<tr><td>



<%--
<span class="header">CUSTOM DROPZONE EXAMPLE&nbsp;</span>

<br/><br/>
<div id="exampleContainer" style="background-color:#E0DDB5">

<table cellspacing="5"><tr>

<td valign="top">
   <span class="catHeader" style="margin-top:0px">name-list</span>
   <div class="listBox" id="nameList" style="background-color:white;width:250px;height:180px;overflow:auto">
      <script type="text/javascript" language="javascript">writeNameSpans()</script>
   </div>
   <script type="text/javascript" language="javascript">createDraggables()</script>

</td>


</tr></table>
</div>

<table cellspacing="3" cellpadding="3"><tr>

   <td>
      <span id="dz1" style="padding:2px 0px" class="catHeader">a-g</span>
      <div style="width:200px" class="roundMe" >
         <div id="dropZone1" style="height:100px;overflow:auto" class="customDropZone">
         </div>

      </div>
   </td>

   <td>
      <span id="dz2"  style="padding:2px 0px" class="catHeader">h-m</span>
      <div style="width:200px" class="roundMe" >
         <div id="dropZone2" style="height:100px;overflow:auto" class="customDropZone">
         </div>
      </div>

   </td>

   <td>
      <span id="dz3"  style="padding:2px 0px" class="catHeader">n-z</span>
      <div style="width:200px" class="roundMe" >
         <div id="dropZone3" style="height:100px;overflow:auto" class="customDropZone">
         </div>
      </div>
   </td>

</tr></table>
   
  --%> 
  
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
 

<table class="menuOptions" width="100%" >
<tr><td>Roll Up Options:</td></tr>
<tr>
<td>
<webwork:property value="menuMineGraphOptions.graphByFieldEnum.friendlyName"/>
</td>

	<webwork:form theme="'simple'" method="'POST'" action="'selectSavedRollUp.action'" name="'menuMineLoadRollUp'">

		<td>
		<webwork:select theme="'simple'"
					cssClass="'filterFieldsHistory'"
					name="'selectRollUpName'"
					value=""
					list="savedRollUps" 
					listValue="longName"
					listKey="name"
					headerKey="'-----ROLL UP SAVES-----'"
					headerValue="'-----ROLL UP SAVES-----'"
					onchange="'document.menuMineLoadRollUp.submit();'"/>
		<webwork:submit  theme="'simple'" name="'submitSave'" value="'Go'" />
		
		</td>
		</webwork:form>
		<webwork:form theme="'simple'" method="'POST'" action="'saveRollUp.action'" name="'menuMineSavedRollUp'">

		<td>
		Roll Up Name <webwork:textfield theme="'simple'"  name="'saveName'" value="menuMineSessionContextWrapper.rollUpOptions.name" />
		
		<webwork:if test="menuMineSessionContextWrapper.adminRights">
			<webwork:select theme="'simple'"
						name="'groupName'" 
						value="menuMineSessionContextWrapper.rollUpOptions.groupName" 
						list="groups" 
						listKey="name" 
						listValue="name" />
			</webwork:if>
		
		<webwork:submit  theme="'simple'" name="'submitSave'" value="'Save As'" />
		
		<webwork:if test="menuMineSessionContextWrapper.rollUpOptions.id != null">
		<webwork:submit  theme="'simple'" name="'submitUpdate'" value="'Save'" />
		</webwork:if>
		
	</webwork:form>
		<webwork:if test="menuMineSessionContextWrapper.rollUpOptions.id">
			 <input type="Button" value="Delete"  onclick="javascript:confirmDelete('<webwork:url value="'deleteRollUp.action'" >
						<webwork:param name="'submitDelete'" value="'Delete'" />
					</webwork:url>'	);" /> 
			 <%--
			 <a href="#nowhere" onclick="javascript:confirmDelete('<webwork:url value="'deleteRollUp.action'" >
						<webwork:param name="'submitDelete'" value="'Delete'" />
					</webwork:url>'	);" >
						Delete
			</a>
			--%>
			<%--
			<webwork:form theme="'simple'" method="'POST'" action="'deleteRollUp.action'" name="'menuMineSavedRollUp'">
				<webwork:submit  theme="'simple'" name="'submitDelete'" value="'Delete'" onclick="javascript:confirmDelete('<webwork:url value="'deleteRollUp.action'" >
						<webwork:param name="'submitDelete'" value="'Delete'" />
					</webwork:url>'	);" />
			</webwork:form>
			--%>
		</webwork:if>
		</td>
		
	</tr>
</table>
<webwork:if test="menuMineSessionContextWrapper.errorContext.hasErrors()">
<table>
	<webwork:iterator value="menuMineSessionContextWrapper.errorContext.errors" status="mestatus">
	<tr>
		<td>
		  <font color="red"> <webwork:property value="message"/> </font>
		</td>
	</tr>
	</webwork:iterator>
</table>
</webwork:if>

<webwork:include page="../_menuMineTitle.jsp" />

<table>
<tr>
<td>
&nbsp;
</td>
<td>
<table>
	
</table>

</td> 
</tr>



	<webwork:if test="menuMineSessionContextWrapper.lastGraphOptions.graphByFieldEnum != null">
		<%--
		<tr>
			<td valign="top">
				<webwork:include page="_menuMineBuildRollUpSummary.jsp" />
			</td>
			<td valign="top">
				<webwork:include page="_menuMineBuildRollUpForm.jsp" />
			</td>
		</tr>
		--%>
		<tr>
			<td valign="top" colspan="2">
			<webwork:include page="_menuMineBuildRollUpTable.jsp" /> 
			</td>
			
		</tr>
		
	</webwork:if>
	<webwork:else>
		No Group By Field Selected.
	</webwork:else>
	
</table>

 <script type="text/javascript" language="javascript">
  
   CustomDraggable.removeOnDrop = true; 

   

</script>
</body>
</html>