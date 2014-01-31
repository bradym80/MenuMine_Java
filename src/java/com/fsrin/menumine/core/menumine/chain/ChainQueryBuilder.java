/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.chain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.FieldEnum;

public class ChainQueryBuilder {

    private static Log log = LogFactory.getLog(ChainQueryBuilder.class);

    public static String HQL_INSTANCE_NAME = "c";

    public static String HQL_TABLE_NAME = Chain.class.getName();

    
    public StringBuffer buildCountsBySegmentQuery() {
        
        StringBuffer ret = new StringBuffer();
        
        ret.append("select ");
        
        ret.append(getFieldName(FieldEnum.MARKET_SECTOR.getOgnlName()) + ",");
        ret.append(getFieldName(FieldEnum.MARKET_SEGMENT.getOgnlName()) + ", ");
        ret.append(" count(" + getFieldName("id") + ") ");
        
        ret.append(" from " + HQL_TABLE_NAME + " as " + HQL_INSTANCE_NAME);
        
        ret.append(" group by " + getFieldName(FieldEnum.MARKET_SECTOR.getOgnlName()) + ", ");
        ret.append(getFieldName(FieldEnum.MARKET_SEGMENT.getOgnlName()) + " ");
        
        
        return ret;
        
    }
    
    public StringBuffer buildCountsBySegmentQuery(Integer firstYearInDatabase) {
        
        StringBuffer ret = new StringBuffer();
        
        ret.append("select ");
        
        ret.append(getFieldName(FieldEnum.MARKET_SECTOR.getOgnlName()) + ",");
        ret.append(getFieldName(FieldEnum.MARKET_SEGMENT.getOgnlName()) + ", ");
        ret.append(" count(" + getFieldName("id") + ") ");
        
        ret.append(" from " + HQL_TABLE_NAME + " as " + HQL_INSTANCE_NAME);
        
        ret.append(" where ");
        
        ret.append(HQL_INSTANCE_NAME + "."
                + FieldEnum.YEAR_PUT_IN_DATABASE.getOgnlName() + " <= "
                + firstYearInDatabase);
        
        ret.append(" group by " + getFieldName(FieldEnum.MARKET_SECTOR.getOgnlName()) + ", ");
        ret.append(getFieldName(FieldEnum.MARKET_SEGMENT.getOgnlName()) + " ");
        
        
        return ret;
        
    }
    
    public String getFieldName(String field) {
        return HQL_INSTANCE_NAME + "." + field;
    }
}
