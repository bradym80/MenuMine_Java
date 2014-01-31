/*
 * Created on Aug 16, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.authorization.AuthorizationBean;
import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.common.util.MenuMineUtil;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.express.util.CleanedTokenCollectionBuilder;
import com.fsrin.menumine.core.menumine.express.util.FilteredTokenCollectionBuilder;
import com.fsrin.menumine.core.menumine.express.util.TokenCollectionBuilder;
import com.fsrin.menumine.core.menumine.masterfood.DistinctQueryBuilder;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodSearchException;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * 2006-01-18 Reviewing.
 * 
 * @author Reid
 * @author Nick
 * 
 * The MenuMineExpressQueryBuilder takes a simple query string and attempts to
 * determine what the user wants to see.
 * 
 * It will determine which mines are most likly to fit the query, then it
 * figures out what fields to look in.
 * 
 */
public class MenuMineExpressQueryBuilderStandardImpl implements ExpressQueryBuilder {
    private DistinctQueryBuilder distinctQueryBuilder;

    private static Long EXPRESS_INITIAL_SEARCH_LIMIT = new Long(8000);

    private static Log log = LogFactory
            .getLog(MenuMineExpressQueryBuilderStandardImpl.class);

    private MasterFoodFilterParameters expressQuery;

    private Collection expressResults;

    private AuthorizationBean authorizationBean;

    // private FieldsToDisplayBean expressFieldsToDisplayBean;

    private Collection cleanedTokenCollection;

    private Collection mineFieldsExpressQueryCounters;

    private Collection mineOptions;

    /*
     * This allows us to target a specific mine.
     */
    private String mineTypeOverride;

    private String expressSearchQuery = null;

    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    public MenuMineExpressQueryBuilderStandardImpl(AuthorizationBean authorizationBean) {
        super();
        this.authorizationBean = authorizationBean;
    }

    /*
     * Since we create this in spring and need to set the AuthorizationBean in
     * the action, we have to
     */
    public MenuMineExpressQueryBuilderStandardImpl() {
        super();

    }

    public void processQuery() {
        /*
         * This breaks the string in to tokens by spliting on all non alpha
         * chars. This can be refined possibly just spaces and commas.
         */
        Collection tokenCollection = this.buildTokens();

        /*
         * Filter out tokens that are meaningless.
         */
        Collection filteredTokenCollection = this.filterTokens(tokenCollection);
        /*
         * Clean the tokens.(make sure they are all trimmed.)
         */
        cleanedTokenCollection = this.cleanTokens(filteredTokenCollection);

        /*
         * Build the express Query. Put all the terms in to the description,
         * unless we can pre determine a better place.
         */
        log.info("building the query");
        this.buildExpressQuery(cleanedTokenCollection);

        /*
         * Get our rough results.
         */
        log.info("building results");
        this.buildExpressResults();

        /*
         * Use the keyCounters to figure out possible mines.
         */
        log.info("determining mine type");
        this.determineMineType();

        // /* Moved to the MineFieldsExpressQueryCounter
        // * Guess at what fields should be displayed.
        // */
        // this.buildExpressFieldsToDisplayBean();
        log.info("finishing in MenuMine...");

    }

    /*
     * By looking at the keyCounters we determine which MineTypes we are likely
     * to be used.
     * 
     * We will have to select multiple that are likly, to suggest option to the
     * user.
     * 
     * We will also have to look at the users authorizations.
     * 
     */
    private void determineMineType() {

        /*
         * We can't determine the value of a mine in isolation.
         * 
         * They need to be compared to each other. Seasoning may # in the ingred
         * mine, but be well below a dessert fields.
         */
        if (MenuMineUtil.isEmpty(this.getMineTypeOverride())) {
            MineDetector mineDetector = new MineDetector();
            this.mineOptions = mineDetector.detect(this
                    .getMineFieldsExpressQueryCounters());
        } else {
            MineDetector mineDetector = new MineDetectorOverrideImpl(this
                    .getMineTypeOverride());
            this.mineOptions = mineDetector.detect(this
                    .getMineFieldsExpressQueryCounters());
        }

    }

