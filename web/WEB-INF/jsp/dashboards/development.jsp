<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>
<title>Welcome to MenuMine</title>
<script>

var categoryTemplates;
/* JDL 04-24-08 Removed new Item Brag on the right to move to login
var brags;
var current = null;
var nextBragIndex = 0;

function updateBrag() {
	if (nextBragIndex > brags.length-1) {
		nextBragIndex = 0;
	}
	
	var braghtml = "";
	braghtml += "<h1>" + brags[nextBragIndex]['menuItemName'] + "</h1>";
	//braghtml += "<p class='itemDescription'>" + brags[nextBragIndex]['itemDescription'] + "</p>";
	braghtml += "<p class='detail'>" + brags[nextBragIndex]['operationName'] + ", $" + (brags[nextBragIndex]['price'].toFixed(2)) + "</p>";

	var bragDiv = document.getElementById("newItemBragDiv");

	bragDiv.innerHTML = braghtml;

	nextBragIndex++;
	window.setTimeout("updateBrag()",5000);
}

function getItemBrags() {
	executeRequest(null, "getItemBrags.json", "populateItemBrags");
}

function populateItemBrags(type,data,evt) {
	brags = data;
	updateBrag();
}
*/
function validateQueryTemplate() {
	var ret = true;

      var value = document.loadTemplateForm.target[document.loadTemplateForm.target.selectedIndex].value;

	if (value == 0) {
		ret = false;
	}

	if (ret) {
		document.loadTemplateForm.submit();
	}

	return ret;
}

function executeRequest(params, url, postEvent) {
	var bindArgs = {
		url: url,
		method: "post",
		error: function(type, data, evt) { /*alert("error executing request");*/ },
		mimetype: "text/json",
		content: params
	};
	var req = dojo.io.bind(bindArgs);
	if (postEvent) {
		dojo.event.connect(req, "load", this, postEvent);
	}
}

function getCategoryTemplates() {
	executeRequest(null, "getCategoryTemplates.json", "populateCategoryTemplates");
}



function setTemplateGroup(templateGroup) {
	
	var templates = "<p>";

	var tlist = null;

	for (var i = 0; i < categoryTemplates.length; i++) {
		if (categoryTemplates[i]["templateGroup"] == templateGroup) {
			tlist = categoryTemplates[i]["templates"];
		}
	}


	for (var i = 0; i < tlist.length; i++) {
		templates += "<a class='jslink' href=\"menumineLoadTemplate.action?target=" + tlist[i]['id'] + "\">" + tlist[i]['name'] + "</a><br/>";
	}

	dojo.byId("templates").innerHTML = templates;
}

function populateCategoryTemplates(type,data,evt) {
	categoryTemplates = data;
	
	var headers = "<p>";

	var bullet = ' <img src="img/triangle-bullet.gif" width="5" height="9" alt="" />';
	
	for (var i = 0; i < data.length; i++) {
	
		headers += "<a class='jslink' onclick=\"setTemplateGroup('" + data[i]["templateGroup"] + "');\">" + data[i]["templateGroup"] + bullet + "</a><br/>";
	}
	
	dojo.byId("categories").innerHTML = headers;
	
	
}

function initialize() {
	getCategoryTemplates();
//	getItemBrags();
}

dojo.event.connect(window,"onload","initialize");


<!--
function showRecent(theTable)
{
      if (document.getElementById(theTable).style.display == 'none')
      {
            document.getElementById(theTable).style.display = 'block';
			//document.getElementById('showLink').visible = 'block';
			
      }
}
//-->

<!--
function hideRecent(theTable)
{
      if (document.getElementById(theTable).style.display == 'none')
      {
            document.getElementById(theTable).style.display = 'block';
			document.getElementById('hideLink').innerHTML = 'Hide';
      }
      else
      {
            document.getElementById(theTable).style.display = 'none';
			document.getElementById('hideLink').innerHTML = 'Show';
      }
}
//-->

