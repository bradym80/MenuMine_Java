/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.chainmap.ChainMapTable;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.util.OgnlValueStack;

//TODO should be deleted?

/**
 * 2006-01-13 
 * @author Reid
 * @author Nick
 * 
 *  
 */
public class CopyOfChainMapBuildImageByStateAction extends ActionSupport
        implements ChainMapContextAware {

    private ChainMapContext chainMapContext;

    //     private String map =
    //     "/var/tomcat/jakarta-tomcat-5.5.9/webapps/menumine/img/USAmap.gif";

    private String mapA = "C:\\java\\eclipse3Data\\menumine\\chainmapimg\\USAmapA.gif";

    private String mapB = "C:\\java\\eclipse3Data\\menumine\\chainmapimg\\USAmapB.gif";

    private String mapCA1 = "C:\\java\\eclipse3Data\\menumine\\chainmapimg\\CA1.gif";

    private String mapCA2 = "C:\\java\\eclipse3Data\\menumine\\chainmapimg\\CA2.gif";

    private String mapNV1 = "C:\\java\\eclipse3Data\\menumine\\chainmapimg\\NV1.gif";

    public String execute() throws Exception {

        return super.execute();
    }

    public ChainMapContext getChainMapContext() {
        return chainMapContext;
    }

    public void setChainMapContext(ChainMapContext chainMapContext) {
        this.chainMapContext = chainMapContext;
    }

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

    public BufferedImage getImage() throws Exception {

        ChainMapTable chainMapTable = this.getData();

        chainMapTable.getStates();

        BufferedImage biA = null;
        biA = buildImage(this.getMapA());

        BufferedImage biB = null;
        biB = buildImage(this.getMapB());

        BufferedImage biCA1 = null;
        biCA1 = buildImage(this.getMapCA1());
        BufferedImage biCA2 = null;
        biCA2 = buildImage(this.getMapCA2());

        BufferedImage biNV1 = null;
        biNV1 = buildImage(this.getMapNV1());

        float scale = 1.00f;
        /*
         * Getting the Ge throws a headless exception.
         */
        //        GraphicsEnvironment ge = GraphicsEnvironment
        //                .getLocalGraphicsEnvironment();
        //        GraphicsDevice gs = ge.getDefaultScreenDevice();
        //
        //        GraphicsConfiguration gc = gs.getDefaultConfiguration();
        //
        //        BufferedImage bimage2 = gc.createCompatibleImage(biA.getWidth(), biA
        //                .getHeight(), Transparency.BITMASK);
        //        Graphics2D g2 = (Graphics2D) bimage2.getGraphics();
        Graphics2D g2base = (Graphics2D) biA.getGraphics();

        BufferedImage bimage2 = g2base.getDeviceConfiguration()
                .createCompatibleImage(biA.getWidth(), biA.getHeight(),
                        Transparency.TRANSLUCENT);

        Graphics2D g2 = (Graphics2D) bimage2.getGraphics();

        Font font = new Font("Optima, Lucida, 'MgOpen Cosmetica', 'Lucida Sans Unicode', sans-serif", Font.BOLD, 20);
        g2.setFont(font);

        // g2.drawImage(bi, 0, 0, new JFrame());

        //  g2.drawImage(biA, 0, 0, null);

        // g2.drawImage(biB, 0, 0, null);

        int w = biNV1.getWidth();
        int h = biNV1.getHeight();

        //BufferedImage dst = new BufferedImage(w, h,
        // BufferedImage.TYPE_INT_RGB);
        BufferedImage dst = g2base.getDeviceConfiguration()
                .createCompatibleImage(biA.getWidth(), biA.getHeight(),
                        Transparency.TRANSLUCENT);

        int red = 0;
        int blue = 0;
        int green = 0;

        HashMap map = new HashMap();

        for (int y = 0; y < biNV1.getHeight(); ++y) {
            for (int x = 0; x < biNV1.getWidth(); ++x) {

                int srcPixel = biNV1.getRGB(x, y);

                if (srcPixel != 16777215) {
                    map.put(new Integer(srcPixel), new Integer(srcPixel));

                    //                    red = 255 * (srcPixel & 0x00FF0000 >> 16) / 255;
                    //                    green = 255 * (srcPixel & 0x0000FF00 >> 8) / 255;
                    //                    blue = 0 * (srcPixel & 0x000000FF) / 255;

                    //   System.out.println("Red "+ red+ " Green: "+ green+" Blue:
                    // "+blue);
                    //  dst.setRGB(x, y, red << 16 | green << 8 | blue);

                    // int newSrc = red << 16 | green << 8 | blue;

                    //                    if (srcPixel == new Color(153, 153, 153).getRGB()) {
                    //                        Color c = Color.BLACK;
                    //                        dst.setRGB(x, y, c.getRGB());
                    //
                    //                    } else if (srcPixel == new Color(51, 102, 153).getRGB())
                    // {
                    //                        Color c = Color.BLACK;
                    //                        dst.setRGB(x, y, c.getRGB());
                    //
                    //                    } else if (srcPixel == new Color(51, 51, 102).getRGB()) {
                    //                        Color c = Color.BLACK;
                    //                        dst.setRGB(x, y, c.getRGB());
                    //
                    //                    } else
                    if (srcPixel == new Color(153, 0, 0).getRGB()) {
                        Color c = Color.RED;
                        dst.setRGB(x, y, c.getRGB());
                    } else {
                        dst.setRGB(x, y, srcPixel);
                    }
                    //                    } else if (srcPixel == new Color(0, 0, 51).getRGB()) {
                    //                        Color c = Color.BLACK;
                    //                        dst.setRGB(x, y, c.getRGB());
                    //
                    //                    }

                }
            }
        }

        for (Iterator iter = map.values().iterator(); iter.hasNext();) {
            Integer element = (Integer) iter.next();
            Color c = new Color(element.intValue());
           LogFactory.getLog(this.getClass()).debug(element + "Red " + c.getRed() + " Green: "
                    + c.getGreen() + " Blue: " + c.getBlue());
        }

        g2.drawImage(dst, 0, 0, null);

        g2.drawImage(biCA2, 0, 0, null);

        Paint p = Color.BLACK;
        g2.setPaint(p);

        DecimalFormat format = new DecimalFormat("###0.0");

        if (chainMapTable != null) {
            g2.drawString("West", 190, 170);
            g2.drawString(chainMapTable.getWestCount().getChainCount()
                    .toString(), 200, 190);
            g2.drawString(format.format(chainMapTable.getWestCount()
                    .getChainPercent())
                    + "%", 200, 210);

            g2.drawString("Midwest", 370, 200);
            g2.drawString(chainMapTable.getMidwestCount().getChainCount()
                    .toString(), 380, 220);
            g2.drawString(format.format(chainMapTable.getMidwestCount()
                    .getChainPercent())
                    + "%", 380, 240);

            g2.drawString("NorthEast", 490, 90);
            g2.drawString(chainMapTable.getNorthEastCount().getChainCount()
                    .toString(), 500, 110);
            g2.drawString(format.format(chainMapTable.getNorthEastCount()
                    .getChainPercent())
                    + "%", 500, 130);

            g2.drawString("South", 340, 280);
            g2.drawString(chainMapTable.getSouthCount().getChainCount()
                    .toString(), 350, 300);
            g2.drawString(format.format(chainMapTable.getSouthCount()
                    .getChainPercent())
                    + "%", 350, 320);

        }
        return bimage2;
        //  ImageIO.write(bimage2, "jpg", new File("c:\\temp\\myNewImage.jpg"));

    }

    public String getMapA() {
        return mapA;
    }

    public void setMapA(String mapA) {
        this.mapA = mapA;
    }

    public String getMapB() {
        return mapB;
    }

    public void setMapB(String mapB) {
        this.mapB = mapB;
    }

    public String getMapCA1() {
        return mapCA1;
    }

    public void setMapCA1(String mapCA1) {
        this.mapCA1 = mapCA1;
    }

    public String getMapCA2() {
        return mapCA2;
    }

    public void setMapCA2(String mapCA2) {
        this.mapCA2 = mapCA2;
    }

    public String getMapNV1() {
        return mapNV1;
    }

    public void setMapNV1(String mapNV1) {
        this.mapNV1 = mapNV1;
    }
}