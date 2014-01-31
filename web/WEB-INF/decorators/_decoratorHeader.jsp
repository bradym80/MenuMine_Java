<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>
<%@ taglib uri="webwork" prefix="webwork" %>
<script type="text/javascript" src="js/wz_tooltip.js"></script>
<webwork:if test="menuMineSessionContextWrapper.valid">
  <div id="header">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" >
      <tr >
        <td width="226" class="fade"><a href="<webwork:url value="'dashboard.action'" includeParams="'none'"/>"><img src="img/logowhite.png" width="226" height="53" alt="MenuMine" border="0" /></a></td>
        <td class="fade" >
          <div id="headerMenu">
            <table width="100%">
              <tr>
                <td colspan="8"><p class="mainMenuPhone" >888-386-MENU &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p></td>
              </tr>
              <tr >
                <td  width="150"><a class="mainMenu" href="<webwork:url value="'dashboard.action'" includeParams="'none'"/>">Home</a> </td>
                <!-- 06-18-08 MJB removed "Select Mine" <td width="160"><a href="#nowhere" class="mainMenu" onclick="javascript:toggle('mailshortcuts');" >Select Mine</a>
                  <div id="mailshortcuts" class="shortcuts" style="display:none;">
                    <ul >
                      <li><a class="mainMenu" href="<webwork:url value="'dessertmine.action'" includeParams="'none'"/>">Dessert MenuMine</a></li>
                      <li><a class="mainMenu" href="<webwork:url value="'ingredientmine.action'" includeParams="'none'"/>">Ingredient MenuMine</a></li>
                      <li><a class="mainMenu" href="<webwork:url value="'beveragemine.action'" includeParams="'none'"/>">Beverage MenuMine</a></li>
                      <li ><a class="mainMenu" href="<webwork:url value="'breakfastmine.action'" includeParams="'none'"/>">Breakfast MenuMine</a></li>
                    </ul>
                  </div></td>-->
                <td class="mainMenu" width="60%">&nbsp;</td>
                <webwork:if test="menuMineSessionContextWrapper.adminRights">
                  <td class="mainMenu" style="text-align:right; width:60px;"><a class="mainMenu" href="<webwork:url value="'/administrationMenu.action'"  includeParams="'none'"/>">Admin</a></td>
                </webwork:if>
                <webwork:else>
                  <td class="mainMenu" style="text-align:right; width:60px;"> &nbsp;</td>
                </webwork:else>
                <td class="mainMenu" style="text-align:right; padding-right:10px; width: 60px;"><a class="mainMenu" href="<webwork:url value="'logout.action'" includeParams="'none'"/>">Logout</a></td>
              </tr>
            </table>
          </div>
        </td>
      </tr>
    </table>
  </div>
</webwork:if>
<webwork:else> </webwork:else>
<webwork:if test="hasErrors() || hasActionMessages()">
  <div id="systemErrors">
    <webwork:if test="hasActionMessages()">
      <h1>Errors</h1>
      <ul>
        <webwork:iterator value="actionErrors">
          <li>
            <webwork:property/>
          </li>
        </webwork:iterator>
      </ul>
    </webwork:if>
    <webwork:if test="hasActionMessages()">
      <h1>Messages</h1>
      <ul>
        <webwork:iterator value="actionMessages">
          <li>
            <webwork:property/>
          </li>
        </webwork:iterator>
      </ul>
    </webwork:if>
  </div>
</webwork:if>
