/*
 * Created on Sep 13, 2006 by Reid
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

import com.fsrin.menumine.core.chainmap.ChainMapTable;
import com.fsrin.menumine.core.menumine.webwork.util.GraphWriterUtilFactory;

public class MapByCensusBuilder {

    public String build(ChainMapTable chainMapTable, String baseMapPath) throws Exception {
        
       

//        ChainMapTable chainMapTable = this.getData();
        File src = new File(baseMapPath);

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

        Graphics2D g2 = (Graphics2D) bi.getGraphics();

//        BufferedImage bimage2 = g2base.getDeviceConfiguration()
//                .createCompatibleImage(bi.getWidth(), bi.getHeight(),
//                        Transparency.TRANSLUCENT);
//
//        Graphics2D g2 = (Graphics2D) bimage2.getGraphics();

//        bimage2.getGraphics().setColor(Color.CYAN);

        Font font = new Font("Optima, Lucida, 'MgOpen Cosmetica', 'Lucida Sans Unicode', sans-serif", Font.BOLD, 20);
        g2.setFont(font);

        // g2.drawImage(bi, 0, 0, new JFrame());
        g2.drawImage(bi, 0, 0, null);

//        Rectangle r = new Rectangle(0, 0, 300, 300);

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
        
        g2.setPaint(Color.WHITE);
        
        String fileName = new GraphWriterUtilFactory().build().write(bi);
        
        return fileName;
        //  ImageIO.write(bimage2, "jpg", new File("c:\\temp\\myNewImage.jpg"));        
        
        
        
    }

}
