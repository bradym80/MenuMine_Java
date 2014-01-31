/*
 * Created on Aug 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.fsrin.menumine.core.chainmap.ChainMapTable;
import com.fsrin.menumine.core.chainmap.StateIntencityVo;
import com.fsrin.menumine.core.menumine.webwork.util.GraphWriterUtilFactory;

/**
 * @author Nick
 * 
 *  
 */
public class MapByStateBuilder {



    public String build(ChainMapTable chainMapTable, String baseMapPath) throws Exception {

        Map stateIntensityMap = chainMapTable.getStateIntensityMap();
        
        BufferedImage baseImage = this.buildImage(baseMapPath);

        Graphics2D g2base = (Graphics2D) baseImage.getGraphics();

        BufferedImage outImage = g2base.getDeviceConfiguration()
                .createCompatibleImage(baseImage.getWidth(),
                        baseImage.getHeight(), Transparency.TRANSLUCENT);

        Graphics2D g2 = (Graphics2D) outImage.getGraphics();

        Font font = new Font("Optima, Lucida, 'MgOpen Cosmetica', 'Lucida Sans Unicode', sans-serif", Font.BOLD, 20);
        g2.setFont(font);

        int red = 0;
        int blue = 0;
        int green = 0;

        HashMap map = new HashMap();
        //2006-01-17 RSC ???
//        Random r = new Random(new Date().getTime());
        for (int y = 0; y < baseImage.getHeight(); ++y) {
            for (int x = 0; x < baseImage.getWidth(); ++x) {

                int srcPixel = baseImage.getRGB(x, y);

                /*
                 * We don't need to process the bottem 100 pixels as they are
                 * for the legend. If we process the legend it will not look
                 * nice.
                 */
                if (srcPixel != 16777215 && srcPixel != -1
                        && y < baseImage.getHeight() - 100) {


                    Color srcColor = new Color(srcPixel);
                    //                    red = srcColor.getRed();
                    //                    green = srcColor.getGreen();
                    //                    blue = srcColor.getBlue();

                    String state = this.getState(srcColor);

                    if (state != null) {
                        StateIntencityVo stateIntencityVo = (StateIntencityVo) stateIntensityMap
                                .get(state);

                        if (stateIntencityVo != null) {
                            int intensity = stateIntencityVo.getMyIntensity();

                            Color newColor = this.getNewColor(intensity);

                            outImage.setRGB(x, y, newColor.getRGB());
                        } else {
                            int intensity = 0;

                            Color newColor = this.getNewColor(intensity);

                            outImage.setRGB(x, y, newColor.getRGB());
                        }
                    } else {

                        if (map.containsKey(new Integer(srcPixel))) {

                            Integer i = (Integer) map
                                    .get(new Integer(srcPixel));
                            map.put(new Integer(srcPixel), new Integer(i
                                    .intValue() + 1));
                        } else {
                            map.put(new Integer(srcPixel), new Integer(1));
                        }

                        //   outImage.setRGB(x, y, srcPixel);
                        outImage.setRGB(x, y, Color.BLACK.getRGB());

                    }

                } else {
                    /*
                     * This handles the legend
                     */
                    outImage.setRGB(x, y, srcPixel);
                }
            }
        }

        /*
         * Uncomment if the colors are off. This will list the colors found that
         * do not map to a state along with # of time is appeared
         */
        //                for (Iterator iter = map.keySet().iterator(); iter.hasNext();) {
        //                    Integer element = (Integer) iter.next();
        //                    Color c = new Color(element.intValue());
        //        
        //                    Integer i = (Integer) map.get(element);
        //        
        //                   
        //                    System.out.println("Red " + c.getRed() + " Green: " + c.getGreen()
        //                            + " Blue: " + c.getBlue() + " Integer: " + i.intValue());
        //                 
        //                }
       // return outImage;
        
        String fileName = new GraphWriterUtilFactory().build().write(outImage);
        
        return fileName;
    }

    private Color getNewColor(int intensity) {

        if (intensity == 5) {
            return Color.RED;
        } else if (intensity == 4) {
            return Color.PINK;
        } else if (intensity == 3) {
            return Color.ORANGE;
        } else if (intensity == 2) {
            return Color.YELLOW;
        } else if (intensity == 1) {
            return Color.CYAN;
        } else if (intensity == 0) {
            return Color.BLUE;
        }

        return null;
    }

    private String getState(Color srcColor) {

        return StateColorMap.getState(srcColor);

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


}