    /*
     * Return the most likly mine, that the user is authorized to view. As the
     * auth bean can only be created by a trusted source we know it is valid.
     */
    public MineRank getMineOptionsFeelingLucky() {
        Collection currentRanks = this.getMineOptions();
        if (currentRanks != null) {
            for (Iterator iter = currentRanks.iterator(); iter.hasNext();) {
                MineRank mineRankElement = (MineRank) iter.next();

                if (authorizationBean == null) {
                    throw new RuntimeException(
                            "Express Search can not complete with out authorization.");
                }

                if (authorizationBean.isAuthorized(mineRankElement
                        .getMineFieldsExpressQueryCounter().getTargetMine())) {

                    return mineRankElement;
                }
            }

        }

        return null;
    }

    private Collection buildKeyCounters() {

        /*
         * Init the key counters.
         */
        Collection mineFieldsExpressQueryCounters = new ArrayList();

        for (Iterator iter = MineFields.factory.getAll().iterator(); iter
                .hasNext();) {
            MineFields mineFieldsElement = (MineFields) iter.next();
            MineFieldsExpressQueryCounter counter = new MineFieldsExpressQueryCounter(
                    mineFieldsElement, this.cleanedTokenCollection);
            mineFieldsExpressQueryCounters.add(counter);
        }

        long count = 0;

        for (Iterator iter = this.expressResults.iterator(); iter.hasNext()
                && count < EXPRESS_INITIAL_SEARCH_LIMIT.longValue();) {
            count++;
            //MasterFood masterFoodElement = (MasterFood) iter.next();
            MasterFood masterFoodElement = (MasterFood) iter.next();

            for (Iterator iterator = mineFieldsExpressQueryCounters.iterator(); iterator
                    .hasNext();) {
                MineFieldsExpressQueryCounter mineFieldsExpressQueryCounter = (MineFieldsExpressQueryCounter) iterator
                        .next();
                mineFieldsExpressQueryCounter
                        .handleMasterFood(masterFoodElement);

            }
        }

        return mineFieldsExpressQueryCounters;
    }

    private void buildExpressResults() {
        if (this.expressQuery == null) {
            throw new RuntimeException(
                    "Express Results can not be found with out the Express Query.");
        }

        try {
            // 2006-01-19 RSC Trying to speed up express searching...
             this.expressResults = this.getMasterFoodServiceDelegate()
             .searchMasterFood(this.expressQuery);

//            this.expressResults = this.getMasterFoodServiceDelegate()
//                    .searchMasterFoodExpress(this.expressQuery);
        } catch (MasterFoodSearchException e) {
            throw new RuntimeException("Error searching for Express Results.",
                    e);
        }

    }

