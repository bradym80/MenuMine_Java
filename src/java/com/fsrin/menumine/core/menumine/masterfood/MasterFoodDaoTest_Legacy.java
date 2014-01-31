/*
 * Created on Jun 7, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;


/**
 * 
 * 2006-02-08 Doesn't test anything meaningful.
 * @author Nick
 * 
 *  
 */
public class MasterFoodDaoTest_Legacy  {

//    public MasterFoodDaoTest() {
//        super();
//
//    }
//
//    public MasterFoodDaoTest(String arg0) {
//        super(arg0);
//
//    }

    private MasterFoodDao getDao() {
        return MasterFoodDao.factory.build();
    }

    /*
     * 2006-02-08 RSC 
     * 
     * Appears to have been added by Nick Heudecker.  Not 
     * using, so removing.
     */
//    public void testFindByKeywords() throws Exception {
//        MasterFoodDao dao = this.getDao();
//        MasterFoodKeywordFilterParameters params = new MasterFoodKeywordFilterParametersImpl();
//        FilterParameter param = new FilterParameter();
//        param.setFieldName("keywords");
//        param.setAndValues(Arrays.asList(new String[] {"bacon"}));
//        params.setFilterParameter(param);
//
//        dao.find(params);
//    }

    /*
     * 2006-02-08 Removed since we don't save.
     * 
     */
//    public void testDessertMineFields() throws Exception {
//        MasterFood mf = new MasterFood();
//        mf.setCakeIngredient("CakeIngredient");
//        mf.setCakeUse("CakeUse");
//        mf.setCandyIngredient("CandyIngredient");
//        mf.setCookieIngredient("cookieIngredient");
//        mf.setCookieUse("CookieUse");
//        mf.setDayPartCategory("DayPartCategory");
//
//        mf.setDessertDoughCrustIngred("dessertDoughCrustIngred");
//        mf.setIceCreamIngredient("iceCreamIngredient");
//        mf.setSyrupTopping("syrupTopping");
//        mf.setNutIngredient("nutIngredient");
//
//        mf.setFruitorFruitFillingIngred("fruitorFruitFillingIngred");
//        mf.setWhippedToppingIngred("whippedToppingIngred");
//
//        mf.setPrimaryFlavor("primaryFlavor");
//        mf.setTasteFlavorWords("tasteFlavorWords");
//        mf.setBrand("brand");
//
//        this.getDao().save(mf);
//
//        MasterFood reload = this.getDao().get(mf.getId());
//
//        assertNotNull(reload);
//        
//        this.getDao().delete(mf);
//
//    }

//    protected void setUp() throws Exception {
//        super.setUp();
//        JunitSettings.initilizeTestSystemDropSchema();
//
//    }

}