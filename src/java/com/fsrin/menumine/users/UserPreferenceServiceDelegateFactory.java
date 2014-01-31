/*
 * Created on Apr 13, 2006 by Reid
 */
package com.fsrin.menumine.users;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

public class UserPreferenceServiceDelegateFactory extends
        AbstractSpringObjectFactory {

    public final String SPRING_BEAN_NAME = "userPreferenceServiceDelegate";

    public static UserPreferenceServiceDelegate build() {
        return new UserPreferenceServiceDelegateFactory().getInstance();
    }
    
    public UserPreferenceServiceDelegate getInstance() {
        return (UserPreferenceServiceDelegate) this.build(SPRING_BEAN_NAME);
    }
}
