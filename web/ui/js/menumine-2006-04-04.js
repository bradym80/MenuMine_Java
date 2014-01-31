var expandedSections = new Array();

var currentPoppedSection = null;
var currentPoppedSectionHasMousedOver = false;

var defaultOption = "spreadsheetOptions";

initializeExpandedSections();

/*
var IE = document.all?true:false;
if (!IE) document.captureEvents(Event.MOUSEMOVE)
document.onmousemove = getMouseXY;
var currentMouseX = 0;
var currentMouseY = 0;

var activeTop = 0;
var activeLeft = 0;
var activeWidth = 0;
var activeHeight = 0;
var popupMouseTolerance = 50;

function getMouseXY(e) {
      if (IE) { // grab the x-y pos.s if browser is IE
      	currentMouseX = window.event.clientX + document.body.scrollLeft;
      	currentMouseY = window.event.clientY + document.body.scrollTop;
      } else {  // grab the x-y pos.s if browser is NS
      	currentMouseX = e.pageX;
      	currentMouseY = e.pageY;
      }  
      if (currentMouseX < 0){currentMouseX = 0;}
      if (currentMouseY < 0){currentMouseY = 0;}  

	if (currentPoppedSection != null && currentPoppedSectionHasMousedOver ) {
		if (currentMouseX < activeLeft - popupMouseTolerance  ||
			currentMouseX > activeLeft + activeWidth + popupMouseTolerance ||
			currentMouseY < activeTop - popupMouseTolerance ||
			currentMouseY > activeTop + activeHeight + popupMouseTolerance ) {

			hideActivePopup();
		}
	}
      return true;
}
*/

function initializeExpandedSections() {
	var allCookies = document.cookie;
	var pos = allCookies.indexOf("expandedSections=");
	if (pos != -1) {
		var start = pos + 17;
		var end = allCookies.indexOf(";",start);
		if (end == -1) {
			end = allCookies.length;
		}
		var raw = allCookies.substring(start,end);
		raw = unescape(raw);
				
		expandedSections = raw.split("**");

	}
}

function isExpanded(sectionName) {
	var isExpanded = false;

	for (i = 0; i < expandedSections.length; i++) {
		if (expandedSections[i] == sectionName) {
			isExpanded = true;
			break;
		}
	} 

	return isExpanded;
}

function addExpandedSection(sectionName) {
	if (sectionName == '') {
		return;
	}

	if (!isExpanded(sectionName)) {
		expandedSections[expandedSections.length] = sectionName;
	}
	persistExpandedSectionsAsCookie();
}

function removeExpandedSection(sectionName) {

	if (!isExpanded(sectionName)) {
		return;
	}



	var newExpandedSections = new Array();

	for (i = 0; i < expandedSections.length; i++) {
		if (expandedSections[i] != sectionName) {
			newExpandedSections[newExpandedSections.length] = expandedSections[i];
		}
	}
	expandedSections = newExpandedSections;
	persistExpandedSectionsAsCookie();
}

function persistExpandedSectionsAsCookie() {
	var value = '';
	for (i = 0; i < expandedSections.length; i++) {
		if (value != '') {
			value = value + "**";
		}
		if (expandedSections[i] != null) {
			value = value + expandedSections[i];
		}
	} 

	setCookie("expandedSections",value);
}



function selectAllRollUpBuilder(){
	var selectedValue = document.menuMineRollUp.selectAll.checked;
	
	for(i=0; i < document.menuMineRollUp.elements.length; i++){
	
		if (selectedValue && i > 50) {
			alert('Maximum of 50 checkboxes reached.  Rollup these 50 and then continue with the next group.');
			break;
		}
	var ele = document.menuMineRollUp.elements[i];
	
		if(ele.type == 'checkbox' && ele.name.indexOf('rollUpParameters') >-1)
		{
			ele.checked=selectedValue;
		}
	}
}


function setCookie(name, value){
	document.cookie=name + "=" + escape(value);
}

