<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head>




</head>
<body>

<br/>
		

<table border="1" cellspacing="0" cellpadding="0">




<tr>
	<td class="loginHistoryHeader" align="left" >Username</td>
	<td class="loginHistoryHeader" align="left" >Group/Company</td>
	<td class="loginHistoryHeader" align="left" >Timestamp</td>
	<td class="loginHistoryHeader" align="left" >Action</td>
</tr>


<webwork:iterator value="loginHistory" status="mestatus">

<tr>
	<td class="loginHistoryResult" align="left"><webwork:property value="username" />&nbsp;</td>
	<td class="loginHistoryResult" align="left"><webwork:property value="userGroup" />&nbsp;</td>

	<td class="loginHistoryResult" align="left">
	
		<webwork:text name="'date.format'">
			<webwork:param value="timestamp"/>
		</webwork:text>

	&nbsp;
	</td>
	<td class="loginHistoryResult" align="left"><webwork:property value="type" />&nbsp;</td>
</tr>
	

</webwork:iterator>



</table>




</body>
</html>