    /*
     * 2006-01-24 RSC
     * 
     * The express query looks for mathing field names in field enum
     * *OR* a matching entry in one of the many distinct queries.  
     * If it finds those, it uses that.  
     * 
     * Otherwise it uses item description.
     * 
     */
    private void buildExpressQuery(Collection tokens) {

        expressQuery = new MasterFoodFilterParametersImpl();

        // Collection usedTokens = new ArrayList();
        /*
         * 2006-01-18 RSC goes through the tokens
         */
        for (Iterator iter = tokens.iterator(); iter.hasNext();) {
            String token = (String) iter.next();
            boolean isTokenInList = false;
            /*
             * and then goes through ALL of the fields.
             */
            for (Iterator iterator = FieldEnum.getAll().iterator(); iterator
                    .hasNext();) {
                FieldEnum field = (FieldEnum) iterator.next();

                /*
                 * If the token is one of the field names we can assume they are
                 * specificaly interested in that field.
                 */
                if (token.toLowerCase().equals(field.getName().toLowerCase())) {
                    try {
                        FilterParameter fp = (FilterParameter) Ognl.getValue(
                                field.getOgnlName(), expressQuery);
                        if (fp != null) {
                            fp.setEmpty(Boolean.FALSE);
                            isTokenInList = true;

                        }
                    } catch (OgnlException e) {

                        // e.printStackTrace();
                    }

                } else {

                    try {
                        Collection values = (Collection) Ognl.getValue(field
                                .getDistinctQuery(), distinctQueryBuilder);

                        for (Iterator iteratorIn = values.iterator(); iteratorIn
                                .hasNext();) {
                            String inValue = (String) iteratorIn.next();

                            if (inValue.toLowerCase().equals(
                                    token.toLowerCase())) {
                                FilterParameter fp = (FilterParameter) Ognl
                                        .getValue(field.getOgnlName(),
                                                expressQuery);
                                if (fp != null) {
                                    fp.getAndValues().add(token);
                                    isTokenInList = true;
                                }
                            }
                        }

                    } catch (OgnlException e) {

                        // e.printStackTrace();
                    }

                }

            }

            if (!isTokenInList) {
                expressQuery.getItemDescription().getAndValues().add(token);
            }
        }

        expressQuery.setLimit(EXPRESS_INITIAL_SEARCH_LIMIT);

        log.info("express query is " + expressQuery.toString());

    }

    private Collection cleanTokens(Collection tokenCollection) {
        
        return new CleanedTokenCollectionBuilder().clean(tokenCollection);
        
    }

    private Collection filterTokens(Collection tokens) {

        return new FilteredTokenCollectionBuilder().getFilteredTokens(tokens);
    }

    private Collection buildTokens() {
        
        return new TokenCollectionBuilder().buildTokens(this.getExpressSearchQuery());

    }

    public String getExpressSearchQuery() {
        return expressSearchQuery;
    }

    public void setExpressSearchQuery(String expressSearchQuery) {
        if (MenuMineUtil.isEmpty(this.expressSearchQuery)) {
            this.expressSearchQuery = expressSearchQuery;
        } else {
            throw new RuntimeException(
                    "Attempting to modify Express Search Query.");
        }
    }

    /*
     * This is a query that just searches the description
     */

    public MasterFoodFilterParametersWrapper getExpressQuery() {

        return new MasterFoodFilterParametersWrapperImpl(this.expressQuery);
    }

