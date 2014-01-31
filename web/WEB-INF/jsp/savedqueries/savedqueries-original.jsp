<%@ taglib uri="webwork" prefix="webwork"%>

<html>
<head>

<script type="text/javascript" language="javascript">
<!--
function setCookie(name, value){
	document.cookie=name + "=" + escape(value);
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

	if(x != null &&  y != null)
	{
		x.style.display='none';
		y.src="img/expand.gif";
	}
	
}
function expand2(x){
	//alert("should be expanding xx" + x + "xx");
	var element=document.getElementById(x);
	//document.write("element is null? " + x + "<br/>");
	var image=document.getElementById(x + "_image");
	//document.write("image is null? " +image + "<br/>");
	if(image != null &&  element != null)
	{
		expand(element,image);
	}
}

function toggle(x){

	var element=document.getElementById(x);
	var image=document.getElementById(x + "_image");
	
	if (element.style.display=='block'){
		setCookie(x, '');
		collapse(element, image);
		}
		else {
			setCookie(x, 'true');
			expand(element, image);
		}
}
function initialize() {
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
				expand2(elementId);
			}
	}
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
				setCookie(elementId, '');
			}
	}
}




//-->
</script>
</head>
<body>
<p>
<h2>Saved Query Manager</h2>

<webwork:form theme="'simple'" method="'POST'"
	action="'savedQueryList.action'" name="'savedQueries'">
	<table width="100%" border="1" class="results">
		<tr>
			<td colspan="4">< webwork:submit cssClass="'filterButtons'"
			theme="'simple'" name="'submit'" value="'Update'" /></td>
		</tr>
		<tr>
			<th class="resultHeader">Name</th>
			<th class="resultHeader">User Name</th>
			<th class="resultHeader">Group</th>
			<th class="resultHeader">Permission</th>
			<th class="resultHeader">Delete</th>
		</tr>
		<webwork:iterator value="savedQueries" status="mestatus">
			<tr class="resultHeader">
				<td><webwork:textfield size="'100'" theme="'simple'"
					name="'savedQueries[' + (#mestatus.count - 1) + '].name'"
					value="name" /></td>
				<td><webwork:property value="userName" />&nbsp;</td>
				<td><webwork:if test="menuMineSessionContextWrapper.adminRights">
					<webwork:select theme="'simple'"
						name="'savedQueries[' + (#mestatus.count - 1) + '].groupName'"
						value="groupName" list="groups" listKey="name" listValue="name" />
				</webwork:if> <webwork:else>
					<webwork:property value="groupName" />
				</webwork:else> &nbsp;</td>
				<td><webwork:select theme="'simple'"
					name="'savedQueries[' + (#mestatus.count - 1) + '].permission'"
					value="permission" list="#{1:'User', 2:'Group'}" /> &nbsp;</td>
				<td><webwork:checkbox theme="'simple'"
					name="'deleteArray[' + (#mestatus.count - 1) + '].id'"
					fieldValue="id" /></td>
			</tr>
			<%--		
				<tr>
				<td colspan="4"><webwork:set name="querySummary"
					value="masterFoodFilterParameters.summary" /> <webwork:include
					page="../menumine/_menuMineGeneralQuerySummaryParagraphImpl.jsp" />
				</td>
			</tr>
			--%>
		</webwork:iterator>
		<tr>
			<td colspan="4"><webwork:submit cssClass="'filterButtons'"
				theme="'simple'" name="'submit'" value="'Update'" /></td>
		</tr>
	</table>
</webwork:form>
</body>
</html>
