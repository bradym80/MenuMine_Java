/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.masterfood;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

public class DistinctQueryBuilderBroker extends AbstractSpringObjectFactory {

    public static DistinctQueryBuilder getInstance() {
        return (DistinctQueryBuilder) new DistinctQueryBuilderBroker().build(DistinctQueryBuilder.SPRING_BEAN_NAME);
    }
}
