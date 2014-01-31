/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.Collection;

public interface IncidenceTable {

    public IncidenceTotals getTotals();

    public Collection getIncidenceSectors();

    public Integer getYear();

}