var brags;
var current = null;
var nextBragIndex = 0;

function updateBrag() {
	if (nextBragIndex > brags.length-1) {
		nextBragIndex = 0;
	}
	
	// DBB 1-20-2009 Display the brag even if a price isn't set
	if(1 /*brags[nextBragIndex]['price'] != null*/){
		var braghtml = "";
		braghtml += "<h1>" + brags[nextBragIndex]['menuItemName'] + "</h1>";
		braghtml += "<p class='itemDescription'>" + brags[nextBragIndex]['itemDescription'] + "</p>";
		braghtml += "<p class='detail'>" + brags[nextBragIndex]['operationName'] + ", $" + (brags[nextBragIndex]['price'].toFixed(2)) + "</p>";
				
		var bragDiv = document.getElementById("newItemBragDiv");
	
		bragDiv.innerHTML = braghtml;
	}
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

///////