</script>
<!--JDL 04-24-08 Removed new Item Brag on the right to move to login -->
</head>
<body>
<table width="100%"  border="0" cellspacing="0" cellpadding="2">
  <tr>
    <td width="194" valign="top"><table class="sectionTable" width="236" height="24" cellpadding="0" cellspacing="0">
        <tr>
          <td align="right"><div class="sectionHeader">
              <!--empty-->
              &nbsp;</div></td>
        <tr>
          <td><table id="recentTbl" width="236" border="0" cellpadding="0" cellspacing="0">
              <webwork:if test="userQueries == null">
                <tr>
                  <td class="sectionBody">Queries Initializing</td>
                </tr>
              </webwork:if>
              <webwork:else>
                <webwork:iterator value="userQueries" status="mestatus">
                  <tr>
                    <td  class="sectionBody"><a class="menuLink" href="<webwork:url value="'menumineLoadQuery.action'" >
                      <webwork:param name="'selectHistory'" value="name" />
                      </webwork:url>
                      ">
                      <webwork:property value="name" />
                      </a>
                      <webwork:if test="timestamp != null"> (
                        <webwork:property value="timestamp" />
                        ) </webwork:if>
                    </td>
                  </tr>
                </webwork:iterator>
              </webwork:else>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <p>&nbsp;</p></td>
    <td valign="top" width="420"><table border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="mainHeader"><img src="img/triangle-bullet.gif" width="5" height="9" alt="" />Search</td>
        </tr>
        <tr>
          <td><webwork:include page="../menumine/express/_menuMineExpressSearch.jsp" />
          </td>
        </tr>
        <tr>
          <td>Search for an ingredient, flavor, food or item on menus.</td>
        </tr>
         <tr>
          <td>&nbsp;</td>
        </tr>       
        <tr>
          <td class="mainHeader"><img src="img/triangle-bullet.gif" width="5" height="9" alt="" />Develop Data Set</td>
        </tr>
        <tr>
          <td>Dayparts such as Beverage, Desserts and Breakfast have unique menu item characteristics not relevant for items on Lunch/Dinner Menus. For this reason we have separated items in the database by the dayparts below.
	 		Click on an icon below to develop queries pertaining to your category of interest. Five data fields automatically appear. You may go to additional fields to build up your data set.</td>
        </tr>
        
        <tr>
          	<td align="center">
				<a class="mainMenu" href="<webwork:url value="'breakfastmine.action'" includeParams="'none'"/>"><img src="img/breakfastIcon.png" border="0" width="80" height="80" onMouseOver="Tip('Breakfast Mine')" onMouseOut="UnTip()"/></a>
				<a class="mainMenu" href="<webwork:url value="'ingredientmine.action'" includeParams="'none'"/>"><img src="img/ingredientIcon.png" border="0" width="80" height="80" onMouseOver="Tip('Includes Breakfast, Lunch and Dinner')" onMouseOut="UnTip()"/></a>
				<a class="mainMenu" href="<webwork:url value="'dessertmine.action'" includeParams="'none'"/>"><img src="img/dessertIcon.png" border="0" width="80" height="80" onMouseOver="Tip('Dessert Mine')" onMouseOut="UnTip()"/></a>
				<a class="mainMenu" href="<webwork:url value="'beveragemine.action'" includeParams="'none'"/>"><img src="img/beverageIcon.png" border="0" width="80" height="80" onMouseOver="Tip('Beverage Mine')" onMouseOut="UnTip()"/></a>
			</td>
        </tr>
        <tr>
         <td class="mainHeader"><img src="img/triangle-bullet.gif" width="5" height="9" alt="" />Category Templates</td>
       </tr>
       <tr>
         <td>Pre-formated queries that present all relevant data fields.<br></td>
       </tr>
         <td><table width="100%">
         	<tr>
         		<td valign="top" colspan="4"><div id="categoryheader">Daypart</div></td>
         	</tr>
				<tr>
                            <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=9668">Beverage</a></td>
                            <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=9670">Breakfast</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=9671">Lunch/Dinner</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=9669">Dessert</a></td>
			</tr>
			<tr>
         		<td valign="top" colspan="4"><div id="categoryheader">LTO's and New Items</div></td>
         	</tr>
				<tr>
                            <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=10279">LTO's 2011</a></td>
                            <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=10278">New Items 2011</a></td>
			    </tr>
				<tr>
					<td valign="top" colspan="4"><div id="categoryheader">Protein</a></td>
				</tr>
				<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8460">Beef</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8520">Chicken</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8519">Pork</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8518">Turkey</a></td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8517">Shrimp</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8528">Fish</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8516">Seafood</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8515">Lamb</a></td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8514">Deli Meats</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8513">Duck</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8512">Game Birds</a></td>
			    <td valign="top"></a></td>
			</tr>
			<tr>
					<td valign="top" colspan="4"><div id="categoryheader">Menu Part</a></td>
				</tr>
				<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8900">Appetizers</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8884">Salads</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8507">Soup</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8899">Pizza</td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8898">Center of Plate</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8897">Prepared Entrees</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8896">Burgers</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8895">Sandwiches</a></td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8511">Breakfast Entrees</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8508">Breakfast Sandwich</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8894">Side Dishes</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8893">Accompaniments</a></td>
			</tr>
			<tr>
					<td valign="top" colspan="4"><div id="categoryheader">Ingredients</a></td>
				</tr>
				<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8492">Rice</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8489">Beans</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8486">Potatoes</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8483">Pasta</td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8491">Eggs</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8488">Peppers</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8485">Tomatoes</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8482">Lettuce/Greens</a></td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8490">Breads</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8487">Fruit</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8484">Veggies</a></td>
			    <td valign="top"></a></td>
			</tr>
			<tr>
					<td valign="top" colspan="4"><div id="categoryheader">Flavor Enhancers</a></td>
				</tr>
				<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8501">Cooking Sauce</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8503">Marinades</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8500">Glazes</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8498">Dressings</a></td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8497">Condiments</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8499">Dipping Sauces</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8495">Breadings</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8494">Seasonings</a></td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8493">Salsa</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8526">Cheese</a></td>
			    <td valign="top"></a></td>
			    <td valign="top"></a></td>
			</tr>
			<tr>
					<td valign="top" colspan="4"><div id="categoryheader">Region</a></td>
				</tr>
				<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8481">Northeast</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8479">South</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8477">Central</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8478">West</a></td>
			</tr>
			 <tr>
					<td valign="top" colspan="4"><div id="categoryheader">Cuisine of Item</a></td>
				</tr>
				<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8476">Mexican/Tex Mex</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8472">Italian</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8468">Chinese</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8464">Mediterranean</a></td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8475">Caribbean</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8471">Japanese</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8467">Asian</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8463">Southwestern</a></td>
			</tr>
			<tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8474">American Traditional</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8470">Southern</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8466">Western</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8462">American BBQ</a></td>
			</tr>
			 <tr>
					<td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8473">American Spicy/Hot</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8469">Atlantic Seaboard</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8465">California Pacific</a></td>
			    <td valign="top"><a class="cattemplate" href="menumineLoadTemplate.action?target=8461">Cajun/Creole</a></td>
			</tr>
         
           </table>