function DelCookie(sName) {

	var element=document.getElementById(sName);
	if(element != null){
		document.cookie = sName + "=" + "a" + "; expires=Fri, 31 Dec 1970 23:59:59 GMT;";
	}
}

function expand(x, y){
	if(y != null)
	{
		y.src="img/collapse.gif";
	}
	
	if(x != null)
	{
		x.style.display='block';
	}
	
}
function collapse(x, y){

	if(x != null)
	{
		x.style.display='none';
		
	}
	if( y != null)
	{
	y.src="img/expand.gif";
	}
	
	
}
function expand2(x){
	
	//alert("should be expanding xx" + x + "xx");
	var element=document.getElementById(x);
	//alert("element is null? " + x + "<br/>");
	var image=document.getElementById(x + "_image");
	//alert("image is null? " +image + "<br/>");
	if(image != null &&  element != null)
	{
		expand(element,image);
	}
}




function initOptions(x){
	setDefaultOption(x);
	toggle(x);
}

function setDefaultOption(name)
{
	 defaultOption = name;
}


function toggleInterceptExpandDefault(x)
{
	if(defaultOption == null)
	{
		return;
	}

	if(x.indexOf("Options") >0)
	{
		elementTemp=document.getElementById(defaultOption);
		expand(elementTemp, null);
	}	
}

function handleToggleInterceptOptions(x,y) {
	if (x != y) {
	 	var elementTemp=document.getElementById(y);
 		collapse(elementTemp, null);
	}
}

function toggleInterceptOptions(x)
{

	if(x.indexOf("Options") >0) {
		handleToggleInterceptOptions(x,"menushareOptions");
		handleToggleInterceptOptions(x,"spreadsheetOptions");
		handleToggleInterceptOptions(x,"medianPriceTrendOptions");
		handleToggleInterceptOptions(x,"meanPriceTrendOptions");
		handleToggleInterceptOptions(x,"categoryIncidenceOptions");
		handleToggleInterceptOptions(x,"itemsPerChainMenuingOptions");
		handleToggleInterceptOptions(x,"crossTabOptions");
		handleToggleInterceptOptions(x,"graphOptions");
		handleToggleInterceptOptions(x,"nabOptions");
		handleToggleInterceptOptions(x,"rollupOptions");
	}
}



function toggle(x){

	
	if(x == null)
	{
		return;
	}

	

	var element=document.getElementById(x);
	var image=document.getElementById(x + "_image");
	
	if (element == null) {
		return;
	}
		
	if (element.style.display=='block'){
		removeExpandedSection(x);
		//setCookie(x, '');
		collapse(element, image);
		toggleInterceptExpandDefault(x);
	}
	else {
		addExpandedSection(x);
		toggleInterceptOptions(x);
		//setCookie(x, 'true');
		expand(element, image);
	}
}

function showPopup(x) {
	showPopupAtHeight(x,100);
}

function showPopupAtHeight(elementName, pixelHeight) {
	if (elementName == null) { return; }

	if (currentPoppedSection == elementName) {
		hidePopup(currentPoppedSection);
		return;
	} else if (currentPoppedSection != null) {
		hidePopup(currentPoppedSection);
	}


	
	if (pixelHeight < 200 || (document.URL.indexOf('NatlAccount') > 0 && pixelHeight < 450)) {
		hideElementsBehindPopups();
	}

	currentPoppedSection = elementName;

	var element = document.getElementById(elementName);
	element.style.display = 'block';
	element.style.top = '' + pixelHeight + 'px';

	activeLeft = element.offsetLeft+10;
	activeTop = element.offsetTop;
	activeHeight = element.offsetHeight;
	activeWidth = element.offsetWidth;

	//alert ('ltwh ' + activeLeft + ', ' + activeTop + ', ' + activeHeight + ', ' + activeWidth);

	currentPoppedSectionHasMousedOver = false;
}

function hidePopup(x) {
	if (x == null) { return; }

	var element = document.getElementById(x);

	element.style.display = 'none';
	currentPoppedSection = null;

	showElementsBehindPopups();
}

