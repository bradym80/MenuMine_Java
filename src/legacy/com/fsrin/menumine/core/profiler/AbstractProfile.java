/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;
import com.fsrin.menumine.core.profiler.aggregation.Profile;

/**
 * @author Nick
 * 
 *  
 */
public abstract class AbstractProfile implements Profile {

    private Profiler profiler;

    private String name = "Profile";

    private long applications = 0;

    private Map operationMap = new HashMap();

    public abstract FieldEnum getFieldEnum();

    public double getOperationPenetration() {
        return 0.0;
    }
    public long getNumberOfApplications() {

        return applications;
    }

    public double getApplicationShare() {
        return (double) this.getNumberOfApplications()
                / (double) profiler.getTotalApplications();
    }

    public long getNumberOfOperationsUsing() {
        return operationMap.size();
    }

    public double getNumberOfApplicationsPerOperator() {
        if (this.getNumberOfOperationsUsing() == 0) {
            return 0;
        }

        return ((double) this.getNumberOfApplications())
                / ((double) this.getNumberOfOperationsUsing());
    }

    public void profile(Object element, Collection searchableTokens) {

        if (this.test(element, searchableTokens)) {
            applications++;
            this.addOperator(element);
        }

    }

    private void addOperator(Object element) {
        if (element instanceof AbstractChainInformationBean) {
            String chain = ((AbstractChainInformationBean) element).getOperationName();
            if (chain == null)
                chain = AbstractChainInformationBean.UNKNOWN_OPERATION_KEY;
            this.incrementCount(chain);
        } else {
            throw new RuntimeException("can't increment type " + element.getClass().getName());
        }

    }

    private void incrementCount(String chain) {
        Long count = this.getCount(chain);

        updateCount(chain, new Long(count.longValue() + 1));

    }

    private void updateCount(String chain, Long value) {
        String key = chain;
        operationMap.put(key, value);
    }

    private Long getCount(String operationName) {
        String key = operationName;
        if (operationMap.containsKey(key)) {
            return (Long) operationMap.get(key);
        } else {
            Long value = new Long(0);
            operationMap.put(key, value);
            return value;
        }
    }

    protected boolean test(Object testObject, Collection params) {
//2006-04-20 RSC They're all MF now.
//        if (!this.testInstanceOf(testObject)) {
//            return false;
//        }

        if (this.testNull(testObject)) {
            return false;
        }

        /*
         * If we don't have params it matches by default. This is needed for the
         * generic Profile
         */
        if (params != null) {
            boolean contains = false;
            for (Iterator iter = params.iterator(); iter.hasNext();) {
                String element = (String) iter.next();

                /*
                 * We need at least one of the params
                 */
                if (this.containsParam(testObject, element)) {
                    return contains = true;
                }

            }
            return contains;
        }
        return true;

    }

    protected boolean containsParam(Object testObject, String element) {
        String value = this.getValue(testObject);
        boolean b = this.getValue(testObject).toLowerCase().indexOf(
                element.toLowerCase()) >= 0;
        return b;
    }

    protected boolean testNull(Object testObject) {

        return this.getValue(testObject) == null;
    }

    protected abstract String getValue(Object testObject);

//    protected abstract boolean testInstanceOf(Object testObject);

    public void setProfiler(Profiler profiler) {
        this.profiler = profiler;
    }

    public String getName() {
        if (this.getFieldEnum() != null) 
            return this.getFieldEnum().getFriendlyName();
        else
            return name;
    }
    
    public String getOgnlName() {
        return this.getFieldEnum().getOgnlName();
    }

    public void setName(String name) {
        this.name = name;
    }
}