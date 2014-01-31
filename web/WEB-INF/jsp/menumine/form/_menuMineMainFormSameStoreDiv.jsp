<%@ taglib uri="webwork" prefix="webwork" %>
<table>
	<tr>
		<td style="font-size: 9px;">Select period for Same Store</td>
	</tr>
	<tr>
		<td><!-- MJB 11-16-09 added 2009 -->
				<webwork:select theme="'simple'"
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
						'2010':'2010-2011'
						}" 
					multiple="'false'" 
					emptyOption="'true'"
				/>
			</td>
		</tr>
</table>