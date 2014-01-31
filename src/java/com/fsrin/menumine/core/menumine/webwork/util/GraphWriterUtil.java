/*
 * Created on May 5, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.common.util.MiscellaneousNotificationAlert;

public class GraphWriterUtil {

    private String graphPrefix;

    private String tempFilePath;

    public String write(JFreeChart chart) throws IOException {

        
        /*
         * 2006-05-04 RSC Joe had an error condition like this--not sure how he
         * got it.
         */
        if (chart == null) {
            return null;
        }

        Date create = new Date();

        Random r = new Random(create.getTime());

        String fileName = create.getTime() + "-" + r.nextLong() + ".png";

        File file = new File(this.getTempFilePath() + fileName);

        /*
         * 2006-05-02 RSC very slim chance.
         */
        if (file.exists()) {
            file.delete();
        }

        ChartUtilities.saveChartAsPNG(file, chart, 800, 600);

        try {
            handleDirectoryCleanUp();
        } catch (Exception e) {
            new MiscellaneousNotificationAlert()
                    .sendAlert("Attempted to clean up the graph directory but failed.");
        }
        
        return this.getGraphPrefix() + fileName;
    }

    public String write(BufferedImage chart) throws IOException {

        
        /*
         * 2006-05-04 RSC Joe had an error condition like this--not sure how he
         * got it.
         */
        if (chart == null) {
            return null;
        }

        Date create = new Date();

        Random r = new Random(create.getTime());

        String fileName = create.getTime() + "-" + r.nextLong() + ".png";

        File file = new File(this.getTempFilePath() + fileName);

        /*
         * 2006-05-02 RSC very slim chance.
         */
        if (file.exists()) {
            file.delete();
        }

        ImageIO.write(chart, "png", file);

        try {
            handleDirectoryCleanUp();
        } catch (Exception e) {
            new MiscellaneousNotificationAlert()
                    .sendAlert("Attempted to clean up the graph directory but failed.");
        }
        
        return this.getGraphPrefix() + fileName;
    }
    
    /*
     * 2006-05-02 RSC basically want to delete anything that's over an hour old.
     */
    private void handleDirectoryCleanUp() {

        long deleteBefore = new Date().getTime() - 1 * 60 * 1000;

        File dir = new File(this.getTempFilePath());

        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].lastModified() < deleteBefore
                    && files[i].getName().indexOf(".html") == -1) {
                files[i].delete();
            }
        }

    }

    public String getGraphPrefix() {
        return graphPrefix;
    }

    public void setGraphPrefix(String imagePrefix) {
        this.graphPrefix = imagePrefix;
    }

    public String getTempFilePath() {
        return tempFilePath;
    }

    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }
}
