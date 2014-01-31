<%@ taglib uri="webwork" prefix="webwork" %>

	<webwork:action name="'chainStatMenuCam'" id="menuCam">
	</webwork:action>

<webwork:if test="#menuCam.menuCamAvailable">

	<h2> MenuCam </h2>
	
	<webwork:iterator value="#menuCam.files" status="mestatus">
		<webwork:if test="#mestatus.modulus(2) == 1">
			<br/>
		</webwork:if>
		
		<img src="<webwork:property/> ">
	</webwork:iterator>
	
</webwork:if>