<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head></head>
<body>

<webwork:include page="../auth/_adminHeaderMenu.jsp"/> 

<h1>Saved HSSF Files</h1>

<ul>
<webwork:iterator value="fileNames">
	<li><a href="hssf/<webwork:property />"><webwork:property /></a></li>
</webwork:iterator>
</ul>

<p>Clear cache?  This will permamnently delete all saved Excel files.</p>

<p><a href="hssfFileList.action?delete=yes">Yes, Delete (will not confirm)</a></p>
</body>
</html>

