/*
 * Created on Jul 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import junit.framework.TestCase;

/**
 * @author Nick
 * 
 *  
 */
public class ChainMapImageTest extends TestCase {

    public ChainMapImageTest() {
        super();

    }

    public void testImage() throws Exception {

        File src = new File("C:\\java\\eclipse3Data\\menumine\\web\\ui\\img\\map.gif");
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
        BufferedImage bimage2 = new BufferedImage(
                (int) (bi.getWidth() * scale), (int) (bi.getHeight() * scale),
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = (Graphics2D) bimage2.getGraphics();

        Font font = new Font("Optima, Lucida, 'MgOpen Cosmetica', 'Lucida Sans Unicode', sans-serif", Font.BOLD, 10);
        g2.setFont(font);
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = font.getLineMetrics("Test Txt", frc);

        g2.drawImage(bi, 0, 0, new JFrame());
        g2.drawString("West", 50, 50);
        g2.drawString("5000", 50, 60);

        g2.drawString("Midwest", 200, 110);
        g2.drawString("4000", 200, 120);

        g2.drawString("NorthEast", 300, 110);
        g2.drawString("3000", 300, 120);

        g2.drawString("South", 250, 200);
        g2.drawString("2000", 250, 210);

        //        File out = new File("c:\\temp\\myNewImage.gif");
        //
        //        if (out.exists())
        //            out.delete();
        //bimage2.getGraphics().drawLine(0,0,100,100);
        //        ImageIO.write(bimage2, "jpg", new File("c:\\temp\\myNewImage.jpg"));
        ImageIO.write(bimage2, "png", new File("c:\\temp\\myNewImage.png"));

    }

}