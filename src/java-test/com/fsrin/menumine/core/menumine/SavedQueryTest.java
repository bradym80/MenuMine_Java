/*
 * Created on Apr 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import com.fsrin.menumine.testutil.JunitSettings;

/**
 * @author Nick
 * 
 *  
 */
public class SavedQueryTest extends TestCase {

    public SavedQueryTest() {
        super();

    }

    protected void setUp() throws Exception {
        super.setUp();
        JunitSettings.initilizeTestSystemDropSchema();

    }

    public void testSavesQuery() throws Exception {

        SavedQueryServiceDelegate savedQueryServiceDelegate = SavedQueryServiceDelegate.factory
                .build();

        /*
         * 2006-01-13 Appl Context now has to have some listable bean factory blah blah blah.
         */
//        ((ApplicationContextAware) savedQueryServiceDelegate)
//                .setApplicationContext(new ApplicationContext() {
//                    public ApplicationContext getParent() {
//
//                        return null;
//                    }
//
//                    public String getDisplayName() {
//
//                        return null;
//                    }
//
//                    public long getStartupDate() {
//
//                        return 0;
//                    }
//
//                    public void publishEvent(ApplicationEvent arg0) {
//                    }
//
//                    public boolean containsBeanDefinition(String arg0) {
//
//                        return false;
//                    }
//
//                    public int getBeanDefinitionCount() {
//
//                        return 0;
//                    }
//
//                    public String[] getBeanDefinitionNames() {
//
//                        return null;
//                    }
//
//                    public String[] getBeanDefinitionNames(Class arg0) {
//
//                        return null;
//                    }
//
//                    public String[] getBeanNamesForType(Class arg0) {
//
//                        return null;
//                    }
//
//                    public Map getBeansOfType(Class arg0) throws BeansException {
//
//                        return null;
//                    }
//
//                    public Map getBeansOfType(Class arg0, boolean arg1,
//                            boolean arg2) throws BeansException {
//
//                        return null;
//                    }
//
//                    public BeanFactory getParentBeanFactory() {
//
//                        return null;
//                    }
//
//                    public String getMessage(String arg0, Object[] arg1,
//                            String arg2, Locale arg3) {
//
//                        return null;
//                    }
//
//                    public String getMessage(String arg0, Object[] arg1,
//                            Locale arg2) throws NoSuchMessageException {
//
//                        return null;
//                    }
//
//                    public String getMessage(MessageSourceResolvable arg0,
//                            Locale arg1) throws NoSuchMessageException {
//
//                        return null;
//                    }
//
//                    public Resource[] getResources(String arg0)
//                            throws IOException {
//
//                        return null;
//                    }
//
//                    public Object getBean(String arg0) throws BeansException {
//
//                        return null;
//                    }
//
//                    public Object getBean(String arg0, Class arg1)
//                            throws BeansException {
//
//                        return null;
//                    }
//
//                    public boolean containsBean(String arg0) {
//
//                        return false;
//                    }
//
//                    public boolean isSingleton(String arg0)
//                            throws NoSuchBeanDefinitionException {
//
//                        return false;
//                    }
//
//                    public Class getType(String arg0)
//                            throws NoSuchBeanDefinitionException {
//
//                        return null;
//                    }
//
//                    public String[] getAliases(String arg0)
//                            throws NoSuchBeanDefinitionException {
//
//                        return null;
//                    }
//
//                    public Resource getResource(String arg0) {
//
//                        return null;
//                    }
//                });
        SavedQuery query = new SavedQuery();
        query.setGroupName("myGroup");
        query.setUserName("UserName");
        query.setName("Name");
        MasterFoodFilterParametersImpl mfParams = new MasterFoodFilterParametersImpl();
        mfParams.getBasicProtein().getInValues().add("Beef");
        mfParams.getCarboVegFruit().getOrValues().add("Bean");
        mfParams.getCarboVegFruit().getOrValues().add("Green");
        mfParams.getChain().getSegment().getAndValues().add("Seg");
        mfParams.getPrice1996().setEmpty(Boolean.TRUE);

        FieldsToDisplayBean toDisplay = new FieldsToDisplayBean();
        query.setMasterFoodFilterParameters(mfParams);
        query.setFieldsToDisplayBean(toDisplay);
        query.setPermission(1);

        savedQueryServiceDelegate.save(query);

        Collection col = savedQueryServiceDelegate.getByUser("UserName");
        assertTrue(col.size() > 0);

        for (Iterator iter = col.iterator(); iter.hasNext();) {
            SavedQuery element = (SavedQuery) iter.next();
            assertNotNull(element.getMasterFoodFilterParameters());
            assertNotNull(element.getMasterFoodFilterParameters()
                    .getBasicProtein());
            assertEquals(1, element.getMasterFoodFilterParameters()
                    .getBasicProtein().getInValues().size());
            assertEquals(2, element.getMasterFoodFilterParameters()
                    .getCarboVegFruit().getOrValues().size());
            assertContains("Beef", element.getMasterFoodFilterParameters()
                    .getBasicProtein().getInValues());
            assertContains("Bean", element.getMasterFoodFilterParameters()
                    .getCarboVegFruit().getOrValues());
            assertContains("Green", element.getMasterFoodFilterParameters()
                    .getCarboVegFruit().getOrValues());
            assertContains("Seg", element.getMasterFoodFilterParameters()
                    .getChain().getSegment().getAndValues());
            assertTrue(element.getMasterFoodFilterParameters().getPrice1996()
                    .getEmpty().booleanValue());

            savedQueryServiceDelegate.save(element);
        }
    }

    private void assertContains(String string, Collection inValues) {
        boolean contains = false;
        for (Iterator iter = inValues.iterator(); iter.hasNext();) {
            Object element = (Object) iter.next();
            contains = element.equals(string) || contains;

        }

        assertTrue(contains);
    }

}