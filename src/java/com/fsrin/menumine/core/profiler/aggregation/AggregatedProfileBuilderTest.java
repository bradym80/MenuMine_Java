/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class AggregatedProfileBuilderTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasicFlavorWithGarlic() throws Exception {

        Collection profiles = new AggregatedProfileBuilder()
                .buildApplications(new ProfileFieldListProviderFlavorImpl(), "garlic");

        for (Iterator iter = profiles.iterator(); iter.hasNext();) {
            Profile element = (Profile) iter.next();

            log.info("element " + element.getName() + ", " + element.getNumberOfApplications() + ", " + element.getNumberOfOperationsUsing());
            
            assertTrue(element.getNumberOfApplications() > 0);
        }
    }
    
    public void testBasicFlavorWithGarlicOperatorShare() throws Exception {

        Collection profiles = new AggregatedProfileBuilder()
                .buildOperatorShare(new ProfileFieldListProviderFlavorImpl(), "garlic",null);

        for (Iterator iter = profiles.iterator(); iter.hasNext();) {
            Profile element = (Profile) iter.next();

            log.info("element " + element.getName() + ", " + element.getNumberOfApplications() + ", " + element.getNumberOfOperationsUsing());
            
            assertTrue(element.getNumberOfApplications() > 0);
        }
    }
    
    public void testBasicFlavorWithGarlicSegmentShare() throws Exception {

        Collection profiles = new AggregatedProfileBuilder()
                .buildSegmentShare(new ProfileFieldListProviderFlavorImpl(), "garlic",null);

        for (Iterator iter = profiles.iterator(); iter.hasNext();) {
            Profile element = (Profile) iter.next();

            log.info("element " + element.getName() + ", " + element.getNumberOfApplications() + ", " + element.getNumberOfOperationsUsing());
            
            assertTrue(element.getNumberOfApplications() > 0);
        }
    }    
    
    public void testBasicFlavorWithGarlicSectorShare() throws Exception {

        Collection profiles = new AggregatedProfileBuilder()
                .buildSectorShare(new ProfileFieldListProviderFlavorImpl(), "garlic",null);

        for (Iterator iter = profiles.iterator(); iter.hasNext();) {
            Profile element = (Profile) iter.next();

            log.info("element " + element.getName() + ", " + element.getNumberOfApplications() + ", " + element.getNumberOfOperationsUsing());
            
            assertTrue(element.getNumberOfApplications() > 0);
        }
    }    
    
    public void testBasicFlavorWithGarlicBigPicture() throws Exception {

        Profile element = new AggregatedProfileBuilder()
                .buildBigPicture(new ProfileFieldListProviderFlavorImpl(), "garlic");



            log.info("element " + element.getName() + ", " + element.getNumberOfApplications() + ", " + element.getNumberOfOperationsUsing());
            
            assertTrue(element.getNumberOfApplications() > 0);
            assertTrue(element.getNumberOfApplicationsPerOperator() > 0.0);
            assertTrue(element.getOperationPenetration() > 0.0);
        
    }      

}
