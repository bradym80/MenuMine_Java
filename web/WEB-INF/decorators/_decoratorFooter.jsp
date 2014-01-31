
<%@ page import="com.fsrin.menumine.common.util.FileIOUtility" %>
<%@ page import="com.fsrin.menumine.common.util.CalanderUtility" %>

<%
int year = CalanderUtility.getCurrentYear();
String date = FileIOUtility.getDBUpdateDate();
%>


<script>
	var d = document.getElementById("loginSpace");
	
	if(d != null)
	{
		d.innerHTML = "\
						<div class='style1'>\
						<p>\
							MenuMine Copyright &copy; <%= year %> Foodservice Research Institute\
							<br>\
							Database Updated <%=date%>\
							</p>\
						</div>";
	}
	else
	{
		document.write("\
						<div id='footer'>\
						<p>\
							MenuMine Copyright &copy; <%= year %> Foodservice Research Institute\
							<br>\
							Database Updated <%=date%>\
							</p>\
						</div>");
	}
</script>

<%--
<br />

Profile: 

--%>
<%-- mbrady 02_19_08 --%>
<%--	out.println(session.getId() + " <br/>"); 

	Runtime run = Runtime.getRuntime();
	out.println("Free m: " + ((run.freeMemory()/1024)/1024));
	out.println("Total m: " + ((run.totalMemory()/1024)/1024));
	out.println("Max m: " + ((run.maxMemory()/1024)/1024));


--%>


<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-6401171-2");
pageTracker._trackPageview();
} catch(err) {}</script>
</body>
</html>