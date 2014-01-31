/*
 * Created on Mar 30, 2005
 *
 * 
 */
package net.sf.hibernate.loader;

/**
 * @author Nick
 * 
 *  
 */
public interface FiveSticksHydrator {

    public static FiveSticksHydratorFactory factory = new FiveSticksHydratorFactory();

    void hydrate(Object object, Object[] values);

}