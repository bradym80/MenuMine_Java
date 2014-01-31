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
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.chainmap.ChainMapTable;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * 
 *  
 */
public class ChainMapBuildImageAction extends ActionSupport implements
        ChainMapContextAware {

	private static Log log = LogFactory.getLog(ChainMapBuildImageAction.class);
	
    private ChainMapContext chainMapContext;

    //     private String map =
    //     "/var/tomcat/jakarta-tomcat-5.5.9/webapps/menumine/img/USAmap.gif";

    private String map;//=
                       // "C:\\java\\eclipse3Data\\menumine\\chainmapimg\\USAmap.gif";

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

    public BufferedImage getImage() throws Exception {
    	
    		log.debug("looking for image src: " + this.getMap());

        ChainMapTable chainMapTable = this.getData();
        File src = new File(this.getMap());

        if (!src.exists()) {
            throw new RuntimeException("File doesn't exist!");
        }

        BufferedImage bi = null;
        try {
            bi = ImageIO.read(src);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        float scale = 1.00f;

        Graphics2D g2base = (Graphics2D) bi.getGraphics();

        BufferedImage bimage2 = g2base.getDeviceConfiguration()
                .createCompatibleImage(bi.getWidth(), bi.getHeight(),
                        Transparency.TRANSLUCENT);

        Graphics2D g2 = (Graphics2D) bimage2.getGraphics();

        bimage2.getGraphics().setColor(Color.CYAN);

        Font font = new Font("Optima, Lucida, 'MgOpen Cosmetica', 'Lucida Sans Unicode', sans-serif", Font.BOLD, 20);
        g2.setFont(font);

        // g2.drawImage(bi, 0, 0, new JFrame());
        g2.drawImage(bi, 0, 0, null);

        Rectangle r = new Rectangle(0, 0, 300, 300);

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

    public String getMap() {
        return map.trim();
    }

    public void setMap(String map) {
        this.map = map;
    }
}