</tr>
</tr>
        <!-- 06-20-08 MJB Added MenuBook to front page. -->
        <tr>
          <td>&nbsp;</td>
        </tr> 
		<tr>
          <td class="mainHeader"><img src="img/triangle-bullet.gif" width="5" height="9" alt="" />Chain MenuBook</td>
        </tr>
        <tr>
          <td>Menu items, prices, trends, HQ Sales/HQ Units, Map </td>
        </tr>
        <tr>
          <td><a href="<webwork:url value="'menuBookList.action'" includeParams="'none'"/>">Chain MenuBook</a>.</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td class="mainHeader"><img src="img/triangle-bullet.gif" width="5" height="9" alt="" />Flavor Profiler</td>
        </tr>
        <tr>
          <td>Research usage applications in <a href="<webwork:url value="'flavorProfiler.action'" includeParams="'none'"/>">Profiler</a>.</td>
        </tr>
		<tr>
          <td>&nbsp;</td>
        </tr>
        <!--MJB 05-15-09 -->
       
</table>
    <td><table width="100%">
          <tr>
     <td colspan="2" class="mainHeader" width="50%">More Templates</td>
   </tr>
         <tr>
           <td width="50%" valign="top"><div id="categories"></div></td>
           <td width="50%" valign="top"><div id="templates"></div></td>
         </tr>
       </table></td>
   </tr>
 </table></td>
</table>
<p>&nbsp;</p>
</body>
</html>