    /*
     * This predicts a more refined search avoiding the description fields.
     * 
     * This will look at each term in the query and determine the most
     * appropriate field.
     * 
     * 
     */
    public MasterFoodFilterParametersWrapper getRefinedExpressQuery() {
        Collection keyCounters = this.getMineFieldsExpressQueryCounters();
        MasterFoodFilterParameters params = new MasterFoodFilterParametersImpl();
        MasterFoodFilterParametersWrapperImpl paramsWrapper = new MasterFoodFilterParametersWrapperImpl(
                params);

        MineFields mineFields = this.getMineOptionsFeelingLucky()
                .getMineFieldsExpressQueryCounter().getTargetMine();

        MineFieldsExpressQueryCounter mineFieldsExpressQueryCounter = this
                .getMineOptionsFeelingLucky()
                .getMineFieldsExpressQueryCounter();

        // HashSet usedTokens = new HashSet();

        HashMap tokenFieldMap = new HashMap();

        for (Iterator iter = cleanedTokenCollection.iterator(); iter.hasNext();) {
            String element = (String) iter.next();

            tokenFieldMap.put(element, null);
        }

        /*
         * We need to keep this in case of emergency. We don't want to end up
         * not using a tok some how.
         */
        KeyCounter descriptionKeyCounter = null;

        for (Iterator iter = mineFieldsExpressQueryCounter
                .getSortedMineFieldKeyCounters().iterator(); iter.hasNext();) {
            KeyCounter element = (KeyCounter) iter.next();

            if (element.getMineField().getFieldEnum() != FieldEnum.DESCRIPTION
                    && element.getMineField().getFieldEnum() != FieldEnum.MENU_ITEM_NAME) {
                if (element.getCount().intValue() > 0) {

                    for (Iterator iterToks = cleanedTokenCollection.iterator(); iterToks
                            .hasNext();) {
                        String tok = (String) iterToks.next();
                        boolean isTokenInList = false;
                        /* Start tok */
                        for (Iterator iterator = FieldEnum.getAll().iterator(); iterator
                                .hasNext();) {
                            FieldEnum field = (FieldEnum) iterator.next();
                            /*
                             * If the token is one of the field names we can
                             * assume they are specificaly interested in that
                             * field.
                             */
                            if (tok.toLowerCase().equals(
                                    field.getName().toLowerCase())) {
                                try {
                                    FilterParameter fp = (FilterParameter) Ognl
                                            .getValue(field.getOgnlName(),
                                                    expressQuery);
                                    if (fp != null) {
                                        fp.setEmpty(Boolean.FALSE);
                                        isTokenInList = true;

                                    }
                                } catch (OgnlException e) {

                                    // e.printStackTrace();
                                }

                            }

                        }
                        /* end test */

                        if (!isTokenInList) {
                            Integer countForTokInField = element.getCount(tok);

                            if (countForTokInField != null) {

                                KeyCounter maxKeyCounter = (KeyCounter) tokenFieldMap
                                        .get(tok);

                                if (maxKeyCounter != null) {
                                    if (countForTokInField.intValue() > maxKeyCounter
                                            .getCount(tok).intValue()) {
                                        tokenFieldMap.put(tok, element);
                                    }

                                } else {

                                    tokenFieldMap.put(tok, element);
                                }

                            }
                        }
                    }
                }

            } else {
                if (element.getMineField().getFieldEnum() != FieldEnum.DESCRIPTION) {
                    descriptionKeyCounter = element;
                }

            }
        }

        for (Iterator iter = tokenFieldMap.keySet().iterator(); iter.hasNext();) {
            String tok = (String) iter.next();
            KeyCounter keyCounter = (KeyCounter) tokenFieldMap.get(tok);
            if (keyCounter == null) {
                keyCounter = descriptionKeyCounter;
            }

            try {
                String ognlName = keyCounter.getMineField().getFieldEnum()
                        .getOgnlName();
                FilterParameter fp = (FilterParameter) Ognl.getValue(ognlName,
                        paramsWrapper.getMasterFoodFilterParameters());

                fp.getAndValues().add(tok);
                // Ognl.setValue(keyCounter.getMineField().getFieldEnum()
                // .getAndName(), paramsWrapper, tok);

            } catch (OgnlException e) {

                e.printStackTrace();
            }
        }
 

        return paramsWrapper;

    }

    public MasterFoodServiceDelegate getMasterFoodServiceDelegate() {
        return masterFoodServiceDelegate;
    }

    public void setMasterFoodServiceDelegate(
            MasterFoodServiceDelegate masterFoodServiceDelegate) {
        this.masterFoodServiceDelegate = masterFoodServiceDelegate;
    }

    public Collection getMineFieldsExpressQueryCounters() {
        if (mineFieldsExpressQueryCounters == null) {
            mineFieldsExpressQueryCounters = this.buildKeyCounters();
        }
        return mineFieldsExpressQueryCounters;
    }

    public Collection getMineOptions() {
        return mineOptions;
    }

    public DistinctQueryBuilder getDistinctQueryBuilder() {
        return distinctQueryBuilder;
    }

    public void setDistinctQueryBuilder(
            DistinctQueryBuilder distinctQueryBuilder) {
        this.distinctQueryBuilder = distinctQueryBuilder;
    }

    public void setAuthorizationBean(AuthorizationBean authorizationBean) {
        this.authorizationBean = authorizationBean;
    }

    public String getMineTypeOverride() {
        return mineTypeOverride;
    }

    public void setMineTypeOverride(String mineTypeOverride) {
        this.mineTypeOverride = mineTypeOverride;
    }
}