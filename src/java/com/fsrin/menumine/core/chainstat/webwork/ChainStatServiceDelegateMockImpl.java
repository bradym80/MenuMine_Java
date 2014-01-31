/*
 * Created on May 25, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainstat.webwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.core.chainstat.ChainStatFilterParameters;
import com.fsrin.menumine.core.chainstat.ChainStatSearchException;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegate;
import com.fsrin.menumine.core.chainstat.ChainStatServiceDelegateException;

/**
 * @author Nick
 * 
 *  
 */
public class ChainStatServiceDelegateMockImpl implements
        ChainStatServiceDelegate {

    private Collection col = new ArrayList();

    public ChainStatServiceDelegateMockImpl() {
        super();

        ChainStat stat = new ChainStat();
        stat.setId(new Long(10));
        stat.setOperationName("Applebees");
        stat.setSectorName("sector");
        stat.setSegment("segment");
        col.add(stat);

        stat = new ChainStat();
        stat.setId(new Long(11));
        stat.setOperationName("Applebees2");
        stat.setSectorName("sector2");
        stat.setSegment("segment2");
        col.add(stat);
    }

    public Collection find(ChainStatFilterParameters filterParameters)
            throws ChainStatSearchException {

        return col;
    }

    public Collection getDistinctSegments() {
        Collection names = new ArrayList();
        for (Iterator iter = col.iterator(); iter.hasNext();) {
            ChainStat element = (ChainStat) iter.next();
            names.add(element.getSegment());

        }
        return names;
    }

    public Collection getDistinctSectorNames() {
        Collection names = new ArrayList();
        for (Iterator iter = col.iterator(); iter.hasNext();) {
            ChainStat element = (ChainStat) iter.next();
            names.add(element.getSectorName());

        }
        return names;
    }

    public Collection getDistinctOperationNames() {
        Collection names = new ArrayList();
        for (Iterator iter = col.iterator(); iter.hasNext();) {
            ChainStat element = (ChainStat) iter.next();
            names.add(element.getOperationName());

        }
        return names;
    }

    public ChainStat getById(Long target)
            throws ChainStatServiceDelegateException {
        for (Iterator iter = col.iterator(); iter.hasNext();) {
            ChainStat element = (ChainStat) iter.next();
            if (element.getId().longValue() == target.longValue()) {
                return element;
            }

        }
        return null;
    }

    public void save(ChainStat chainStat)
            throws ChainStatServiceDelegateException {
    }

}