function hideElementsBehindPopups() {
	handleElementsBehindPopupsVisibility(false);	
}

function showElementsBehindPopups() {
	handleElementsBehindPopupsVisibility(true);
}

function handleElementsBehindPopupsVisibility(isVisible) {

	var elementIds = ['menumineSpreadSheet_menuMineDisplayOptions.sortBy',
				'menumineSpreadSheet_menuMineDisplayOptions.sortType',
				'menumineStatisticalTable_menuMineGraphOptions.graphByField',
				'menumineMedianPriceTrend_menuMineGraphOptions.graphByField',
				'menumineMeanPriceTrend_menuMineGraphOptions.graphByField',
				'menumineCrossTabulation_menuMineCrossTabulationOptions.horizontalField',
				'menumineCrossTabulation_menuMineCrossTabulationOptions.horizontalRollUpName',
				'menumineGraph_menuMineGraphOptions.graphByField',
				'menumineNatlAccountBenchmark_menuMineGraphOptions.graphByField',
				'menumineNatlAccountBenchmark_nationalAccountBenchmarkWebOptions.targetSectors',
				'menumineNatlAccountBenchmark_nationalAccountBenchmarkWebOptions.targetSegments'
				];

	for (var i = 0; i < elementIds.length; i++) {
		var element = document.getElementById(elementIds[i]);

		if (element != null) {
			if (isVisible) {
				element.style.visibility = 'visible';
			} else {
				element.style.visibility = 'hidden';
			}
		}
	}
}

function hideActivePopup() {
	hidePopup(currentPoppedSection);
}

/*
function handlePopupMouseOver() {

		
		currentPoppedSectionHasMousedOver = true;
}
*/


function toggleMainForm(x) {
	
	if (x == null) { return; }

	removeExpandedSection('mainFormSummary');
	removeExpandedSection('mainFormDiv');
	removeExpandedSection('mainFormQueryManager');
	collapse(document.getElementById('mainFormSummary'),null);	
	collapse(document.getElementById('mainFormDiv'),null);	
	collapse(document.getElementById('mainFormQueryManager'),null);	

	expand(document.getElementById(x),null);
	addExpandedSection(x);
	//setCookie(x,'true');
}

function initialize() {
	var mainFormFound =false;

	var mainFormElement = "mainFormDiv"; //default

	for (i = 0; i < expandedSections.length; i++) {

		if (expandedSections[i].indexOf("mainForm") > -1) {
			mainFormElement = expandedSections[i];
		} else {
			expand2(expandedSections[i]);
		}
	}

	expand(document.getElementById(mainFormElement),null);
}


function resetCookies() {

	//document.write("cookies: " + document.cookie);

	var cookies=document.cookie.split(";");
	//document.write("<br/>");		
	
	var elementId = null;
	
	for(var i=0; i<cookies.length; i++){
			a=cookies[i];
			aparts=a.split("=");
			//document.write("cookie " + i + " length is " + aparts.length);
			if (aparts.length > 1 && aparts[1] != '') {
				elementId = aparts[0];
				elementId = elementId.replace(" ","");
				//document.write(elementId);
				DelCookie(elementId);
			}
	}
	
	
}




function popUp(URL) {
day = new Date();
id = day.getTime();
eval("page" + id + " = window.open(URL, '" + id + "', 'toolbar=1,scrollbars=1,location=0,statusbar=1,menubar=0,resizable=1,width=550,height=400');");
}

function handleSortBy(word) {
 	
	for(i = 0; i <document.forms['menuMineSpreadSheet'].elements['menuMineGraphOptions.graphByField'].options.length; ++i )
	{
		if(document.forms['menuMineSpreadSheet'].elements['menuMineGraphOptions.graphByField'].options[i].text==word)
		{
		 	document.forms['menuMineSpreadSheet'].elements['menuMineGraphOptions.graphByField'].options[i].selected=true;
		}
	}

	//document.forms['menuMineSpreadSheet'].submit();
}


