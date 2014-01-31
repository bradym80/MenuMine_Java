/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.flavortrak;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.flavortrak.xwork.FlavorTrakContext;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.express.ParameterDecoratorFactory;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;

public class FlavorTrakBuilder {

    private Log log = LogFactory.getLog(FlavorTrakBuilder.class);

    private int wordCount;

    private int recordCount;

    public void build(FlavorTrakContext flavorTrakContext)
            throws Exception {

        Collection ret = new TreeSet();

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        /*
         * 2006-01-31 RSC gets rid of the UK
         */
        p.getHqRegion().getNotValues().add("UK");

        /*
         * get the tokens and decorate the query
         */
        if (flavorTrakContext.getQuery() != null) {
            ParameterDecoratorFactory.factory.buildExpressKeywords(p).decorate(
                    flavorTrakContext.getQuery());
        }
        p.getKeywords().setSelect(Boolean.TRUE);

        if (flavorTrakContext.getCuisineFamily() != null) {
            p.getCuisineFamily().getAndValues().add(
                    flavorTrakContext.getCuisineFamily());
        }

        if (flavorTrakContext.getGenCookingMethod() != null) {
            p.getGenCookMeth().getAndValues().add(
                    (flavorTrakContext.getGenCookingMethod()));
        }

        if (flavorTrakContext.getGenMenuPart() != null) {
            p.getGenMenuPart().getAndValues().add(
                    flavorTrakContext.getGenMenuPart());

        }

        // Collection temp =
        // MasterFoodServiceDelegateFactory.factory.build().searchMasterFoodByHQLConjunction(p);

        Long i = MasterFoodServiceDelegateFactory.factory.build().getCount(p);

        // log.info("basic result size is " + temp.size());

        // for (Iterator iter = temp.iterator(); iter.hasNext();) {
        // MasterFood element = (MasterFood) iter.next();
        //            
        // String[] e = element.getKeywords().split(" ");
        //            
        // for (int i = 0; i < e.length; i++) {
        // ret.add(e[i]);
        // }
        //            
        // }
        //        
        // this.setWordCount(ret.size());

        // this.setRecordCount(temp.size());

        this.setRecordCount(i.intValue());

//        return null;

    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

}
