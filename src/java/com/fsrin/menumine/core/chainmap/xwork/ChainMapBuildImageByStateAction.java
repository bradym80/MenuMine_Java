/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.fsrin.menumine.core.chainmap.ChainMapTable;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 *  
 */
public class ChainMapBuildImageByStateAction extends AbstractChainMapAction {

//    private ChainMapContext chainMapContext;

    private MapByStateBuilder chainMapImageBuilder = new MapByStateBuilder();

    public String execute() throws Exception {

        return super.execute();
    }

//    public ChainMapContext getChainMapContext() {
//        return chainMapContext;
//    }
//
//    public void setChainMapContext(ChainMapContext chainMapContext) {
//        this.chainMapContext = chainMapContext;
//    }

    public ChainMapTable getData() {
        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        ChainMapTable table = (ChainMapTable) stack.findValue("chainMapTable");

        return table;
    }

    private BufferedImage buildImage(String file) {
        File srcA = new File(file);

        if (!srcA.exists()) {
            throw new RuntimeException("File doesn't exist!");
        }

        BufferedImage biA = null;
        try {
            biA = ImageIO.read(srcA);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return biA;
    }

//    public BufferedImage getImage() throws Exception {
//
//        HashMap map = this.getStateIntensityMap();
//
//        BufferedImage bi = this.getChainMapImageBuilder().buildByState(map);
//        return bi;
//    }

    /*
     * Returns a map whose key is the state abbrivaition and whose value is
     * StateIntencityVo, which combines the intencity with
     * ChainMapTableLineItem.
     */
    public HashMap getStateIntensityMap() {

        ChainMapTable chainMapTable = this.getData();
        HashMap map = chainMapTable.getStateIntensityMap();

        return map;
    }

    public Collection getStateIntensityList() {
        return this.getStateIntensityMap().values();
    }

    public MapByStateBuilder getChainMapImageBuilder() {
        return chainMapImageBuilder;
    }

    public void setChainMapImageBuilder(
            MapByStateBuilder chainMapImageBuilder) {
        this.chainMapImageBuilder = chainMapImageBuilder;
    }
}