function handleSortByUp(word) {
 
 	for(i = 0; i <document.forms['menuMineSpreadSheet'].elements['menuMineDisplayOptions.sortType'].options.length; ++i )
	{

		if(document.forms['menuMineSpreadSheet'].elements['menuMineDisplayOptions.sortType'].options[i].value=="ASC")
		{
		 	document.forms['menuMineSpreadSheet'].elements['menuMineDisplayOptions.sortType'].options[i].selected=true;
		}
	}
	handleSortBy(word)
}

function handleSortByDown(word) {
 	
 	for(i = 0; i <document.forms['menuMineSpreadSheet'].elements['menuMineDisplayOptions.sortType'].options.length; ++i )
	{
		if(document.forms['menuMineSpreadSheet'].elements['menuMineDisplayOptions.sortType'].options[i].value=="DESC")
		{
		 	document.forms['menuMineSpreadSheet'].elements['menuMineDisplayOptions.sortType'].options[i].selected=true;
		}
	}
	handleSortBy(word)
}



function handleGraphTarget(word) {
 	
	for(i = 0; i <document.forms['menuMine'].elements['menuMineGraphOptions.graphByField'].options.length; ++i )
	{
		if(document.forms['menuMine'].elements['menuMineGraphOptions.graphByField'].options[i].text==word)
		{
		 	document.forms['menuMine'].elements['menuMineGraphOptions.graphByField'].options[i].selected=true;
		}
	}
	document.forms['menuMine'].elements['menuMineGraphOptions.graphTitle'].value=word;
}

function handleFilterByWord(field,word) {
	var test = null;

	test = document.forms['menuMine'].elements[field];

	if (test != null) {
		if (test.value != null && test.value != "") {
			test.value = test.value + ",";
		}
		test.value = test.value  + word;
		document.menuMine.submit.click();
	}
}

function wordClickRollUp(word) {
	var test = null;

	test = document.forms['menuMineStatisticalTable'].elements['menuMineGraphOptions.rollUpTerms'];

	if (test != null) {
		if (test.value != null && test.value != "") {
			test.value = test.value + ",";
		}
		test.value = test.value  + word;
	}	
}




function clearField(fieldAndName, fieldOrName,fieldNotName, selectFieldName, empty) {
	
	 
	 var emptyString = empty+".empty";
	 var notEmptyString = empty+".notEmpty"; 
	 
	 var emptyField = document.forms['menuMine'].elements[emptyString];
	
	 var notEmptyField = document.forms['menuMine'].elements[notEmptyString];
	 emptyField.checked=false;
	 notEmptyField.checked=false;
	 
	 
	  clearField3(fieldAndName, fieldOrName,fieldNotName, selectFieldName);
	  
}


function clearField3(fieldAndName, fieldOrName,fieldNotName, selectFieldName) {
	var andField = document.forms['menuMine'].elements[fieldAndName];
	andField.value="";
	
	var orField = document.forms['menuMine'].elements[fieldOrName];
	orField.value="";
	
	var notField = document.forms['menuMine'].elements[fieldNotName];
	notField.value="";

	for(i = 0; i <document.forms['menuMine'].elements[selectFieldName].options.length; ++i )
	{
		document.forms['menuMine'].elements[selectFieldName].options[i].selected=false;
		
	}
}

function clearField2(fieldName, selectFieldName) {
	var field = document.forms['menuMine'].elements[fieldName];
	
	field.value="";

	for(i = 0; i <document.forms['menuMine'].elements[selectFieldName].options.length; ++i )
	{
		document.forms['menuMine'].elements[selectFieldName].options[i].selected=false;
		
	}
}

 function clearField1(fieldName) {
 	var field = document.forms['menuMine'].elements[fieldName];
 	field.value="";
 }




function closePopUp(popup)
{
	for(i=0; i<1000000; ++i)
	{}
	popup.close();
}

 
