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
</head>
<body>
<p>

<table width="750" border="0" cellspacing="0" cellpadding="1" align="center">
  <tr>
    <td style="border:2px solid #2F68A3;"><table width="750" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="titleright">Post a message</td>
        </tr>
        <tr>
          <td style="border:1px solid #cccccc;"><webwork:form method="'POST'" action="'addForumMessage.action'" name="'addForumMessage'"> <webwork:textfield size="50" name="'forumMessage.topic'" value="forumMessage.topic" /> <webwork:textarea rows="8" cols="75" name="'forumMessage.message'" value="forumMessage.message" /> <webwork:submit cssClass="'filterButtons'"  name="'submit'" value="'Save'" /> </webwork:form></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
