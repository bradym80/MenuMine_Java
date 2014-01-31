<%@ taglib uri="webwork" prefix="webwork" %>

<html>
<head>

<script language="javascript">

var queryTerm;
var genMenuPart;
var cuisineFamily;
var genCookingMethod;

function executePost(params, url, postEvent) {
	var bindArgs = {
		url: url,
		method: "post",
		error: function(type, data, evt){alert("error - lost connection with the server.");},
		mimetype: "text/json",
		content: params
	};
	var req = dojo.io.bind(bindArgs);
	
	if (postEvent) {
		dojo.event.connect(req, "load", this, postEvent);
	}
}

function getFlavorTrackResult() {
	executePost(null, "getFlavorTrakResults.json", "populateFlavorTrakResults");
}

function populateFlavorTrakResults(type,data,evt) {
	var ret = "";

	ret += "" + data['recordCount'] + " records";

	dojo.byId('flavorTrakResults').innerHTML = ret;

	dojo.byId('flavorTrakLink').style.display = "block";
}

function updateFlavorTrakContext(params) {
	executePost(params, "updateFlavorTrakContext.json", "getFlavorTrackResult" );
}

function resetFlavorTrak() {
	dojo.byId('queryString').value = "";
	updateQueryString();
	setGenMenuPart("[none]");
	setCuisineFamily("[none]");
	setGeneralCookingMethod("[none]");
}

function updateQueryString() {
	var params = new Array();
	var newQueryString = "[none]";
	if (dojo.byId('queryString').value && dojo.byId('queryString').value.length > 0) {
		newQueryString = dojo.byId('queryString').value;
	}
	params['queryString'] = newQueryString;
	updateFlavorTrakContext(params);
	
}


function setGenMenuPart(newGenMenuPart) {

	clearSelectedDiv(genMenuPart);

	if (genMenuPart == newGenMenuPart) {
		newGenMenuPart="[none]";
	}

	genMenuPart = newGenMenuPart;

	highlightSelectedDiv(genMenuPart );

	var params = new Array();
	params['genMenuPart'] = genMenuPart ;
	updateFlavorTrakContext(params);
	
}

function setCuisineFamily(newCuisineFamily) {

	clearSelectedDiv(cuisineFamily);

	if (cuisineFamily== newCuisineFamily) {
		newCuisineFamily="[none]";
	}

	cuisineFamily= newCuisineFamily;

	highlightSelectedDiv(cuisineFamily);

	var params = new Array();
	params['cuisineFamily'] = cuisineFamily;
	updateFlavorTrakContext(params);
	
}

function setGeneralCookingMethod(newGenCookingMethod) {

	clearSelectedDiv(genCookingMethod);

	if (genCookingMethod == newGenCookingMethod) {
		newGenCookingMethod="[none]";
	}

	genCookingMethod = newGenCookingMethod;

	highlightSelectedDiv(genCookingMethod);
	
	var params = new Array();
	params['genCookingMethod '] = genCookingMethod;
	updateFlavorTrakContext(params);
}


function clearSelectedDiv(selectedDivId) {
	if (selectedDivId != "[none]") {
	if (selectedDivId) {
		dojo.byId(selectedDivId).className = "";
	}}

}

function highlightSelectedDiv(selectedDivId) {
	if (selectedDivId != "[none]") {
	if (selectedDivId) {
		dojo.byId(selectedDivId).className = "selected";
	}
	}
}




</script>

<style>
.jslink {
	cursor: pointer;
}

.selected {
	background-color: #ff0;
}

#filters td {
	font-size: 10pt;
}

#flavorTrakResults {
	color: #333;
	font-size: 48pt;
	text-align: right;
}
</style>

</head>

<body>

<table width="100%">
<tr>
<td width="50%">
<h1>FlavorTrak<sup>&reg;</sup></h1>
</td>
<td width="50%" align="right">
<div id="flavorTrakResults" ></div>
</td>
</tr>
</table>

<p>Start by entering a search term in the box below and clicking go.  Then select up to three additional limiting fields to narrow your results.</p>
<table>

<tr>

<td>

<form method="post" name="flavorTrakForm" onsubmit="updateQueryString(); return false;">

<input type="text" id="queryString" name="queryTerm" size="30" />

<input type="button" name="updateQueryTerm" value="Go" onclick="updateQueryString();" />

<input type="button" name="reset" value="Reset" onclick="resetFlavorTrak();" />


</form>

</td>

<td>



</td>

<td>
<div id="flavorTrakLink" style="display: none;">View <a href="<webwork:url value="'menumineFlavorTrakToSpreadsheet.action'" />">Spreadsheet</a>.</div>

</td>

</tr>

</table>

<div id="filters">
<table>

<tr>

<td>

<h2>Menu Part</h2>

<table>

<webwork:iterator value="genMenuPart">



<tr id="<webwork:property />">
	<td><a class="jslink" onclick="setGenMenuPart('<webwork:property />');"><webwork:property /></a></td>
</tr>

</webwork:iterator>

</table>

</td>

<td>

<h2>Cuisine Family</h2>

<table>


<webwork:iterator value="cuisineFamily">

<tr id="<webwork:property />">
	<td><a class="jslink" onclick="setCuisineFamily('<webwork:property />');"><webwork:property /></a></td>
</tr>

</webwork:iterator>

</table>

</td>

<td>

<h2>Cooking Method</h2>

<table>

<webwork:iterator value="genCookingMethod">

<tr id="<webwork:property />">
	<td><a class="jslink" onclick="setGeneralCookingMethod('<webwork:property />');"><webwork:property /></a></td>
</tr>

</webwork:iterator>

</table>

</td>

</tr>

</table>
</div>

<script>
newQueryString = dojo.byId('queryString').focus();
</script>

</body>
</html>