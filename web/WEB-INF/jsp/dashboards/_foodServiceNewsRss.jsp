<%@ taglib uri="webwork" prefix="webwork" %>



	
     <marquee  scrollamount="2" direction="up" 
    
	<webwork:iterator value="foodServiceNews" status="mestatus">
		<p><a href="<webwork:property value="link"/>" ><webwork:property value="title"/></a>
			<webwork:property value="description.value"/>
	</webwork:iterator>
	   </marquee>
	   
