/*
 * Created on Mar 10, 2006 by Reid
 */
package com.fsrin.menumine.produtil;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDao;

/**
 * 2006-03-10 The data coming from FSRIN via Access has empty value expressed as 
 * something other than null.  To simplify this db, we're going to set all
 * empty values to null.
 * 
 * 
 * @author Reid
 */
public class DataEmptyToNullConverterCommand {

    private Log log = LogFactory.getLog(DataEmptyToNullConverterCommand.class);
    
    public void execute() throws Exception {
        
        Collection allFields = FieldEnum.getAll();
   
        MasterFoodDao dao = MasterFoodDao.factory.build();
        
        for (Iterator iter = allFields.iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
        
            String name = element.getOgnlName().toLowerCase();
            
            String regularName = element.getOgnlName();
            
            String update = "UPDATE " + MasterFood.class.getName() + " SET " + regularName 
                + " = null WHERE ";
            
            if (name.indexOf("price") > -1) {
                update += regularName + " = 0.0";
            } else if (name.indexOf("year") > -1) {
                update += regularName + " = 0";
            } else {
                update += " trim(" + regularName + ") = ''";
            }
            
            int t = dao.execute(update);
            
            log.info("Field " + name + " (" + t + ")");
        }
        
        
    }
    
    static public void main(String[] argc)
    {	
    	DataEmptyToNullConverterCommand cmd = new DataEmptyToNullConverterCommand();
    	
    	try{
    		cmd.execute();	
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	} 
    	
    	System.exit(0);
    }
    
}
