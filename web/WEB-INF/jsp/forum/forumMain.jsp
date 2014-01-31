<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>
<style>
 .titleleft{
 border-left:1px solid #cccccc; 
 border-top:1px solid #cccccc; 
 border-right:1px solid #cccccc; 
 background-image:url(topbg.gif);
 height:25px; 
 }
 .titleright{
 border-top:1px solid #cccccc; 
 border-right:1px solid #cccccc; 
 background-image:url(topbg.gif); 
 color:#2F68A3;"; 
 font-family:Optima, Lucida, MgOpen Cosmetica, Lucida Sans Unicode, sans-serif;font-size:11px; 
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
</head>
<body>
<p>
<table width="750" border="0" cellspacing="0" cellpadding="1" align="center">
  <tr>
    <td style="border:2px solid #2F68A3;"><table width="750" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="51px" class="titleleft"></td>
          <td class="titleright" align="center">Forum</td>
        </tr>
        <tr>
          <td class="bodyleft"><img src="img/forumbutton.gif"></td>
          <td class="bodyright"><a class="menuLink" href="<webwork:url value="'viewForumGroup.action'" > <webwork:param name="'publicMessages'" value="'true'" /> </webwork:url>"> Public Board </a></td>
        </tr>
        <tr>
          <td class="bodyleft"><img src="img/forumbutton.gif"></td>
          <td class="bodyright" ><a class="menuLink" href="<webwork:url value="'viewForumGroup.action'" > <webwork:param name="'privateMessages'" value="'true'" /> </webwork:url>"> Private Board </a></td>
        </tr>
        <tr>
          <td class="bottombodyleft"><img src="img/forumbutton.gif"></td>
          <td class="bottombodyright" ><a class="menuLink" href="<webwork:url value="'viewForumGroup.action'" > <webwork:param name="'chefMessages'" value="'true'" /> </webwork:url>"> Chef Board </a></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>