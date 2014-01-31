<%@ taglib uri="webwork" prefix="webwork" %>

<table cellspacing="0" cellpadding="0" border="0"   align="center">
	<tr>
			
		<td valign="bottom"> 
			<a class="menuLink" href="<webwork:url value="postAction" >	
				<webwork:param name="'displayType'" value="'Applications'" />
				<webwork:param name="'searchString'" value="searchString" />
				</webwork:url>">
				
				<webwork:if test="displayType == 'Applications'"> 
					<img align="absbottom" border="0" src="img/tab-applications-active.gif">
				</webwork:if>	
				<webwork:else>
					 <img align="absbottom" border="0" src="img/tab-applications.gif">
				</webwork:else>
			</a>
		</td>
		<td valign="bottom"> 
			<a class="menuLink" href="<webwork:url value="postAction" >	
				<webwork:param name="'displayType'" value="'Operator Share'" />
				<webwork:param name="'searchString'" value="searchString" />
				</webwork:url>">
				
				<webwork:if test="displayType == 'Operator Share'"> 
					<img align="absbottom" border="0" src="img/tab-operatorshare-active.gif">
				</webwork:if>	
				<webwork:else>
					 <img align="absbottom" border="0" src="img/tab-operatorshare.gif">
				</webwork:else>
			</a>
		</td>
		<td valign="bottom"> 
			<a class="menuLink" href="<webwork:url value="postAction" >	
				<webwork:param name="'displayType'" value="'Segment Share'" />
				<webwork:param name="'searchString'" value="searchString" />
				</webwork:url>">
				
				<webwork:if test="displayType == 'Segment Share'"> 
					<img align="absbottom" border="0" src="img/tab-segmentshare-active.gif">
				</webwork:if>	
				<webwork:else>
					 <img align="absbottom" border="0" src="img/tab-segmentshare.gif">
				</webwork:else>
			</a>
		</td>			
		<td valign="bottom"> 
			<a class="menuLink" href="<webwork:url value="postAction" >	
				<webwork:param name="'displayType'" value="'Sector Share'" />
				<webwork:param name="'searchString'" value="searchString" />
				</webwork:url>">
				
				<webwork:if test="displayType == 'Sector Share'"> 
					<img align="absbottom" border="0" src="img/tab-sectorshare-active.gif">
				</webwork:if>	
				<webwork:else>
					 <img align="absbottom" border="0" src="img/tab-sectorshare.gif">
				</webwork:else>
			</a>
		</td>	
		<td valign="bottom"> 
			<a class="menuLink" href="<webwork:url value="postAction" >	
				<webwork:param name="'displayType'" value="'Application Chart'" />
				<webwork:param name="'searchString'" value="searchString" />
				</webwork:url>">
				
				<webwork:if test="displayType == 'Application Chart'"> 
					<img align="absbottom" border="0" src="img/tab-applicationschart-active.gif">
				</webwork:if>	
				<webwork:else>
					 <img align="absbottom" border="0" src="img/tab-applicationschart.gif">
				</webwork:else>
			</a>
		</td>			
		
	
		
		
	</tr>
		<tr bgcolor="black"><td colspan="5"></td></tr>
</table>