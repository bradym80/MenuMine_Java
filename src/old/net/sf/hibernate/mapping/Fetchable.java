//$Id: Fetchable.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

/**
 * Any mapping with an outer-join attribute
 * 
 * @author Gavin King
 */
public interface Fetchable {
    public int getOuterJoinFetchSetting();

    public void setOuterJoinFetchSetting(int joinedFetch);
}