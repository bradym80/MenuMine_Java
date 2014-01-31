/*
 * Created on May 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.savedquery;

import java.util.Collection;

import com.fstx.stdlib2.authen.AuthenticatedUser;

/**
 * @author Nick
 * 
 * 
 */
public interface SavedQueryManager {
    /*
     * Find the queries that authenticatedUser has access to by virtue of group
     * affiliation.
     */
    public abstract Collection getGroupQueries(
            AuthenticatedUser authenticatedUser);

    /*
     * Finds the queries this user has greated.
     */
    public abstract Collection getUserQueries(
            AuthenticatedUser authenticatedUser);
}