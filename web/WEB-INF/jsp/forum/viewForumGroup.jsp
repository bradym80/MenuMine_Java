<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>
<style>

.addMessage{
 font-family:Optima, Lucida, MgOpen Cosmetica, Lucida Sans Unicode, sans-serif;
 font-size:11px; 
 font-weight:bold; 
}

 .titleleft{
 border-left:1px solid #cccccc; 
 border-top:1px solid #cccccc; 
 border-right:1px solid #cccccc; 
 background-image:url(/menumine/img/topbg.gif);
 height:25px; 
 }
 .titleright{
 border-top:1px solid #cccccc; 
 border-right:1px solid #cccccc; 
 background-image:url(/menumine/img/topbg.gif); 
 color:#2F68A3;"; 
 font-family:Optima, Lucida, MgOpen Cosmetica, Lucida Sans Unicode, sans-serif;
 font-size:11px; 
 font-weight:bold; 
 height:25px; 
 vertical-align:middle;
 }
 
 .bodyleft{
 border-left:1px solid #cccccc; 
 border-top:1px solid #cccccc; 
 border-right:1px solid #cccccc; 
 }
 .bodyright{
 border-top:1px solid #cccccc; 
 border-right:1px solid #cccccc;
 }
 .bottombodyleft{
 border:1px solid #cccccc; width:51px;
 }
 .bottombodyright{
 border-top:1px solid #cccccc; 
 border-right:1px solid #cccccc; 
 border-bottom:1px solid #cccccc;
 } 
 
 </style>
 <script>
		<!--
		function confirmDelete(url){

			if(confirm("Are you sure you want to delete this post?"))
			{
			 location.replace(url)
			}
		}
//-->
</script>
</head>
<body>
<p>
<table width="750" border="0" cellspacing="0" cellpadding="1" align="center">
  <tr>
    <td style="border:2px solid #2F68A3;"><table width="750" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="titleleft"><b>Forum</b></td>
	  <td class="titleright" valign="right"> </td>
        </tr>
     <webwork:if test="messages.size()==0">
     <tr>
          <td colspan="2" class="bodyleft">
	  <table width="750" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td >&nbsp;</td>
               <td  class="addMessage" align="right"> <a class="menuLink" href="<webwork:url value="'addForumMessage.action'" > </webwork:url>"> Add Message </a> </td>
              </tr>
            </table></td>
        </tr>
     </webwork:if>
        <webwork:iterator value="messages" status="mestatus">
        <tr>
          <td colspan="2" class="bodyleft">
	  <table width="750" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td >&nbsp;</td>
               <td  class="addMessage" align="right"> <a class="menuLink" href="<webwork:url value="'addForumMessage.action'" > </webwork:url>"> Add Message </a>
               
               <a href="#nowhere" onClick="javascript:confirmDelete('<webwork:url value="'deleteForumMessage.action'" >
						<webwork:param name="'target'" value="id" />
					</webwork:url>'	);" >
						Delete
			</a>
 
         </td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td width="225" class="bodyleft"><webwork:property value="topic"/><br/>
            <br/>
            posted by:<webwork:property value="user"/> - 
	    <webwork:property value="date"/>
	    </td>
          <td class="bodyright"><webwork:property value="message"/></td>
        </tr>
        </webwork:iterator>
      </table></td>
  </tr>
</table>
</table>
</body>
</html>