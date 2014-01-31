<%@ taglib uri="webwork" prefix="webwork" %>


<webwork:if test="!#currentParam.filterParameter.field.numeric">
<tr>
 <td style="font-size: 9px;">AND (Records with <b>all</b> terms)</td>
</tr>
<tr>
 <td>
  <webwork:textfield  theme="'simple'"
	     			  cssClass="'filterFieldsLike'"
	   				  name="#currentParam.andName" 
					  value="#currentParam.andValues" />
  </td>
</tr>
<tr>
 <td style="font-size: 9px;">OR (Records with <b>any</b> term)</td>
</tr>
<tr>
 <td>
  <webwork:textfield  theme="'simple'"
					 cssClass="'filterFieldsLike'"
					 name="#currentParam.orName" 
					 value="#currentParam.orValues" />
 </td>
</tr>
<tr>
 <td style="font-size: 9px;">NOT (Records <b>without</b> terms)</td>
</tr


>
<tr>
 <td>
  <webwork:textfield  theme="'simple'"
	 				 cssClass="'filterFieldsLike'"
	 				 name="#currentParam.notName" 
					 value="#currentParam.notValues" />
 </td>
</tr>

</webwork:if>

<webwork:if test="#currentParam.filterParameter.field.ognlName != 'yearPutInDatabaseSameStore'">
<tr>
	<td style="font-size: 9px;" width="192px">
	<b>Not on Menu</b><webwork:checkbox theme="'simple'" fieldValue="'true'" name="#currentParam.emptyName" value="#currentParam.empty"/>
	<b>On Menu</b><webwork:checkbox theme="'simple'" fieldValue="'true'" name="#currentParam.notEmptyName" value="#currentParam.notEmpty"/>
	</td>
</tr>
</webwork:if>
<webwork:else>
<tr>
	<td style="font-size: 9px;" width="192px">

				<p><webwork:select theme="'simple'"
					cssClass="'filterFieldsPrimary'"
					name="'mp.yearPutInDatabase.andValues'"
					value="mp.yearPutInDatabase.andValues" 
					list="#{
						'1996':'1996-2005',
						'1997':'1997-2005',
						'1998':'1998-2005',
						'1999':'1999-2005',
						'2000':'2000-2005',
						'2001':'2001-2005',
						'2002':'2002-2005',
						'2003':'2003-2005',
						'2004':'2004-2005',
						'2005':'2005-2006',
						'2006':'2006-2007',
						'2007':'2007-2008',
						'2008':'2008-2009',
						'2009':'2009-2010',
						'2010':'2010-2011',						
						}"
					multiple="'false'" 
					emptyOption="'true'"
				/>

	</td>
</tr>
</webwork:else>


<webwork:if test="!#currentParam.filterParameter.field.numeric">
<tr>
 <td class="smallFont" style="border-bottom:3px solid gray;"><a href="#nowhere" onclick="javascript:clearField('<webwork:property value="#currentParam.andName"/>','<webwork:property value="#currentParam.orName"/>','<webwork:property value="#currentParam.notName"/>','<webwork:property value="#currentParam.inName"/>','<webwork:property value="#currentParam.baseName"/>');">Clear Filter</a></td>
</tr>
</webwork:if>
				
	