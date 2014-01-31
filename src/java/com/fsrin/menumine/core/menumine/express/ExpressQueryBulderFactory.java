/*
 * Created on Jan 18, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express;

import com.fsrin.menumine.common.SpringBeanBroker;

public class ExpressQueryBulderFactory {

    public static final String SPRING_BEAN_NAME_STANDARD = "menuMineExpressQueryBuilder";

    public static final String SPRING_BEAN_NAME_MASTERFOODEXPRESS = "menuMineMasterFoodExpressQueryBuilder";

    public static final String SPRING_BEAN_NAME_KEYWORD = "";

    public static final ExpressQueryBulderFactory factory = new ExpressQueryBulderFactory();

    public ExpressQueryBuilder build() {
        return (ExpressQueryBuilder) SpringBeanBroker.getBeanFactory()
                .getBean(SPRING_BEAN_NAME_STANDARD);
    }

    public MenuMineMasterFoodExpressQueryBuilder buildMasterFoodExpress() {
        return (MenuMineMasterFoodExpressQueryBuilder) SpringBeanBroker.getBeanFactory()
                .getBean(SPRING_BEAN_NAME_MASTERFOODEXPRESS);
    }
}
