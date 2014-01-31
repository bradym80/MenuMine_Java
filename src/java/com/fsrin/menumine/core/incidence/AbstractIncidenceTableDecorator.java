/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.incidence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractIncidenceTableDecorator {

    private Log log = LogFactory.getLog(AbstractIncidenceTableDecorator.class);
    
    public void handleDecorate(Collection chains, Map segmentsInFood, IncidenceTableAggregationImpl ret, IncidenceTotalsAggregationImpl totals)  {
        
        String sector = "";
        
        IncidenceSectorAggregationImpl current = null;
        
        for (Iterator iter = chains.iterator(); iter.hasNext();) {
            Object[] element = (Object[]) iter.next();

            if (element[0] == null) {
                element[0] = "N/A";
            }
            if (element[1] == null) {
                element[1] = "N/A";
            }

//            log.info("sector: " + (String) element[0]);

            if (!((String) element[0]).equals(sector)) {
                //current = new IncidenceSectorAggregationImpl();
                current = this.getIncidenceSector();
                sector = (String) element[0];
                current.setName(sector);
                current.setIncidenceSegments(new ArrayList());
                ret.getIncidenceSectors().add(current);
            }

            if (current == null)
                throw new RuntimeException(
                        "don't have a current sector to put data in.");

            //IncidenceSegmentAggregationImpl segment = new IncidenceSegmentAggregationImpl();
            IncidenceSegmentAggregationImpl segment = this.getIncidenceSegment();

            Object[] foodSegment = (Object[])segmentsInFood.get((String)element[1]);
            
            if (foodSegment == null) {
                Object[] temp = { element[0], element[1], new Integer(0), new Integer(0) };
                foodSegment = temp;
//                log.info("food segment is null");
            }
            
            
            segment.setName((String) element[1]);
            if (segment.getName().equalsIgnoreCase("Family Dining Chain- Pizza/Italian")) {
                log.info("Family Dining Chain- Pizza/Italian");
            }
            segment.setNumberOfChains(((Integer)element[2]).intValue());
            segment.setNumberOfChainsMenuingItems(((Integer) foodSegment[3])
                    .intValue());
            
            current.getIncidenceSegments().add(segment);

            current.setNumberOfChains(current
                    .getNumberOfChains()
                    + segment.getNumberOfChains());
            current.setNumberOfChainsMenuingItems(current
                    .getNumberOfChainsMenuingItems()
                    + segment.getNumberOfChainsMenuingItems());

            totals.setNumberOfChainsInSector(totals.getNumberOfChainsInSector() + segment.getNumberOfChains());
            totals.setNumberOfChainsMenuingItems(totals.getNumberOfChainsMenuingItems() + segment.getNumberOfChainsMenuingItems());
            totals.setNumberOfItemsBeingMenued(totals.getNumberOfItemsBeingMenued() + segment.getNumberOfItemsBeingMenued());

            
        }      
        
    }
    
    public abstract IncidenceSectorAggregationImpl getIncidenceSector();
    
    public abstract IncidenceSegmentAggregationImpl getIncidenceSegment();
}
