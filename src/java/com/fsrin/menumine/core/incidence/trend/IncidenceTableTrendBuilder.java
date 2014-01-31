/*
 * Created on Jan 30, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence.trend;

import java.util.Iterator;

import ognl.Ognl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.incidence.IncidenceSector;
import com.fsrin.menumine.core.incidence.IncidenceSegment;
import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptions;
import com.fsrin.menumine.core.incidence.IncidenceTableBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

public class IncidenceTableTrendBuilder {

    private static Log log = LogFactory
            .getLog(IncidenceTableTrendBuilder.class);

    public IncidenceTableTrend build(MasterFoodFilterParameters params)
            throws Exception {

        Integer[] years = getYears();

        IncidenceTableTrend ret = new IncidenceTableTrend();

        for (int i = 0; i < years.length; i++) {
            Integer targetYear = years[i];

            IncidenceTableBuildOptions targetYearOptions = new IncidenceTableBuildOptions();
            targetYearOptions.setParams(params.clone());

            Ognl.setValue("price" + targetYear + ".empty", targetYearOptions
                    .getParams(), Boolean.FALSE);

            targetYearOptions.setYear(targetYear);

            log.info("Target Year " + targetYear);

            /*
             * build it
             */
            IncidenceTable yearTable = new IncidenceTableBuilder()
                    .buildCategoryIncidenceTable(targetYearOptions);

            /*
             * grab the headers
             */
            Ognl.setValue("trendTotals.total" + targetYear, ret, yearTable
                    .getTotals());

            /*
             * go through the sectors and then the segments
             */

            for (Iterator iter = yearTable.getIncidenceSectors().iterator(); iter
                    .hasNext();) {
                IncidenceSector element = (IncidenceSector) iter.next();

                IncidenceTrendItemHeader header = (IncidenceTrendItemHeader) ret
                        .getIncidenceTrendHeaders().get(element.getName());

                if (header == null) {
                    header = new IncidenceTrendItemHeader();
                    header.setName(element.getName());
                    ret.getIncidenceTrendHeaders().put(element.getName(),
                            header);
                }

                Ognl.setValue("incidence" + targetYear, header, element
                        .getCategoryIncidence());

                for (Iterator iterator = element.getIncidenceSegments()
                        .iterator(); iterator.hasNext();) {
                    IncidenceSegment segment = (IncidenceSegment) iterator
                            .next();

                    IncidenceTrendItem item = (IncidenceTrendItem) header
                            .getIncidenceTrendItems().get(segment.getName());
                    
                    if (item == null) {
                        item = new IncidenceTrendItem();
                        item.setName(segment.getName());
                        header.getIncidenceTrendItems().put(segment.getName(),item);
                    }

                    Ognl.setValue("incidence" + targetYear, item, segment
                            .getCategoryIncidence());
                    
                }

            }

        }

        return ret;

    }

    private Integer[] getYears() {

        Integer[] years = {
        		// DBB 1-20-2009 Add 2008, 2009
        		// MJB 11-12-2009 Activated Integer 2009
        		new Integer(2011), new Integer(2010), new Integer(2009), new Integer(2008),
        		new Integer(2007), new Integer(2006), new Integer(2005),
                new Integer(2004), new Integer(2003), new Integer(2002),
                new Integer(2001), new Integer(2000), new Integer(1999),
                new Integer(1998), new Integer(1997), new Integer(1996) };

        return years;

    }

}
