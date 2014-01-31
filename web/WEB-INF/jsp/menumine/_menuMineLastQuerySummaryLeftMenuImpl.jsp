<%@ taglib uri="webwork" prefix="webwork" %>

<table cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td><h2>Search Summary</h2></td>
	</tr>
	
<webwork:if test= "lastQuerySummary.size() > 0" >
  <webwork:iterator value="lastQuerySummary" status="mestatus">
  	<tr>
		<td class="smallFont" style="white-space: nowrap; background-color: #CCCCCC;" align="left" valign="top">
        	<b><webwork:property value="field.friendlyName"/></b>
        </td>
	</tr>
	<tr>
		<td>
			<table cellpadding="0" cellspacing="0" width="100%">
            	<tr>
					<td width="100%" class="panelsAz">
                		<b>AND: </b>
                        <webwork:iterator value="selection" status="mestatus">
                          <webwork:property value="top"/>
                          <webwork:if test="!#mestatus.last">, </webwork:if>
                        </webwork:iterator>
                        <webwork:iterator value="typeIn" status="mestatus">
                          <webwork:property value="top"/>
                          <webwork:if test="!#mestatus.last">, </webwork:if>
                        </webwork:iterator>
                        <webwork:if test= "selection.size()== 0  && typeIn.size()== 0" > N/A </webwork:if>
                    </td>
                </tr>
                <tr>
					<td width="100%" class="panelsAz">
                		<b>OR: </b>
                        <webwork:iterator value="orValues" status="mestatus">
                          <webwork:property value="top"/>
                          <webwork:if test="!#mestatus.last">, </webwork:if>
                        </webwork:iterator>
                        <webwork:if test= "orValues.size()== 0" > N/A </webwork:if>
                    </td>
                </tr>
                <tr>
					<td width="100%" class="panelsAz">
                		<b>NOT: </b>
                        <webwork:iterator value="notValues" status="mestatus">
                          <webwork:property value="top"/>
                          <webwork:if test="!#mestatus.last">, </webwork:if>
                        </webwork:iterator>
                        <webwork:if test= "notValues.size()== 0" > N/A </webwork:if>
                    </td>
                </tr>
                <tr>
					<td width="100%" class="panelsAz">
                		<b>Not On Menu: </b>
                        <webwork:if test= "empty==null" > N/A </webwork:if>
                        <webwork:else>
                          <webwork:property value="empty"/>
                        </webwork:else>
                    </td>
                </tr>
			</table>
        </td>
    </tr>
  </webwork:iterator>
</webwork:if>
</table>
