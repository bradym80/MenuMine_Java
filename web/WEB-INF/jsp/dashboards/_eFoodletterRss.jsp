<%@ taglib uri="webwork" prefix="webwork" %>


	<webwork:action name="'efoodletterRss'" id="efoodletterRss">
	</webwork:action>

<webwork:if test="#efoodletterRss.rssAvailable">


<table border="0">         
    
	<webwork:iterator value="#efoodletterRss.rssEntries" status="mestatus">
	<tr>
	<td><a href="<webwork:property value="link"/>" ><webwork:property value="title"/></a>
			
	</td>
	</tr>
	</webwork:iterator>
</table>
	   
	 
</webwork:if>

