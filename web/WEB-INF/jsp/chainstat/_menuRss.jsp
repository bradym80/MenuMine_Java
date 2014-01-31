<%@ taglib uri="webwork" prefix="webwork" %>

	<webwork:action name="'chainStatRss'" id="menuRss">
	</webwork:action>

<webwork:if test="#menuRss.rssAvailable">

	<h2><webwork:property value="link"/><webwork:property value="chainStat.chain" />  News </h2>
	
	
          <marquee  scrollamount="2" direction="up" 
    
	<webwork:iterator value="#menuRss.rssEntries" status="mestatus">
		<p><a href="<webwork:property value="link"/>" ><webwork:property value="title"/></a>
			<webwork:property value="description.value"/>
	</webwork:iterator>
	   </marquee>
	   
	 
</webwork:if>

