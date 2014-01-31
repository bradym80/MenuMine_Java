/*
 * Created on Apr 19, 2006 by Reid
 */
package com.fstx.stdlib2.authen;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

public class LoginHistoryBDFactory extends AbstractSpringObjectFactory {

    public final String SPRING_BEAN_NAME = "loginHistoryBD";
    
    public static final LoginHistoryBDFactory factory = new LoginHistoryBDFactory();
    
    public LoginHistoryBD build() {
        return (LoginHistoryBD) this.build(SPRING_BEAN_NAME);
    }
}
