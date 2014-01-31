/*
 * Created on Jun 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.xwork;


/**
 * @author Nick
 * 
 *  
 */
public class SectorSegmentChainDelegate {

//    public ChainStatServiceDelegate chainStatServiceDelegate;
//
//    public SectorSegmentChainDelegate() {
//        super();
//
//    }
//
//    /*
//     * Since this data is static we can define it as singleton in the spring
//     * context to avoid building it repetedly.
//     */
//    private SectorSegmentChain sectorSegmentChain = null;
//
//    public SectorSegmentChain getSectorSegmentChain() {
//
//        if (this.sectorSegmentChain == null) {
//            try {
//                this.buildSectorSegmentChain();
//            } catch (ChainStatSearchException e) {
//                e.printStackTrace();
//            }
//        }
//        return this.sectorSegmentChain;
//
//    }
//
//    private void buildSectorSegmentChain() throws ChainStatSearchException {
//
//        Collection chains = this.getChainStatServiceDelegate().find(
//                new ChainStatFilterParameters());
//        SectorSegmentChain sectorSegmentChain = new SectorSegmentChain();
//
//        for (Iterator iter = chains.iterator(); iter.hasNext();) {
//            ChainStat element = (ChainStat) iter.next();
//            sectorSegmentChain.addChain(element);
//        }
//
//        this.sectorSegmentChain = sectorSegmentChain;
//    }
//
//    public ChainStatServiceDelegate getChainStatServiceDelegate() {
//        return chainStatServiceDelegate;
//    }
//
//    public void setChainStatServiceDelegate(
//            ChainStatServiceDelegate chainStatServiceDelegate) {
//        this.chainStatServiceDelegate = chainStatServiceDelegate;
//    }
}