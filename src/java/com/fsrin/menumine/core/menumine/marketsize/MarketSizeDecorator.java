/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MarketSizeDecorator {

    private Log log = LogFactory.getLog(MarketSizeDecorator.class);

    public void decorate(MarketSizeIncidenceTable table,
            MarketSizeOptions options) {

        double totalProjectedMarketSize = 0.0;

        Map universe = new MarketSizeSegmentUniverseBuilder().getUniverse();

        for (Iterator iter = table.getIncidenceSectors().iterator(); iter
                .hasNext();) {
            MarketSizeIncidenceSector sectorElement = (MarketSizeIncidenceSector) iter
                    .next();

            for (Iterator iterator = sectorElement.getIncidenceSegments()
                    .iterator(); iterator.hasNext();) {
                MarketSizeIncidenceSegment segmentElement = (MarketSizeIncidenceSegment) iterator
                        .next();

                MarketSizeOptionDetail detail = options
                        .getByName(segmentElement.getName());

                Integer universeSize = (Integer) universe.get(segmentElement
                        .getName());

                if (universeSize != null)
                    segmentElement.setUnitsInUniverse(universeSize.intValue());
                else
                    log.info("universe size is null");

                segmentElement.setMenuCycle(detail.getMenuCycle());
                segmentElement
                        .setOuncesPerServing(detail.getOuncesPerServing());
                segmentElement.setServingsPerDay(detail.getServingsPerDay());

                double projectedMarket = (segmentElement.getCategoryIncidence() / 100.0)
                        * ((double) segmentElement.getUnitsInUniverse())
                        * ((double) detail.getServingsPerDay())
                        * detail.getOuncesPerServing()
                        * ((double) detail.getMenuCycle())
                        * options.getResultConversion();


                segmentElement.setProjectedMarketSize(projectedMarket);
                segmentElement.setConversionConstant(options
                        .getResultConversion());

                // total
                totalProjectedMarketSize += segmentElement
                        .getProjectedMarketSize();

                // sector
                sectorElement.setUnitsInUniverse(sectorElement
                        .getUnitsInUniverse()
                        + segmentElement.getUnitsInUniverse());
                sectorElement.setProjectedMarketSize(sectorElement
                        .getProjectedMarketSize()
                        + segmentElement.getProjectedMarketSize());

                // table totals

                table.getMarketSizeTotals().setUnitsInUniverse(
                        table.getMarketSizeTotals().getUnitsInUniverse()
                                + segmentElement.getUnitsInUniverse());

                table.getMarketSizeTotals().setProjectedMarketSize(
                        table.getMarketSizeTotals().getProjectedMarketSize()
                                + segmentElement.getProjectedMarketSize());
            }

        }

        // round two decorate for volume.
        for (Iterator iter = table.getIncidenceSectors().iterator(); iter
                .hasNext();) {
            MarketSizeIncidenceSector sectorElement = (MarketSizeIncidenceSector) iter
                    .next();

            sectorElement.setOverallShare(sectorElement
                    .getProjectedMarketSize()
                    / totalProjectedMarketSize);

            for (Iterator iterator = sectorElement.getIncidenceSegments()
                    .iterator(); iterator.hasNext();) {
                MarketSizeIncidenceSegment segmentElement = (MarketSizeIncidenceSegment) iterator
                        .next();

                segmentElement.setOverallShare(segmentElement
                        .getProjectedMarketSize()
                        / totalProjectedMarketSize);
            }
        }
    }
}
