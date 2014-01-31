<%@ taglib uri="webwork" prefix="webwork" %>
<html>
<head></head>
<body>

<webwork:include page="_adminHeaderMenu.jsp"/> 

<h2>Administration</h2>



<p><a href="<webwork:url value="'/userList.action'" >
			</webwork:url>">Users</a>


<p><a href="<webwork:url value="'/userGroupList.action'" >
			</webwork:url>">Groups</a>
			
<p><a href="<webwork:url value="'/loginHistoryList.action'" >
			</webwork:url>">Login History</a>
			
			

</body>
</html>
