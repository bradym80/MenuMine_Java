/*
 * Created on Mar 30, 2006 by Reid
 */
package com.fsrin.menumine.produtil;

import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.fsrin.menumine.common.SpringBeanBroker;

/*
 * 2006-03-30
 * 
 */
public class UpdateDatabaseStructureCommand {

    public final String ADMIN = "&adminSessionFactory";

    public final String DATA = "&dataSessionFactory";

    public void execute() throws Exception {

        LocalSessionFactoryBean admin =  (LocalSessionFactoryBean) SpringBeanBroker
                .getBeanFactory().getBean(ADMIN); 
        admin.updateDatabaseSchema();

        LocalSessionFactoryBean data = (LocalSessionFactoryBean) SpringBeanBroker
        .getBeanFactory().getBean(DATA);
        data.updateDatabaseSchema();

        boolean t = false;

    }
    
    static public void main(String[] argc)
    {	
    	UpdateDatabaseStructureCommand cmd = new UpdateDatabaseStructureCommand();
    	
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
