/*
 * Created on Jan 13, 2006
 *
 */
package com.fsrin.menumine.core.chainmap.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;

public class AbstractChainMapAction extends
        AbstractMenuMineSessionContextAwareAction implements
        ChainMapContextAware, ChainMapWebOptionsAware {

    private ChainMapWebOptions chainMapWebOptions;

    private ChainMapContext chainMapContext;

    /**
     * @return Returns the chainMapContext.
     */
    public ChainMapContext getChainMapContext() {
        return chainMapContext;
    }

    /**
     * @param chainMapContext The chainMapContext to set.
     */
    public void setChainMapContext(ChainMapContext chainMapContext) {
        this.chainMapContext = chainMapContext;
    }

    /**
     * @return Returns the chainMapWebOptions.
     */
    public ChainMapWebOptions getChainMapWebOptions() {
        return chainMapWebOptions;
    }

    /**
     * @param chainMapWebOptions The chainMapWebOptions to set.
     */
    public void setChainMapWebOptions(ChainMapWebOptions chainMapWebOptions) {
        this.chainMapWebOptions = chainMapWebOptions;
    }

}
