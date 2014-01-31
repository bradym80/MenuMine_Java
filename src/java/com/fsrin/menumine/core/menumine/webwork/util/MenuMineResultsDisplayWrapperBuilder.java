/*
 * Created on Jan 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ognl.OgnlException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.crosstab.CrossTabulationTable;
import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptions;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptionsWithChains;
import com.fsrin.menumine.core.incidence.IncidenceTableException;
import com.fsrin.menumine.core.incidence.IncidenceTableStandardImpl;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.chain.ChainServiceDelegate;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.webwork.MenuMineCrossTabulationOptions;
import com.fsrin.menumine.core.minefields.MineField;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * @author Nick
 * 
 * 
 */
public class MenuMineResultsDisplayWrapperBuilder {

    public static MenuMineResultsDisplayWrapperBuilder singleton = new MenuMineResultsDisplayWrapperBuilder();

    private ChainServiceDelegate chainServiceDelegate;

    public static Log log = LogFactory
            .getLog(MenuMineResultsDisplayWrapperBuilder.class);

    private MenuMineResultsDisplayWrapperBuilder() {
        super();
    }

    public Collection buildCollection(Collection results,
            FieldsToDisplayBean fieldsToDisplay, MineFields mineFields) {
        
        log.debug("starting to build the display wrapper collection.");
        
        MenuMineResultsDisplayWrapperHeader header = this.buildHeader(
                fieldsToDisplay, mineFields);

        Collection wrappers = new ArrayList();
        for (Iterator iter = results.iterator(); iter.hasNext();) {

            MasterFood element = (MasterFood) iter.next();
            MenuMineResultsDisplayWrapper wrapper = this.buildSingle(element,
                    fieldsToDisplay, header);
            wrapper.setHeader(header);
            wrappers.add(wrapper);
        }
        
        log.debug("completed building collection");
        return wrappers;
    }

    private MenuMineResultsDisplayWrapper buildSingle(MasterFood masterFood,
            FieldsToDisplayBean fieldsToDisplay,
            MenuMineResultsDisplayWrapperHeader header) {
        
//        log.debug("building a single wrapper.");
        MenuMineResultsDisplayWrapper displayWrapper = new MenuMineResultsDisplayWrapper();

        Collection tempValues = new ArrayList();

        for (Iterator iter = header.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            if (element != null) {
                Object value = null;
                try {
                    // value = Ognl.getValue(element.getOgnlName(), masterFood);
                    value = PropertyUtils.getProperty(masterFood, element
                            .getOgnlName());
                } catch (Exception e) {
                    log.error("Reflection Exception:" + e.getMessage());
                }
                tempValues.add(value);
            }
        }

        /*
         * Init the array so we have enough space allocated so we can get the
         * 7th even if it is empty.
         */
        Object[] objects = new Object[15];
        objects = tempValues.toArray(objects);

        displayWrapper.setValue1(objects[0]);
        displayWrapper.setValue2(objects[1]);
        displayWrapper.setValue3(objects[2]);
        displayWrapper.setValue4(objects[3]);
        displayWrapper.setValue5(objects[4]);
        displayWrapper.setValue6(objects[5]);
        displayWrapper.setValue7(objects[6]);
        displayWrapper.setValue8(objects[7]);
        displayWrapper.setValue9(objects[8]);
        displayWrapper.setValue10(objects[9]); 
        displayWrapper.setValue11(objects[10]);
        displayWrapper.setValue12(objects[11]);
        displayWrapper.setValue13(objects[12]);
        displayWrapper.setValue14(objects[13]);
        displayWrapper.setValue15(objects[14]);

//        log.debug("completed single.");
        return displayWrapper;
    }

    private String formatPrice(Double price) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setMinimumFractionDigits(2);
        return currency.format(price);
    }

    public MenuMineResultsDisplayWrapperHeader buildHeader(
            FieldsToDisplayBean fieldsToDisplay, MineFields mineFields) {
        MenuMineResultsDisplayWrapperHeader displayWrapper = new MenuMineResultsDisplayWrapperHeader();
        Collection tempValues = new ArrayList();

        for (Iterator iter = mineFields.getAllFields().iterator(); iter
                .hasNext();) {
            FieldEnum element = ((MineField) iter.next()).getFieldEnum();

            log.debug("current element is " + element.getOgnlName());
            Boolean bool = Boolean.FALSE;
            try {
                bool = (Boolean) PropertyUtils.getProperty(fieldsToDisplay,
                        element.getShortOgnlName());
                // bool = (Boolean) Ognl.getValue(element.getShortOgnlName(),
                // fieldsToDisplay);
            } catch (Exception e) {
                // log.error(e.getMessage());
         //       throw new RuntimeException(
         //               "failed when trying to set display beans", e);
            	log.error(e.getCause());
            	log.equals(e.initCause(e.getCause()));
            }
            if (bool == null) {
                log
                        .info("boolean is null when trying to build a results display wrapper: "
                                + element.getOgnlName());
                bool = false;
            } else if (bool.booleanValue()) {
                tempValues.add(element);
            }
        }

        FieldEnum[] objects = new FieldEnum[15];
        objects = (FieldEnum[]) tempValues.toArray(objects);

        displayWrapper.setValue1(objects[0]);
        displayWrapper.setValue2(objects[1]);
        displayWrapper.setValue3(objects[2]);
        displayWrapper.setValue4(objects[3]);
        displayWrapper.setValue5(objects[4]);
        displayWrapper.setValue6(objects[5]);
        displayWrapper.setValue7(objects[6]);
        displayWrapper.setValue8(objects[7]);
        displayWrapper.setValue9(objects[8]);
        displayWrapper.setValue10(objects[9]);
        displayWrapper.setValue11(objects[10]);
        displayWrapper.setValue12(objects[11]);
        displayWrapper.setValue13(objects[12]);
        displayWrapper.setValue14(objects[13]);
        displayWrapper.setValue15(objects[14]);

        return displayWrapper;
    }

    public CrossTabulationTable buildCrossTabulationTable(Collection results,
            MenuMineCrossTabulationOptions crossTabulationOptions)
            throws OgnlException {

        throw new RuntimeException("no longer using the old builder 2006-01-31");

    }

    public IncidenceTable buildIncidenceTable(IncidenceTableBuildOptionsWithChains options)
            throws IncidenceTableException {

        return new IncidenceTableStandardImpl(options);
    }

    public ChainServiceDelegate getChainServiceDelegate() {
        return chainServiceDelegate;
    }

    public void setChainServiceDelegate(
            ChainServiceDelegate chainServiceDelegate) {
        this.chainServiceDelegate = chainServiceDelegate;
    }
}