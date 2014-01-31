/*
 * Created on Aug 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;


/**
 * 2006-02-08 RSC Temp removed.  Uncomment and extend TestCase to use again.
 * @author Nick
 * 
 *  
 */
public class MenuMineExpressQueryBuilderTest_Legacy  {

//    public MenuMineExpressQueryBuilderTest() {
//        super();
//
//    }
//
//    /*
//     * Test with no comma
//     */
//    public void testExpressBuilderTokenizer1() {
//        ExpressQueryBuilder builder = new MenuMineExpressQueryBuilderStandardImpl(
//                new AuthorizationBeanMockImpl());
//
//        builder
//                .setMasterFoodServiceDelegate(new MasterFoodServiceDelegateMockImpl());
//
//        builder.setExpressSearchQuery("Chicken Curry");
//
//        builder.processQuery();
//
//        Collection tokens = builder.getExpressQuery()
//                .getMasterFoodFilterParameters().getItemDescription()
//                .getAndValues();
//
//        assertEquals(2, tokens.size());
//    }
//
//    /*
//     * Test with comma
//     */
//    public void testExpressBuilderTokenizer2() {
//        ExpressQueryBuilder builder = new MenuMineExpressQueryBuilderStandardImpl(
//                new AuthorizationBeanMockImpl());
//
//        builder
//                .setMasterFoodServiceDelegate(new MasterFoodServiceDelegateMockImpl());
//
//        builder.setExpressSearchQuery("Chicken, Curry");
//
//        builder.processQuery();
//
//        Collection tokens = builder.getExpressQuery()
//                .getMasterFoodFilterParameters().getItemDescription()
//                .getAndValues();
//
//        assertEquals(2, tokens.size());
//    }
//
//    /*
//     * Test with garbage charaters
//     */
//    public void testExpressBuilderTokenizer3() {
//        ExpressQueryBuilder builder = new MenuMineExpressQueryBuilderStandardImpl(
//                new AuthorizationBeanMockImpl());
//
//        builder
//                .setMasterFoodServiceDelegate(new MasterFoodServiceDelegateMockImpl());
//
//        builder.setExpressSearchQuery("Chicken, Curry , \" : ,,,	BBQ");
//
//        builder.processQuery();
//
//        Collection tokens = builder.getExpressQuery()
//                .getMasterFoodFilterParameters().getItemDescription()
//                .getAndValues();
//
//        assertEquals(3, tokens.size());
//    }
//
//    public void testExpressBuilderFieldsToDisplayBuilder() {
//        ExpressQueryBuilder builder = new MenuMineExpressQueryBuilderStandardImpl(
//                new AuthorizationBeanMockImpl());
//
//        builder
//                .setMasterFoodServiceDelegate(new MasterFoodServiceDelegateMockExpressImpl());
//
//        builder.setExpressSearchQuery("Chicken, Curry , BBQ");
//
//        builder.processQuery();
//
//        FieldsToDisplayBean bean = builder.getMineOptionsFeelingLucky()
//                .getMineFieldsExpressQueryCounter()
//                .getProjectedFieldsToDisplay();
//        assertEquals(7, bean.countTotalSelected());
//
//    }
//
//    public void testExpressBuilderMineDetector() {
//        ExpressQueryBuilder builder = new MenuMineExpressQueryBuilderStandardImpl(
//                new AuthorizationBeanMockImpl());
//
//        builder
//                .setMasterFoodServiceDelegate(new MasterFoodServiceDelegateMockExpressImpl());
//
//        builder.setExpressSearchQuery("Chicken, Curry , BBQ");
//
//        builder.processQuery();
//
//        Collection mineOptions = builder.getMineOptions();
//
//        MineRank mineRank = builder.getMineOptionsFeelingLucky();
//
//        assertEquals(5, mineOptions.size());
//
//        assertEquals("ingredient.mine", mineRank
//                .getMineFieldsExpressQueryCounter().getTargetMine()
//                .getMineType());
//    }

}