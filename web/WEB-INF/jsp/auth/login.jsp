<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>
<title>MenuMine - Menu Information Database</title>
</head>
<body>
<webwork:iterator value="actionErrors" >
  <p>
    <webwork:property />
</webwork:iterator>
<script type="text/javascript" src="js/itemBrag.js"></script>
<script>
dojo.event.connect(window,"onload","getItemBrags");
</script>
<style type="text/css">
<!--
body {
	margin:0;
	padding:0;
	height:100%; /* needed for container min-height */
	font-family:Optima, Lucida, MgOpen Cosmetica, Lucida Sans Unicode, sans-serif;
	font-size:small;
	background-image: url(img/pageBg.jpg);
	background-color: #8fc2f1;
	background-repeat: repeat-x;
	background-position: top left;
	background-position: 0% 0%;
}
.style1 {
	font-size: 12px;
	color: #FFFFFF;
	text-shadow: gray 1px 1px 2px;
}

input
{
	background:url(img/inputBg.gif) no-repeat;
	width:149px;
	height:22px;
	margin-left:10px;
	margin-bottom:15px;
	border:none;
	padding-left:15px;
}


#newItemBragDiv {
	font-family: Optima, Lucida, MgOpen Cosmetica, Lucida Sans Unicode, sans-serif;
	width: 100%;
	text-align: left;
	padding: 2px;
}
#newItemBragDiv h1 {
	border: 0px;
	margin: 0px;
	font-size: 18px;
	color: #1c6aa6;
}
#newItemBragDiv p.detail {
	border: 0px;
	margin: 0px;
	font-size: 18px;
	color: #1c6aa6;
}
-->
</style>
<script type="text/javascript" src="js/swfobject.js"></script>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
            <td style="text-align:center;"><img align="middle" src="img/bigLogo.gif" width="332" height="83"></td>
          </tr>
  <tr>
    <td><table width="100%" cellspacing="20" cellpadding="0">
        <tr>
          <td><br>

            <table width="681" align="center" cellpadding="0" cellspacing="10" background="img/loginBack.png">
              <tr>
                <td width="188" valign="top"><form name="loginForm" action="login.action" method="post"   >
                    <table width="100%" cellspacing="0" cellpadding="0">
                      <tr>
                        <td><img src="img/loginTitle.gif" width="50" height="16" style="padding-left:10px;padding-top:35px;padding-bottom:20px"> </td>
                      </tr>
                      <tr>
                        <td height="32" valign="top"><label> <img src="img/username.gif" width="69" height="11" style="padding-left:10px;padding-bottom:4px;">
                          <input name="username" type="text" id="login_username" size="10">
                          </label>
                        </td>
                      </tr>
                      <tr>
                        <td><img src="img/password.gif" width="64" height="12" style="padding-left:10px;padding-bottom:4px;">
                          <input name="password" type="password" id="login_password" size="10">
                          <input type="submit" value="" name="submit" style="cursor:pointer; background: url(img/loginBttn.gif) no-repeat; width: 97px; height: 22px;"/>
                        </td>
                      </tr>
                    </table>
                  </form></td>
                <td width="463"><!--
													<img src="login_files/flashArea.jpg" height="321" width="464">
													-->
                  <div id="flashcontent"> <strong>You need to upgrade your Flash Player</strong> </div>
                  <script type="text/javascript">
													// <![CDATA[
													
													var so = new SWFObject("flash/imageFade.swf", "sotester", "464", "321", "8", "black");
													so.write("flashcontent");
													
													// ]]>
												</script>
                </td>
              </tr>
            <!-- 2009-06-06 MJB Add this back if new item brag ever starts working again.
           </table>
            <table width="681" border="0" align="center" cellpadding="0" cellspacing="10" background="img/newItemBack.png" style="margin-top:10px; background-repeat:no-repeat">
                    <tr>
                      <td width="100%" height="120"><div style="text-align:left;" id="newItemBragDiv"> </div></td>
                    </tr>
                  </table>-->
           </td>
        </tr>
      </table></td>
  </tr>
  <tr style="height:120px">
    <td><table width="100%" border="0" cellspacing="20" cellpadding="0">
        <tr>
          <td width="100%"><br>
          </td>
          <td height="80"><p class="style1"> <strong>Food&nbsp;Service&nbsp;Research&nbsp;Institute,&nbsp;Inc.</strong> <br>
              6957 West North Avenue, Suite 201<br>
              Oak Park, IL 60302<br>
              <a href="http://www.foodserviceresearchinstitute.com"> foodserviceresearchinstitute.com</a><br>
              888.386.MENU</p></td>
        </tr>
        <tr>
          <td></td>
          <td><div id="loginSpace"></div></td>
        </tr>
      </table></td>
  </tr>
</table>

<script type="text/javascript" language="JavaScript">
  <!--
  var focusControl = document.forms["loginForm"].elements["username"];

  if (focusControl.type != "hidden") {
     focusControl.focus();
  }
  // -->
</script>
</body>
</html>
