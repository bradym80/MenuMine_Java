<%@ taglib uri="webwork" prefix="webwork" %>

<h3>Category Incidence Options</h3>
<webwork:form theme="'simple'"method="'post'" action="'menumineCategoryIncidence.action'" name="'menuMineCatIncidence'">
<table>
	<tr>	
		<td >Title:</td>		
		<td >Collapse Sector Detail:</td>
		<td >Year:</td>
	</tr>
	<tr>
		<td>
	   		<webwork:textfield  theme="'simple'"	
	   			name="'menuMineDisplayOptions.title'" 
			    value="menuMineDisplayOptions.title" />
	 	</td>	
		<td >
 			<webwork:checkbox  theme="'simple'" name="'rollUp'" value="rollUp" fieldValue="'true'"/>
		</td>
		<td>
		<webwork:select theme="'simple'"
			name="'targetYear'"
			value="targetYearString" 
			list="#{
				'2011':'2011',
				'2010':'2010',
				'2009':'2009',
			    '2008':'2008',
			    '2007':'2007',
				'2006':'2006',
				'2005':'2005',
				'2004':'2004',
				'2003':'2003',
				'2002':'2002',
				'2001':'2001',
				'2000':'2000',
				'1999':'1999',
				'1998':'1998',
				'1997':'1997',
				'1996':'1996'
			}" 
			multiple="'false'" 
			emptyOption="'false'" />
		</td>		
	</tr>
	<tr>	
		
		<td ><webwork:submit theme="'simple'" name="'submitOptions'" value="'Display Category Incidence'" />	</td>
		<td  ></td>
		<td ><webwork:submit  theme="'simple'" name="'submitOptions'" value="'View Sector Graph'" />	</td>
	</tr>
</table>
</webwork:form>