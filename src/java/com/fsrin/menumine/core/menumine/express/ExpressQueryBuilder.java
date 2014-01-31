/*
 * Created on Jan 18, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.Collection;

import com.fsrin.menumine.authorization.AuthorizationBean;
import com.fsrin.menumine.core.menumine.masterfood.DistinctQueryBuilder;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper;

public interface ExpressQueryBuilder {

    public void processQuery();

    /*
     * Return the most likly mine, that the user is authorized to view. As the
     * auth bean can only be created by a trusted source we know it is valid.
     */
    public MineRank getMineOptionsFeelingLucky();

    public String getExpressSearchQuery();

    public void setExpressSearchQuery(String expressSearchQuery);

    public MasterFoodFilterParametersWrapper getExpressQuery();

    /*
     * This predicts a more refined search avoiding the description fields.
     * 
     * This will look at each term in the query and determine the most
     * appropriate field.
     * 
     * 
     */
    public MasterFoodFilterParametersWrapper getRefinedExpressQuery();

    public MasterFoodServiceDelegate getMasterFoodServiceDelegate();

    public void setMasterFoodServiceDelegate(
            MasterFoodServiceDelegate masterFoodServiceDelegate);

    public Collection getMineFieldsExpressQueryCounters();

    public Collection getMineOptions();

    public DistinctQueryBuilder getDistinctQueryBuilder();

    public void setDistinctQueryBuilder(
            DistinctQueryBuilder distinctQueryBuilder);

    public void setAuthorizationBean(AuthorizationBean authorizationBean);

    public String getMineTypeOverride();

    public void setMineTypeOverride(String mineTypeOverride);

}