/*
 * Created on Mar 30, 2006 by Reid
 */
package com.fsrin.menumine.produtil;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import ognl.Ognl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.dao.GenericDAO;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/*
 * 2006-07-28
 * 
 * if you've just converted a new database, make sure you have
 * a) a primary key on tblmasterfood id.
 * alter table tblmasterfood add primary key (id)
 * b) a fulltext index on tblmasterfood keywords
 * create fulltext index on tblmasterfood (keywords)
 * c) table engine should be myisam
 * alter table tblmasterfood engine myisam
 */
public class KeywordBuilderCommand {

    private Log log = LogFactory.getLog(KeywordBuilderCommand.class);

    public void execute() throws Exception {

        /*
         * start by setting the field to null;
         */
        GenericDAO dao = GenericDAOFactory.factory.buildData();

        /*
         * essentially the goal is to get the unique words from a record and
         * create a keyword entry.
         */
        String setToNull = "UPDATE " + MasterFood.class.getName() + " SET "
                + FieldEnum.KEYWORDS.getOgnlName() + " = NULL";

        int nulled = dao.execute(setToNull);
        log.info("records set to null " + nulled);

        /*
         * 
         */
        String selectWhereNull = "SELECT m FROM " + MasterFood.class.getName()
                + " as m WHERE keywords IS NULL";

        String updateKeywords = "UPDATE " + MasterFood.class.getName()
                + " SET keywords = :keywords WHERE id = :id";
        
        int hundredCount = 0;
        while (true) {
            Collection c = dao.find(selectWhereNull, 100);

            if (c == null || c.size() == 0) {
                break;
            }
            hundredCount++;
            log.info("hundredCount " + hundredCount);
            
            for (Iterator iter = c.iterator(); iter.hasNext();) {
                MasterFood element = (MasterFood) iter.next();

                Collection currentUniqueTerms = new TreeSet();

                for (Iterator iterator = FieldEnum.getAll().iterator(); iterator
                        .hasNext();) {
                    FieldEnum currentField = (FieldEnum) iterator.next();

                    Object o = Ognl.getValue(currentField.getOgnlName(),
                            element);

                    if (o != null) {

                        if (o instanceof String) {
                            String[] strings = ((String) o).split("\\W");
                            for (int i = 0; i < strings.length; i++) {
                                String cString = strings[i].toLowerCase()
                                        .trim();

                                if (!isExcluded(cString)) {
                                    currentUniqueTerms.add(cString);
                                }
                            }
                        }
                    }

                }

                StringBuffer keywords = new StringBuffer();
                for (Iterator iterator = currentUniqueTerms.iterator(); iterator
                        .hasNext();) {
                    String element2 = (String) iterator.next();
                    keywords.append(element2);
                    keywords.append(" ");
                }
                //log.info("keywords: " + keywords.toString());
                element.setKeywords(keywords.toString());

                dao.execute(updateKeywords, element);

            }

        }

    }

    public boolean isExcluded(String string) {
        boolean ret = false;

        ret = string.length() < 3;

        String[] misc = { "accomp", "after", "all", "and", "alone", "ben", "bev",
                "bice", "bob", "bobby", "centennial", "center",
                "central", "char", "com", "come", "day", "district", "don",
                "entr", "epice", "fillling", "flordia", "held",
                "home", "honeyw", "includes", "into", "mackenzie", "made",
                "midi", "not", "one", "other", "perfection",
                "plate", "resides", "santa", "saucelll", "sce", "since",
                "splsh", "that", "the", "then", "this", "together",
                "two", "with", "wth" };

        if (!ret) {
            for (int i = 0; i < misc.length; i++) {
                if (string.equals(misc[i])) {
                    ret = true;
                    break;
                }
            }
        }

        return ret;
    }
    
    static public void main(String[] argc)
    {	
    	KeywordBuilderCommand  cmd = new KeywordBuilderCommand ();
    	
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
