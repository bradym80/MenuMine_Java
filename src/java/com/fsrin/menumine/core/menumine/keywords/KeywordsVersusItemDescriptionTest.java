/*
 * Created on Mar 30, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.keywords;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.express.ParameterDecoratorFactory;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDao;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * keywords are designed to give us more information more quickly.
 * 
 * @author Reid
 */
public class KeywordsVersusItemDescriptionTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testOriginalAndNewWithBacon() throws Exception {
        
        String searchFor = "bacon";
        
        MasterFoodFilterParametersImpl original = new MasterFoodFilterParametersImpl();
        original.getBasicProtein().setSelect(true);
        
        new ParameterDecoratorFactory().buildExpressItemDescription(original).decorate(searchFor);
        
        assertTrue(original.getItemDescription().getAndValues().size() > 0);
        
        MasterFoodFilterParametersImpl keywords = new MasterFoodFilterParametersImpl();
        keywords.getBasicProtein().setSelect(true);
        
        new ParameterDecoratorFactory().buildExpressKeywords(keywords).decorate(searchFor);
        
        
        Collection originalResults = MasterFoodDao.factory.build().findUsingHQLConjunction(original);
        
        log.info("Original results size " + originalResults.size());
        
        Collection keywordsResults = MasterFoodDao.factory.build().findUsingHQLConjunction(keywords);
        
        log.info("Keywords results size " + keywordsResults.size());
        
        assertTrue(originalResults.size() < keywordsResults.size());
    }
    
    public void testOriginalAndNewWithChicken() throws Exception {
        
        String searchFor = "chicken";
        
        MasterFoodFilterParametersImpl original = new MasterFoodFilterParametersImpl();
        original.getBasicProtein().setSelect(true);
        
        new ParameterDecoratorFactory().buildExpressItemDescription(original).decorate(searchFor);
        
        assertTrue(original.getItemDescription().getAndValues().size() > 0);
        
        MasterFoodFilterParametersImpl keywords = new MasterFoodFilterParametersImpl();
        keywords.getBasicProtein().setSelect(true);
        
        new ParameterDecoratorFactory().buildExpressKeywords(keywords).decorate(searchFor);
        
        
        Collection originalResults = MasterFoodDao.factory.build().findUsingHQLConjunction(original);
        
        log.info("Original results size " + originalResults.size());
        
        Collection keywordsResults = MasterFoodDao.factory.build().findUsingHQLConjunction(keywords);
        
        log.info("Keywords results size " + keywordsResults.size());
        
        assertTrue(originalResults.size() < keywordsResults.size());
    }
    
    public void testOriginalAndNewWithSalmon() throws Exception {
        
        String searchFor = "salmon";
        
        MasterFoodFilterParametersImpl original = new MasterFoodFilterParametersImpl();
        original.getBasicProtein().setSelect(true);
        
        new ParameterDecoratorFactory().buildExpressItemDescription(original).decorate(searchFor);
        
        assertTrue(original.getItemDescription().getAndValues().size() > 0);
        
        MasterFoodFilterParametersImpl keywords = new MasterFoodFilterParametersImpl();
        keywords.getBasicProtein().setSelect(true);
        
        new ParameterDecoratorFactory().buildExpressKeywords(keywords).decorate(searchFor);
        
        
        Collection originalResults = MasterFoodDao.factory.build().findUsingHQLConjunction(original);
        
        log.info("Original results size " + originalResults.size());
        
        Collection keywordsResults = MasterFoodDao.factory.build().findUsingHQLConjunction(keywords);
        
        log.info("Keywords results size " + keywordsResults.size());
        
        assertTrue(originalResults.size() <= keywordsResults.size());
    }
}
