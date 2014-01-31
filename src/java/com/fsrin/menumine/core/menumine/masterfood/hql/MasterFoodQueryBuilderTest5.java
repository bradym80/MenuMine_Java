/*
 * Created on Feb 2, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.masterfood.hql;

import java.util.Collection;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.dao.GenericDAOFactory;

public class MasterFoodQueryBuilderTest5 extends TestCase {

    private static Log log = LogFactory.getLog(MasterFoodQueryBuilderTest5.class);
    
    public void testBasicRegex() throws Exception {
        
        String sample1 = "Me 'n' eds";
        
        String r1 = new MasterFoodQueryBuilder().getEscaped(sample1);
        
        assertEquals("Me ''n'' eds",r1);
    
        log.info(r1);
    }
    
    public void testEscapedString() throws Exception {
        
        String q = "select m.basicProtein , m.operationName  " +
                "from com.fsrin.menumine.core.menumine.masterfood.MasterFood as m where " +
                "((m.operationName IN ( 'Jasons Deli', 'Cosi', 'Great Wraps', 'Me ''N'' Eds Pizzaria'))) " +
                "and ((m.itemDescription like '%bacon%'))";
        
        Collection c = GenericDAOFactory.factory.buildData().find(q);
        
    }
    
    public void testEscapedStringPart2() throws Exception {
        
        String q = "select m.basicProtein , m.operationName  from com.fsrin.menumine.core.menumine.masterfood.MasterFood as m where ((m.operationName IN ( 'Chuck E. Cheeses Pizza', 'Aurelios Pizza', 'Chuck E. Cheeses Pizza', 'East of Chicago Pizza Co.', 'Edwardos Pizza', 'Figaros Pizza', 'Foxs Pizza Den', 'Ginos East Pizza', 'Giordanos Pizza', 'Giovannis Pizza', 'Godfathers Pizza', 'Greeks Pizzeria', 'Happy Joes Pizza', 'Home Run Inn', 'Izzys', 'Ledo Pizza', 'Leonas', 'Lou Malnatis Pizza', 'Me ''N'' Eds Pizzeria', 'Mellow Mushroom Pizza', 'Monicals Pizza', 'Mountain Mikes Pizza', 'Pietros Pizza', 'Pizza Hut', 'Pizza Hut (UK)', 'Pizza Ranch', 'Pronto Roma', 'Rocky Rococos Pizza', 'Rosatis Pizza', 'Round Table Pizza', 'Shakeys', 'Simple Simons Pizza', 'Valentinos', 'Villa Pizza'))) and ((m.itemDescription like '%basil%')) and ((m.hqRegion not like '%UK%')) and ((m.dayPartCategory not like '%Dessert%' and m.dayPartCategory not like '%Beverage%'))"; 

        Collection c = GenericDAOFactory.factory.buildData().find(q);

    }
}
