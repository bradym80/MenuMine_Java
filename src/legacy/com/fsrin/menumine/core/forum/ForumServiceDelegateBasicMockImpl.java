/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Nick
 * 
 * This mock will let up save messages and return all of them in the search.
 */
public class ForumServiceDelegateBasicMockImpl implements ForumServiceDelegate {

    private Collection data = new ArrayList();

    public ForumServiceDelegateBasicMockImpl() {
        super();

    }

    public void save(ForumMessage forumMessage) {

        data.add(forumMessage);
    }

    public Collection search(ForumMessageSearchParameters parameters) {

        return data;
    }

    public void delete(ForumMessage message) {
        data.remove(message);
    }

    public ForumMessage getById(Long target) {

        return null;
    }

}