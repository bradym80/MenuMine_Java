/*
 * Created on Jan 20, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood.hql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;

public class MasterFoodQueryBuilderTest extends TestCase {

    private static Log log = LogFactory.getLog(MasterFoodQueryBuilder.class);

    private StringBuffer statement;

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {

        super.setUp();
        statement = new StringBuffer();
    }

    public void testSimpleAnd() throws Exception {

        FieldEnum ing = FieldEnum.DESCRIPTION;

        FilterParameter fp = new FilterParameter();
        fp.setFieldName(ing.getOgnlName());
        Collection c = new ArrayList();
        c.add("ONE");
        fp.setAndValues(c);

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        builder.decorateForAnd(statement, fp);
        log.info(statement);
        assertEquals("(" + MasterFoodQueryBuilder.HQL_INSTANCE_NAME + "."
                + ing.getOgnlName() + " like '%ONE%')", statement.toString());

    }

    public void testTwoPartAnd() throws Exception {

        FieldEnum ing = FieldEnum.DESCRIPTION;

        FilterParameter fp = new FilterParameter();
        fp.setFieldName(ing.getOgnlName());
        Collection c = new ArrayList();
        c.add("ONE");
        c.add("TWO");
        fp.setAndValues(c);

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        builder.decorateForAnd(statement, fp);
        log.info(statement);
        assertEquals("(" + MasterFoodQueryBuilder.HQL_INSTANCE_NAME + "."
                + ing.getOgnlName() + " like '%ONE%' and "
                + MasterFoodQueryBuilder.HQL_INSTANCE_NAME + "."
                + ing.getOgnlName() + " like '%TWO%')", statement.toString());

    }

    public void testOr() throws Exception {

        FieldEnum ing = FieldEnum.DESCRIPTION;

        FilterParameter fp = new FilterParameter();
        fp.setFieldName(ing.getOgnlName());
        Collection c = new ArrayList();
        c.add("ONE");
        c.add("TWO");
        fp.setOrValues(c);

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        builder.decorateForOr(statement, fp);
        log.info(statement.toString());
        assertEquals("(" + MasterFoodQueryBuilder.HQL_INSTANCE_NAME + "."
                + ing.getOgnlName() + " like '%ONE%' or "
                + MasterFoodQueryBuilder.HQL_INSTANCE_NAME + "."
                + ing.getOgnlName() + " like '%TWO%')", statement.toString());

    }

    public void testIn() throws Exception {

        FieldEnum ing = FieldEnum.DESCRIPTION;

        FilterParameter fp = new FilterParameter();
        fp.setFieldName(ing.getOgnlName());
        Collection c = new ArrayList();
        c.add("ONE");
        c.add("TWO");
        fp.setInValues(c);

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        builder.decorateForIn(statement, fp);
        log.info(statement.toString());
        assertEquals("(" + MasterFoodQueryBuilder.HQL_INSTANCE_NAME + "."
                + ing.getOgnlName() + " IN ( 'ONE', 'TWO'))", statement
                .toString());

    }

    public void testWithFilterParams() throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        Collection and = new ArrayList();
        and.add("one");
        and.add("two");

        p.getBasicProtein().setAndValues(and);
        p.getBrand().setAndValues(and);

        StringBuffer ret = new MasterFoodQueryBuilder().getConjunctiveStatement(p);

        log.info(ret.toString());
    }

    public void testExcluding() throws Exception {

        FieldEnum ing = FieldEnum.DESCRIPTION;

        FilterParameter fp = new FilterParameter();
        fp.setFieldName(ing.getOgnlName());
        Collection c = new ArrayList();
        c.add("ONE");
        c.add("TWO");
        fp.setNotValues(c);

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        builder.decorateForNot(statement, fp);
        log.info(statement.toString());
        assertEquals("(" + MasterFoodQueryBuilder.HQL_INSTANCE_NAME + "."
                + ing.getOgnlName() + " not like '%ONE%' and "
                + MasterFoodQueryBuilder.HQL_INSTANCE_NAME + "."
                + ing.getOgnlName() + " not like '%TWO%')", statement
                .toString());

    }
    
    public void testEmpty() throws Exception {
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        Collection and = new ArrayList();
        and.add("one");
        and.add("two");

        p.getBasicProtein().setAndValues(and);
        
        p.getBrand().setEmpty(Boolean.FALSE);

        StringBuffer ret = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);

        log.info(ret.toString());
        
        assertTrue(ret.indexOf("IS NOT NULL") > -1);
    }

    public void testWholeClause() throws Exception {

        FieldEnum ing = FieldEnum.DESCRIPTION;

        FilterParameter fp = new FilterParameter();
        fp.setFieldName(ing.getOgnlName());
        Collection ands = new ArrayList();
        ands.add("ONE");
        ands.add("TWO");
        fp.setAndValues(ands);

        Collection ors = new ArrayList();
        ors.add("THREE");
        ors.add("FOUR");
        fp.setOrValues(ors);

        Collection nots = new ArrayList();
        nots.add("FIVE");
        nots.add("SIX");
        fp.setNotValues(nots);

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        StringBuffer ret = builder.getStatement(fp);
        log.info(ret.toString());

    }

    public void testWholeClausePartTwo() throws Exception {

        FieldEnum ing = FieldEnum.DESCRIPTION;

        FilterParameter fp = new FilterParameter();
        fp.setFieldName(ing.getOgnlName());
        Collection ands = new ArrayList();
        ands.add("ONE");
        ands.add("TWO");
        fp.setAndValues(ands);

        Collection nots = new ArrayList();
        nots.add("FIVE");
        nots.add("SIX");
        fp.setNotValues(nots);

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        StringBuffer ret = builder.getStatement(fp);
        log.info(ret.toString());

    }

    public void testQueryGenerate() throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        Collection and = new ArrayList();
        and.add("one");
        and.add("two");

        p.getBasicProtein().setAndValues(and);

        StringBuffer ret = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);

        log.info(ret.toString());
    }

    public void testSelectWithGenMenuPart() throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        Collection a = p.getAll();

        boolean found = false;
        int count = 0;

        for (Iterator iter = a.iterator(); iter.hasNext();) {
            FilterParameter element = (FilterParameter) iter.next();

            if (element.getFieldName()
                    .equals(FieldEnum.MENU_PART.getOgnlName())) {

                count++;
            }
        }

        log.info("count is " + count);

        assertNotNull(a);

        /*
         * 2006-01-22 RSC This is "4" because there are that number of FieldEnums.
         */
        assertEquals(4, count);
    }
    

    
    public void testSelectWithOrder() throws Exception {
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.getBasicProtein().setSelect(true);
        p.getBrand().setSelect(true);
        
        StringBuffer r1 = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        assertTrue(r1.indexOf("ORDER BY") < 0);
        
        p.setOrderBy(p.getBasicProtein().getFieldName());
        
        StringBuffer r2 = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(p);
        
        assertTrue(r2.indexOf("ORDER BY ") > 0);
    }
}
