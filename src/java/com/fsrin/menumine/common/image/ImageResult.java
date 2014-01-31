/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.common.image;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.Result;

/**
 * @author Nick
 * 
 *  
 */
public class ImageResult implements Result {

    private int width;

    private int height;

    public void execute(ActionInvocation invocation) throws Exception {
        BufferedImage bufferedImage = (BufferedImage) invocation.getStack()
                .findValue("image");

        if (bufferedImage != null) {
            HttpServletResponse response = ServletActionContext.getResponse();
            OutputStream os = response.getOutputStream();

            ImageIO.write(bufferedImage, "png", os);

            // ChartUtilities.writeChartAsPNG(os, chart, width, height);
            os.flush();
        }
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}